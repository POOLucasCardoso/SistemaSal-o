import java.util.List;
import java.util.ArrayList;
public class SistemaSalao {
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private List<Funcionario> fucionarios;
	
	public SistemaSalao(){
		this.clientes = new ArrayList();
		this.produtos = new ArrayList();
		this.fucionarios = new ArrayList();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Funcionario> getFucionarios() {
		return fucionarios;
	}

	public void setFucionarios(List<Funcionario> fucionarios) {
		this.fucionarios = fucionarios;
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
	
	public Cliente pesquisaCliente(String nome, String cpf) throws NaoExisteException{
		for(int k = 0; k<this.clientes.size(); k++){
			if((this.clientes.get(k).getNome().equals(nome) && this.clientes.get(k).getCPF().equals(cpf))){
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
	
	public Produto pesquisaProduto(String nome) throws NaoExisteException{
		for(int k = 0; k < this.produtos.size(); k++){
			if(this.produtos.get(k).getNome().equals(nome)){
				return this.produtos.get(k);
			}
		}
		throw new NaoExisteException("Não Existe");
	} 
	
	

}
