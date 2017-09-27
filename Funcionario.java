public class Funcionario extends Pessoa{
	
	private String tipo;
	
	public Funcionario(String tipo, String nome, String cpf, Contato contato, Endereco endereco){
		
		super(contato, endereco, nome, cpf);
		
		this.tipo = tipo;
		
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Funcionario:\n Tipo: " + tipo + ", " + super.toString();
	}
	
}
