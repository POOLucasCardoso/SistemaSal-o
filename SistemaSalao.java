import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.IOException;

public class SistemaSalao {
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private List<Funcionario> funcionarios;
	private List<Servico> servicos;
	public  LinkedList<Apontamento> agenda;
	private Gravador file;

	public SistemaSalao() {

		Servico servico;
		
		Cliente cliente;
		
		file = new Gravador();

		LinkedList<String> temp = new LinkedList<String>();

		String[] data;

		this.clientes = new ArrayList<Cliente>();

		try {
			
			temp = file.load("clientes.txt");
			
			for (String s : temp) {
				
				data = s.split("#");
				
				cliente = new Cliente(new Contato(data[0], data[1]), new Endereco(data[2], data[3], data[4], data[5], data[6], data[7], data[8]), data[9], data[10]);
				
				if(data[11]=="T") {
					
					cliente.setEhInadinplente(true);
					
				}else {
					
					cliente.setEhInadinplente(false);
					
				}

				clientes.add(cliente);

			}

		} catch (Exception e) {}

		this.produtos = new ArrayList<Produto>();

		try {

			temp = file.load("produtos.txt");
			
			for (String s : temp) {

				data = s.split("#");

				produtos.add(new Produto(data[0], data[1], data[2], Double.parseDouble(data[3])));

			}

		} catch (Exception e) {}

		this.funcionarios = new ArrayList<Funcionario>();

		try {

			temp = file.load("funcionarios.txt");

			for (String s : temp) {

				data = s.split("#");

				funcionarios.add(new Funcionario(data[0], data[1], data[2], new Contato(data[3], data[4]),
						new Endereco(data[5], data[6], data[7], data[8], data[9], data[10], data[11])));

			}

		} catch (Exception e) {}

		this.servicos = new LinkedList<Servico>();

		try {

			temp = file.load("servicos.txt");

			for (String s : temp) {

				data = s.split("#");

				servico = new Servico(data[0], Double.parseDouble(data[1]));

				Produto produto;

				for (int i = 2; i < data.length; i += 2) {

					produto = this.pesquisaProduto(data[i], data[i + 1]);

					servico.addProduto(produto);
					
				}
						
				servicos.add(servico);

			}

		} catch (Exception e) {}

		this.agenda = new LinkedList<Apontamento>();

		try {

			temp = file.load("agenda.txt");

			Funcionario funcionario;

			for (String s : temp) {

				data = s.split("#");

				cliente = this.pesquisaCliente(data[0]);

				funcionario = this.pesquisaFuncionario(data[1]);

				servico = this.pesquisaServico(data[2]);

				agenda.add(new Apontamento(data[3], data[4], cliente, funcionario, servico));

			}

		} catch (Exception e) {}

	}

	public int quantClientes() {
		return this.clientes.size();
	}

	public int quantProdutos() {
		return this.produtos.size();
	}

	public int quantFuncionarios() {
		return this.funcionarios.size();
	}

	public List<Cliente> clientesInad() {
		List<Cliente> clientesInadiplente = new ArrayList<Cliente>();
		for (int k = 0; k < this.clientes.size(); k++) {
			if (this.clientes.get(k).isEhInadimplente()) {
				clientesInadiplente.add(this.clientes.get(k));
			}
		}
		return clientesInadiplente;
	}

	public Cliente[] todosClientes() {
		Cliente[] todos = new Cliente[quantClientes()];
		for (int k = 0; k < this.clientes.size(); k++) {
			todos[k] = this.clientes.get(k);
		}
		return todos;
	}

	public Produto[] todosProdutos() {
		Produto[] todos = new Produto[quantProdutos()];
		for (int k = 0; k < this.produtos.size(); k++) {
			todos[k] = this.produtos.get(k);
		}
		return todos;
	}

	public List<Produto> produtosDeUmTipo(String tipo) {
		List<Produto> produtos = new ArrayList<Produto>();
		for (int k = 0; k < this.produtos.size(); k++) {
			if (this.produtos.get(k).getTipo().equals(tipo)) {
				produtos.add(this.produtos.get(k));
			}
		}
		return produtos;
	}

	public Funcionario[] todosFuncionarios() {
		Funcionario[] todos = new Funcionario[quantFuncionarios()];
		for (int k = 0; k < this.funcionarios.size(); k++) {
			todos[k] = this.funcionarios.get(k);
		}
		return todos;
	}

