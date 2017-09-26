import java.util.List;
import java.util.ArrayList;
public class Servico {
	String tipo;
	double preco;
	List<Produto> produtosNecessario;
	
	public Servico(String tipo, double preco){
		this.tipo = tipo;
		this.preco = preco;
		this.produtosNecessario = new ArrayList<Produto>();
	}
	
	public String getTipo(){
		return this.tipo;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
	public double getPreco(){
		return this.preco;
	}
	
	public void setPreco(double preco){
		this.preco = preco;
	}
	
	public void addProduto(Produto produto) throws JaExisteException{
		for(int k = 0; k < this.produtosNecessario.size(); k++){
			if(this.produtosNecessario.get(k).equals(produto)){
				throw new JaExisteException("Já Existe este Produto");
			}
		}
		this.produtosNecessario.add(produto);
	}
	
	public void removeProduto(String nome) throws NaoExisteException{
		for(int k = 0; k < this.produtosNecessario.size(); k++){
			if(this.produtosNecessario.get(k).getNome().equals(nome)){
				this.produtosNecessario.remove(this.produtosNecessario.get(k));
				break;
			}
		}
		throw new NaoExisteException("Não Existe esse Produto");
	}
	
	public List<Produto> getProdutosNecessario(){
		return this.produtosNecessario;
	}
	
}
