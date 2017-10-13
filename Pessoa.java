public abstract class Pessoa {

	private Contato contatos;
	
	private Endereco endereco;
	
	private String nome;
	
	private String CPF;

	public Pessoa(Contato contatos, Endereco endereco, String nome, String cPF) {
		super();
		this.contatos = contatos;
		this.endereco = endereco;
		this.nome = nome;
		CPF = cPF;
	}

	public Contato getContatos() {
		return contatos;
	}

	public void setContatos(Contato contatos) {
		this.contatos = contatos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "nome: " + nome 
			+ ", CPF: " + CPF
			+ ", contatos:\n " + contatos.toString() 
			+ ", endereco:\n " + endereco.toString();
		
	}
	
	

}