	public void cadastraCliente(Cliente cliente) throws JaExisteException {
		for (int k = 0; k < this.clientes.size(); k++) {
			if (this.clientes.get(k).equals(cliente)) {
				throw new JaExisteException("Usuario J� Cadastrado");
			}
		}
		this.clientes.add(cliente);
	}

	public void cadastraProduto(Produto produto) throws JaExisteException {
		for (int k = 0; k < this.produtos.size(); k++) {
			if (this.produtos.get(k).equals(produto)) {
				throw new JaExisteException("Produto j� Cadastrado");
			}
		}
		this.produtos.add(produto);
	}

	public void cadastraFuncionario(Funcionario funcionario) throws JaExisteException {
		for (int k = 0; k < this.funcionarios.size(); k++) {
			if (this.funcionarios.get(k).equals(funcionario)) {
				throw new JaExisteException("Funcionario J� Cadastrado");
			}
		}
		this.funcionarios.add(funcionario);
	}

	public Cliente pesquisaCliente(String cpf) throws NaoExisteException {
		for (int k = 0; k < this.clientes.size(); k++) {
			if (this.clientes.get(k).getCPF().equals(cpf)) {
				return this.clientes.get(k);
			}
		}
		throw new NaoExisteException("N�o existe este cliente");
	}

	public Funcionario pesquisaFuncionario(String cpf) throws NaoExisteException {
		for (int k = 0; k < this.funcionarios.size(); k++) {
			if (this.funcionarios.get(k).getCPF().equals(cpf)) {
				return this.funcionarios.get(k);
			}
		}
		throw new NaoExisteException("N�o Existe este funcion�rio");
	}

	public Produto pesquisaProduto(String nome, String marca) throws NaoExisteException {
		for (int k = 0; k < this.produtos.size(); k++) {
			if (this.produtos.get(k).getNome().equals(nome) && this.produtos.get(k).getMarca().equals(marca)) {
				return this.produtos.get(k);
			}
		}
		throw new NaoExisteException("N�o Existe este produto");
	}

	public void removeCliente(String CPF) throws NaoExisteException {

		boolean boo = true;

		for (Cliente c : this.clientes) {

			if (c.getCPF().equals(CPF)) {

				this.clientes.remove(c);

				boo = false;

				break;

			}

		}

		if (boo) {

			throw new NaoExisteException("N�o existe nenhum cliente cadastrado com esse CPF");

		}

	}

	public void removeFuncionario(String CPF) throws NaoExisteException {

		boolean boo = true;

		for (Funcionario f : this.funcionarios) {

			if (f.getCPF().equals(CPF)) {

				this.clientes.remove(f);

				boo = false;

				break;

			}

		}

		if (boo) {

			throw new NaoExisteException("N�o existe nenhum funcion�rio cadastrado com esse CPF");

		}

	}

	public void removeProduto(String nome, String marca) throws NaoExisteException {

		boolean boo = true;

		for (Produto p : this.produtos) {

			if ((p.getNome() + p.getMarca()).equals(nome + marca)) {

				this.clientes.remove(p);

				boo = false;

				break;

			}

		}

		if (boo) {

			throw new NaoExisteException("N�o existe nenhum produto cadastrado dessa marca com este nome.");

		}

	}

	public void agendar(Apontamento apontamento) throws JaExisteException {

		for (Apontamento a : agenda) {

			if (a.equals(apontamento)) {

				throw new JaExisteException("Apontamento j� agendado");

			}

		}

		this.agenda.add(apontamento);

	}

	public void desagendar(Apontamento apontamento) throws NaoExisteException {

		boolean boo = true;

		for (Apontamento a : this.agenda) {

			if (a.equals(apontamento)) {

				this.agenda.remove(a);

				boo = false;

				break;

			}

		}

		if (boo) {

			throw new NaoExisteException("N�o existe nenhum apontamento como esse registrado.");

		}

	}

	public void atualizarCliente(Cliente cliente) {

		for (Cliente c : clientes) {

			if (c.equals(cliente)) {

				c = cliente;

			}

		}

	}

