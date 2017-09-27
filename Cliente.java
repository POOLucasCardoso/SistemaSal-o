public class Cliente extends Pessoa {

	boolean ehInadimplente;

	public Cliente(Contato contatos, Endereco endereco, String nome, String cPF) {

		super(contatos, endereco, nome, cPF);

		this.ehInadimplente = false;

	}

	public boolean isEhInadinplente() {
		return ehInadimplente;
	}

	public void setEhInadinplente(boolean ehInadinplente) {
		this.ehInadimplente = ehInadinplente;
	}

	@Override
	public String toString() {
		
		String inadimplente = "";
		
		if (ehInadimplente) {
			inadimplente = "Sim";
		}else {
			inadimplente = "Não";
		}
		
		return "Cliente\n Inadimplente: " + inadimplente + ", " + super.toString();
	}

}
