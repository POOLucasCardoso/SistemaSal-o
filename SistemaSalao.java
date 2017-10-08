import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
public class SistemaSalao {
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private List<Funcionario> funcionarios;
	private List<Servico> servicos;
	List<Apontamento> agenda;
	private Gravador file;
	
	public SistemaSalao(){
		
		Servico servico;
		
		LinkedList<String> temp = new LinkedList<String>();
		
		String[] data;
		
		this.clientes = new ArrayList<Cliente>();
		
		try {
			
			temp = file.load("clientes.txt");
			
		}catch(Exception e) {}
		
		for(String s: temp) {
		
			data = s.split("$");
			
			clientes.add(new Cliente(new Contato(data[0],data[1]),new Endereco(data[2],data[3],data[4],data[5],data[6],data[7],data[8]),data[9],data[10]));
		
		}
		
		this.produtos = new ArrayList<Produto>();
		
		try {
			
			temp = file.load("produtos.txt");
			
		}catch(Exception e) {}
		
		for(String s: temp) {
			
			data = s.split("$");
			
			produtos.add(new Produto(data[0],data[1],data[2],Double.parseDouble(data[3])));
			
		}
		
		this.funcionarios = new ArrayList<Funcionario>();

		try {
			
			temp = file.load("funcionarios.txt");
			
		}catch(Exception e) {}
		
		for(String s: temp) {
			
			data = s.split("$");
			
			funcionarios.add(new Funcionario(data[0],data[1],data[2],new Contato(data[3],data[4]),new Endereco(data[5],data[6],data[7],data[8],data[9],data[10],data[11])));
			
		}
		
		this.servicos = new LinkedList<Servico>();

		try {
			
			temp = file.load("servicos.txt");
			
		}catch(Exception e) {}

		for(String s: temp) {
			
			data = s.split("$");
			
			servico = new Servico(data[0],Double.parseDouble(data[1]));
			
			Produto produto;
			
			for(int i = 2; i<data.length; i+=2) {
				
				try{
					
					produto = this.pesquisaProduto(data[i], data[i+1]);
					
					servico.addProduto(produto);
					
				}catch(Exception e){};
				
			}
			
			servicos.add(servico);
			
		}
		
		this.agenda = new ArrayList<Apontamento>();

		try {
			
			temp = file.load("agenda.txt");
			
		}catch(Exception e) {}
		
		Cliente cliente;
		
		Funcionario funcionario;

		for(String s: temp) {
			
			data = s.split("$");
			
			try {
				
				cliente = this.pesquisaCliente(data[0]);
				
				funcionario = this.pesquisaFuncionario(data[1]);
				
				servico = this.pesquisaServico(data[2]);
				
				agenda.add(new Apontamento(data[3],data[4],cliente,funcionario,servico));
				
			}catch(Exception e){};
			
		}
		
	}
	
	public int quantClientes(){
		return this.clientes.size();
	}
	
	public int quantProdutos(){
		return this.produtos.size();
	}
	
	public int quantFuncionarios(){
		return this.funcionarios.size();
	}
	
	public List<Cliente> quantClientesInad(){
		List<Cliente> clientesInadiplente = new ArrayList<Cliente>();
		for(int k = 0; k < this.clientes.size(); k++){
			if(this.clientes.get(k).isEhInadimplente()){
				clientesInadiplente.add(this.clientes.get(k));
			}	
		}
		return clientesInadiplente;
	}
	
	public List<Cliente> todosClientes(){
		List<Cliente> todos = new ArrayList <Cliente>();
		for(int k = 0; k < this.clientes.size(); k++){
			todos.add(this.clientes.get(k));
		}
		return todos;
	}
	
	public List<Produto> todosProdutos(){
		List<Produto> todos = new ArrayList<Produto>();
		for(int k = 0; k<this.produtos.size(); k++){
			todos.add(this.produtos.get(k));
		}
		return todos;
	}
	