	public void cadastraServico(Servico servico) throws JaExisteException {
		for (int k = 0; k < this.servicos.size(); k++) {
			if (this.servicos.get(k).equals(servico)) {
				throw new JaExisteException("Servi�o j� Cadastrado");
			}
		}
		this.servicos.add(servico);
	}

	public Servico pesquisaServico(String tipo) throws NaoExisteException {
		for (int k = 0; k < this.servicos.size(); k++) {
			if (this.servicos.get(k).getTipo().equals(tipo)) {
				return this.servicos.get(k);
			}
		}
		throw new NaoExisteException("N�o Existe");
	}

	public void removeServico(String tipo) throws NaoExisteException {

		boolean boo = true;

		for (Servico s : this.servicos) {

			if (s.getTipo().equals(tipo)) {

				this.clientes.remove(s);

				boo = false;

				break;

			}

		}

		if (boo) {

			throw new NaoExisteException("N�o existe nenhum servi�o cadastrado com este nome.");

		}

	}

	public void finaliza() throws IOException {

		String texto;

		LinkedList<String> clientes = new LinkedList<String>();

		for (Cliente c : this.clientes) {
			
			texto = "";
			
			texto += c.getContatos().getEmail() + "#";
			texto += c.getContatos().getNumero() + "#";
			texto += c.getEndereco().getPais() + "#";
			texto += c.getEndereco().getEstado() + "#";
			texto += c.getEndereco().getCidade() + "#";
			texto += c.getEndereco().getBairo() + "#";
			texto += c.getEndereco().getRua() + "#";
			texto += c.getEndereco().getNumero() + "#";
			texto += c.getEndereco().getCEP() + "#";
			texto += c.getNome() + "#";
			texto += c.getCPF() + "#";

			if (c.isEhInadimplente()) {

				texto += "T";

			} else {

				texto += "F";

			}

			clientes.add(texto + "\n");

		}

		LinkedList<String> funcionarios = new LinkedList<String>();

		for (Funcionario f : this.funcionarios) {
			
			texto = "";

			texto += f.getTipo() + "#";
			texto += f.getNome() + "#";
			texto += f.getCPF() + "#";
			texto += f.getContatos().getEmail() + "#";
			texto += f.getContatos().getNumero() + "#";
			texto += f.getEndereco().getPais() + "#";
			texto += f.getEndereco().getEstado() + "#";
			texto += f.getEndereco().getCidade() + "#";
			texto += f.getEndereco().getBairo() + "#";
			texto += f.getEndereco().getRua() + "#";
			texto += f.getEndereco().getNumero() + "#";
			texto += f.getEndereco().getCEP() + "\n";

			funcionarios.add(texto);

		}

		LinkedList<String> produtos = new LinkedList<String>();

		for (Produto p : this.produtos) {
			
			texto = "";

			texto += p.getMarca() + "#";
			texto += p.getTipo() + "#";
			texto += p.getNome() + "#";
			texto += p.getPreco() + "\n";

			produtos.add(texto);

		}

		LinkedList<String> servicos = new LinkedList<String>();

		for (Servico s : this.servicos) {
			
			texto = "";

			texto += s.getTipo() + "#";
			texto += s.getPreco() + "#";

			for (Produto p : s.getProdutosNecessario()) {

				texto += p.getNome() + "#";
				texto += p.getMarca() + "#";

			}

			servicos.add(texto+"\n");

		}

		LinkedList<String> agenda = new LinkedList<String>();

		for (Apontamento a : this.agenda) {
			
			texto = "";

			texto += a.getCliente().getCPF() + "#";
			texto += a.getFuncionario().getCPF() + "#";
			texto += a.getServico().getTipo() + "#";
			texto += a.getData() + "#";
			texto += a.getHora() + "\n";

			agenda.add(texto);

		}

		try {

			file.save(clientes, "clientes.txt");
			file.save(funcionarios, "funcionarios.txt");
			file.save(produtos, "produtos.txt");
			file.save(servicos, "servicos.txt");
			file.save(agenda, "agenda.txt");

		} catch (Exception e) {
			
			throw e;

		}

	}
	
	public String[] nomeServicos() {
		
		String[] texto = new String[this.servicos.size()];
		
		for(int i = 0; i<this.servicos.size(); i++) {
			
			texto[i]= this.servicos.get(i).getTipo(); 
			
		}
		
		return texto;
		
	}

}
