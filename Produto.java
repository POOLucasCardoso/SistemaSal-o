
public class Produto {
	private String marca;
	private String tipo;
	private String nome;
	
	public Produto(String marca, String tipo, String nome){
		this.marca = marca;
		this.tipo = tipo;
		this.nome = nome;
	}
	
	public String getMarca(){
		return this.marca;
	}
	
	public String getTipo(){
		return this.tipo;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setMarca(String marca){
		this.marca = marca;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	

}
