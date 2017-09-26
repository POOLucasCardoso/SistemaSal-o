import java.util.List;
import java.util.ArrayList;
public class SistemaSalao {
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private List<Funcionario> fucionarios;
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
					throw new JaExisteException("Usuario J� Cadastrado");
				}
			}
			this.clientes.add(cliente);
	}
	
	public void cadastraProduto(Produto produto) throws JaExisteException{
		for(int k = 0; k<this.produtos.size(); k++){
			if(this.produtos.get(k).equals(produto)){
				throw new JaExisteException("Produto j� Cadastrado");
			}
		}
		this.produtos.add(produto);
	}
	
	public void cadastraFuncionario(Funcionario funcionario) throws JaExisteException{
		for(int k = 0; k < this.fucionarios.size(); k++){
			if(this.fucionarios.get(k).equals(funcionario)){
				throw new JaExisteException("Funcionario J� Cadastrado");
			}
		}
		this.fucionarios.add(funcionario);
	}
	
	public Cliente pesquisaCliente(String nome, String cpf) throws NaoExisteException{
		for(int k = 0; k<this.clientes.size(); k++){
			if((this.clientes.get(k).getNome().equals(nome) && this.clientes.get(k).getCPF().equals(cpf))){
				return this.clientes.get(k);
			}
		}
		throw new NaoExisteException("N�o existe");
	}
	
	public Funcionario pesquisaFuncionario(String cpf)throws NaoExisteException{
		for(int k = 0; k<this.fucionarios.size(); k++){
			if(this.fucionarios.get(k).getCPF().equals(cpf)){
				return this.fucionarios.get(k);
			}
		}
		throw new NaoExisteException("N�o Existe");
	}
	
	public Produto pesquisaProduto(String nome) throws NaoExisteException{
		for(int k = 0; k < this.produtos.size(); k++){
			if(this.produtos.get(k).getNome().equals(nome)){
				return this.produtos.get(k);
			}
		}
		throw new NaoExisteException("N�o Existe");
	} 
}