	public List<Produto> produtosDeUmTipo(String tipo){
		List<Produto> produtos = new ArrayList<Produto>();
		for(int k = 0; k < this.produtos.size(); k++){
			if(this.produtos.get(k).getTipo().equals(tipo)){
				produtos.add(this.produtos.get(k));
			}
		}
		return produtos;
	}
	
	public List<Funcionario> todosfuncionarios(){
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		for(int k = 0; k < this.funcionarios.size(); k++){
			funcionarios.add(this.funcionarios.get(k));
		}
		return funcionarios;
	}
 	
	public void cadastraCliente(Cliente cliente)throws JaExisteException{
			for(int k = 0; k<this.clientes.size(); k++){
				if(this.clientes.get(k).equals(cliente)){
					throw new JaExisteException("Usuario Já Cadastrado");
				}
			}
			this.clientes.add(cliente);
	}
	
	public void cadastraProduto(Produto produto) throws JaExisteException{
		for(int k = 0; k<this.produtos.size(); k++){
			if(this.produtos.get(k).equals(produto)){
				throw new JaExisteException("Produto já Cadastrado");
			}
		}
		this.produtos.add(produto);
	}
	
	public void cadastraFuncionario(Funcionario funcionario) throws JaExisteException{
		for(int k = 0; k < this.funcionarios.size(); k++){
			if(this.funcionarios.get(k).equals(funcionario)){
				throw new JaExisteException("Funcionario Já Cadastrado");
			}
		}
		this.funcionarios.add(funcionario);
	}
	
	public Cliente pesquisaCliente(String cpf) throws NaoExisteException{
		for(int k = 0; k<this.clientes.size(); k++){
			if(this.clientes.get(k).getCPF().equals(cpf)){
				return this.clientes.get(k);
			}
		}
		throw new NaoExisteException("Não existe");
	}
	
	public Funcionario pesquisaFuncionario(String cpf)throws NaoExisteException{
		for(int k = 0; k<this.funcionarios.size(); k++){
			if(this.funcionarios.get(k).getCPF().equals(cpf)){
				return this.funcionarios.get(k);
			}
		}
		throw new NaoExisteException("Não Existe");
	}
	
	public Produto pesquisaProduto(String nome, String marca) throws NaoExisteException{
		for(int k = 0; k < this.produtos.size(); k++){
			if(this.produtos.get(k).getNome().equals(nome)&&this.produtos.get(k).getMarca().equals(marca)){
				return this.produtos.get(k);
			}
		}
		throw new NaoExisteException("Não Existe");
	} 
	
	public void removeCliente(String CPF) throws NaoExisteException{
		
		boolean boo = true;
		
		for(Cliente c : this.clientes) {
			
			if (c.getCPF().equals(CPF)){
				
				this.clientes.remove(c);
				
				boo = false;
				
				break;
				
			}
			
		}
		
		if (boo) {
			
			throw new NaoExisteException("Não existe nenhum cliente cadastrado com esse CPF");
			
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

			throw new NaoExisteException("Não existe nenhum funcionário cadastrado com esse CPF");

		}

	}
	public void removeProduto(String nome,String marca) throws NaoExisteException {

		boolean boo = true;

		for (Produto p : this.produtos) {

			if ((p.getNome()+p.getMarca()).equals(nome+marca)) {

				this.clientes.remove(p);

				boo = false;

				break;

			}

		}

		if (boo) {

			throw new NaoExisteException("Não existe nenhum produto cadastrado dessa marca com este nome.");

		}

	}
	
