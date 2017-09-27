import javax.swing.JOptionPane;
public class SalaoMenu {
	public static void main(String args[]){
		
		SistemaSalao system = new SistemaSalao();

	   /*1.Cadastrar o Cliente
		*2.Pesquisar Cliente
		*3.Remover Cliente
		*4.
		*/
		
		String opcao = JOptionPane.showInputDialog("Informe uma das Opções:");
		
		String cpf = "";
		String nome = "";
		Cliente cliente = null;
		
		while(true){
			
			switch(opcao) {
			
			case("1"):
				
				nome = JOptionPane.showInputDialog("Por favor, informe o nome do cliente no campo abaixo.");
				String email = JOptionPane.showInputDialog("Informe o e-mail de "+nome+":");
				String numero = JOptionPane.showInputDialog("Informe o celular de "+nome+":");
				Contato contato = new Contato(email,numero);
				String cidade = JOptionPane.showInputDialog("Informe a cidade onde "+nome+" mora:");
				String bairro = JOptionPane.showInputDialog("Informe o bairro onde "+nome+" mora:");
				String rua = JOptionPane.showInputDialog("Informe a rua onde "+nome+" mora:");
				numero = JOptionPane.showInputDialog("Informe o número da casa de "+nome+":");
				String cep = JOptionPane.showInputDialog("Informe o CEP de"+nome+":");
				String estado = JOptionPane.showInputDialog("Informe o estado onde "+nome+" mora:");
				String pais = JOptionPane.showInputDialog("Informe o país de"+nome+":");
				Endereco endereco = new Endereco(pais,estado,cidade,bairro,rua,numero,cep);
				cpf = JOptionPane.showInputDialog("Informe o CPF de"+nome+":");
				cliente = new Cliente(contato,endereco,nome,cpf);
				
				try {
					
					system.cadastraCliente(cliente);
					
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
					
				}catch(JaExisteException JEe){
					
					JOptionPane.showMessageDialog(null, JEe.getMessage());
					
				}catch(Exception e){
					
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, por favor, tente novamente");
					
				}
				
			case("2"):
				
				nome = JOptionPane.showInputDialog("Qual o nome do cliente que desejas pesquisar?");
				
				cpf = JOptionPane.showInputDialog("Qual o CPF desse cliente?");
				
				try {
			
					cliente = system.pesquisaCliente(nome, cpf);
					
					JOptionPane.showMessageDialog(null, cliente.toString());

					int pesquisaC = JOptionPane.showConfirmDialog(null, "Ele(a) é inadimplente?");

					if (pesquisaC == 0) { system.atualizarCliente(cliente); }
						
				}catch(NaoExisteException NEe){
					
					JOptionPane.showMessageDialog(null, NEe.getMessage());
					
				}catch(Exception e) {
					
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");
					
				}
				
			case("3"):
				
				nome = JOptionPane.showInputDialog("Qual o nome do cliente que desejas remover?");
			
				cpf = JOptionPane.showInputDialog("Qual o CPF desse cliente?");
				
				try {
					
					system.removeCliente(nome, cpf);
						
				}catch(NaoExisteException NEe){
					
					JOptionPane.showMessageDialog(null, NEe.getMessage());
					
				}catch(Exception e) {
					
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");
					
				}
			
			}

		}
		
	}
	
}