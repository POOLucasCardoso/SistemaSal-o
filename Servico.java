import java.util.List;
import java.util.ArrayList;
public class Servico {
	private String tipo;
	private double preco;
	private List<Produto> produtosNecessario;
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	public void removeProduto(String nome) throws NaoExisteException{
		boolean boo = true;
		for(int k = 0; k < this.produtosNecessario.size(); k++){
			if(this.produtosNecessario.get(k).getNome().equals(nome)){
				this.produtosNecessario.remove(this.produtosNecessario.get(k));
				boo = false;
				break;
			}
		}
		if(boo) {
			throw new NaoExisteException("Não Existe esse Produto");
		}
	}
	
	public List<Produto> getProdutosNecessario(){
		return this.produtosNecessario;
	}

	@Override
	public String toString() {
		return "Servico:\n tipo: " + tipo + ", preco: " + preco + ",\n produtos necessários: " + produtosNecessario.toString() + "";
	}
	
}
