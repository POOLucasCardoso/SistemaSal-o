import java.util.List;
import java.util.ArrayList;
public class SistemaSalao {
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private List<Funcionario> fucionarios;
	private List<Servico> servicos;
	private List<Apontamento> agenda;
	
	public SistemaSalao(){
		this.clientes = new ArrayList<Cliente>();
		this.produtos = new ArrayList<Produto>();
		this.fucionarios = new ArrayList<Funcionario>();
		this.agenda = new ArrayList<Apontamento>();
	}
	
	public int quantClientes(){
		return this.clientes.size();
	}
	
	public int quantProdutos(){
		return this.produtos.size();
	}
	
	public int quantFuncionarios(){
		return this.fucionarios.size();
	}
	
	public List<Cliente> quantClientesInad(){
		List<Cliente> clientesInadiplente = new ArrayList<Cliente>();
		for(int k = 0; k < this.clientes.size(); k++){
			if(this.clientes.get(k).isEhInadinplente()){
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
		for(int k = 0; k < this.fucionarios.size(); k++){
			funcionarios.add(this.fucionarios.get(k));
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
		for(int k = 0; k < this.fucionarios.size(); k++){
			if(this.fucionarios.get(k).equals(funcionario)){
				throw new JaExisteException("Funcionario Já Cadastrado");
			}
		}
		this.fucionarios.add(funcionario);
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
		for(int k = 0; k<this.fucionarios.size(); k++){
			if(this.fucionarios.get(k).getCPF().equals(cpf)){
				return this.fucionarios.get(k);
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

		for (Funcionario f : this.fucionarios) {

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
	
}