	public void agendar(Apontamento apontamento) throws JaExisteException{
		
		for(Apontamento a : agenda) {
			
			if(a.equals(apontamento)) {
				
				throw new JaExisteException("Apontamento já agendado");
				
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

			throw new NaoExisteException("Não existe nenhum apontamento como esse registrado.");

		}

	}
	
	public void atualizarCliente(Cliente cliente) {
		
		for(Cliente c : clientes) {
			
			if(c.equals(cliente)) {
				
				c = cliente;
				
			}
			
		}
		
	}
	
	public void cadastraServico(Servico servico) throws JaExisteException{
		for(int k = 0; k<this.servicos.size(); k++){
			if(this.servicos.get(k).equals(servico)){
				throw new JaExisteException("Serviço já Cadastrado");
			}
		}
		this.servicos.add(servico);
	}
	
	public Servico pesquisaServico(String tipo) throws NaoExisteException{
		for(int k = 0; k < this.servicos.size(); k++){
			if(this.servicos.get(k).getTipo().equals(tipo)){
				return this.servicos.get(k);
			}
		}
		throw new NaoExisteException("Não Existe");
	} 
	
	public void removeServico(String tipo) throws NaoExisteException {

		boolean boo = true;

		for (Servico s: this.servicos) {

			if (s.getTipo().equals(tipo)) {

				this.clientes.remove(s);

				boo = false;

				break;

			}

		}

		if (boo) {

			throw new NaoExisteException("Não existe nenhum serviço cadastrado com este nome.");

		}

	}
	
	public void finaliza() {
		
		String texto = "";
		
		LinkedList<String> clientes = new LinkedList<String>();
		
		for(Cliente c: this.clientes) {
			
			texto += c.getContatos().getEmail()+"$";
			texto += c.getContatos().getNumero()+"$";
			texto += c.getEndereco().getPais()+"$";
			texto += c.getEndereco().getEstado()+"$";
			texto += c.getEndereco().getCidade()+"$";
			texto += c.getEndereco().getBairo()+"$";
			texto += c.getEndereco().getRua()+"$";
			texto += c.getEndereco().getNumero()+"$";
			texto += c.getEndereco().getCEP()+"$";
			texto += c.getNome()+"$";
			texto += c.getCPF()+"$";
			
			if (c.isEhInadimplente()) {
				
				texto+="T";
				
			}else {
				
				texto+="F";
				
			}
			
			clientes.add(texto);
			
		}
		
		LinkedList<String> funcionarios = new LinkedList<String>();
		
		texto = "";
		
		for(Funcionario f: this.funcionarios) {
			
			texto += f.getTipo();
			texto += f.getNome()+"$";
			texto += f.getCPF()+"$";
			texto += f.getContatos().getEmail()+"$";
			texto += f.getContatos().getNumero()+"$";
			texto += f.getEndereco().getPais()+"$";
			texto += f.getEndereco().getEstado()+"$";
			texto += f.getEndereco().getCidade()+"$";
			texto += f.getEndereco().getBairo()+"$";
			texto += f.getEndereco().getRua()+"$";
			texto += f.getEndereco().getNumero()+"$";
			texto += f.getEndereco().getCEP()+"$";
			
			funcionarios.add(texto);
			
		}
		
		LinkedList<String> produtos = new LinkedList<String>();
		
		texto = "";
		
		for(Produto p: this.produtos) {
			
			texto += p.getMarca()+"$";
			texto += p.getTipo()+"$";
			texto += p.getNome()+"$";
			texto += p.getPreco();
			
			produtos.add(texto);
			
		}
		
		LinkedList<String> servicos = new LinkedList<String>();
		
		texto = "";
		
		for (Servico s: this.servicos) {
			
			texto += s.getTipo()+"$";
			texto += s.getPreco()+"$";
			
			for (Produto p: s.getProdutosNecessario()) {
				
				texto += p.getNome()+"$";
				texto += p.getMarca()+"$";
				
			}
			
			servicos.add(texto);
			
		}
		
		LinkedList<String> agenda = new LinkedList<String>();
		
		texto = "";
		
		for (Apontamento a: this.agenda) {
			
			texto += a.getCliente().getCPF()+"$";
			texto += a.getFuncionario().getCPF()+"$";
			texto += a.getServico().getTipo()+"$";
			texto += a.getData()+"$";
			texto += a.getHora()+"$";
			
			agenda.add(texto);
			
		}
		
		try {
		
		file.save(clientes, "clientes.txt");
		file.save(funcionarios, "funcionarios.txt");
		file.save(produtos, "produtos.txt");
		file.save(servicos, "servicos.txt");
		file.save(agenda, "agenda.txt");
		
		} catch(Exception e) {}
		
	}
	
}
