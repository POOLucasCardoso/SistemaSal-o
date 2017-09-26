
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Produto other = (Produto) obj;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
	
	

}
