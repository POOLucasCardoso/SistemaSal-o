public class Cliente extends Pessoa {

	boolean ehInadinplente;

	public Cliente(Contato contatos, Endereco endereco, String nome, String cPF) {

		super(contatos, endereco, nome, cPF);

		this.ehInadinplente = true;

	}

	public boolean isEhInadinplente() {
		return ehInadinplente;
	}

	public void setEhInadinplente(boolean ehInadinplente) {
		this.ehInadinplente = ehInadinplente;
	}

}
