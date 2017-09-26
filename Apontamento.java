
public class Apontamento {
	String data;
	String hora;
	Cliente cliente;
	Funcionario funcionario;
	Servico servico;
	
	public Apontamento(String data, String hora, Cliente cliente, Funcionario funcionario, Servico servico) {
		this.data = data;
		this.hora = hora;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.servico = servico;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
}
