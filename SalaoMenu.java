import javax.swing.JOptionPane;
public class SalaoMenu {
	public static void main(String args[]){
		SistemaSalao sistem = new SistemaSalao();
		boolean sair = true;
		while(sair){
			System.out.println("1.Cadastrar o Cliente\n"
					+ "2.Cadastra o Produto\n"
					+ "3.Cadastra o Funcionario\n"
					+ "4.Pesquisar o Cliente\n"
					+ "5.Pesquisar o Produto\n"
					+ "6.Pesquisar o Funcionario\n"
					+ "7.Pesquisar o Produto pelo Tipo");
			String opcao = JOptionPane.showInputDialog("Informe uma das Opções: ");
			int opcaoInt = Integer.parseInt(opcao);
			if(opcaoInt == 1){
				String pais = JOptionPane.showInputDialog("Informe o Pais do seu Cliente: ");
				String estado = JOptionPane.showInputDialog("Informe o estado do seu Cliente: ");
				String cidade = JOptionPane.showInputDialog("Informe a cidade do seu Cliente: ");
				String bairo = JOptionPane.showInputDialog("Informe o bairro do seu Cliente: ");
				String rua = JOptionPane.showInputDialog("Informe a rua do seu Cliente: ");
				String numero = JOptionPane.showInputDialog("Informe o numero da casa do seu Cliente: ");
				String CEP = JOptionPane.showInputDialog("Informe o CEP da cidade do seu Cliente: ");
				Endereco endereco = new Endereco(pais, estado, cidade, bairo, rua, numero, CEP);
				String email = JOptionPane.showInputDialog("Informe o email do seu Cliente: ");
				String numeroContato = JOptionPane.showInputDialog("Informe o numero para contato do seu Cliente: ");
				Contato contato = new Contato(email,numeroContato);
				String nome = JOptionPane.showInputDialog("Informe o nome do seu Cliente: ");
				String CPF = JOptionPane.showInputDialog("Informe o CPF do seu Cliente: ");
				Cliente cliente = new Cliente(contato, endereco, nome, CPF);
				try{
					sistem.cadastraCliente(cliente);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
			else if(opcaoInt == 2){
				String marca = JOptionPane.showInputDialog("Informe a marca do Produto: ");
				String tipo = JOptionPane.showInputDialog("Informe o tipo do Produto: ");
				String nome = JOptionPane.showInputDialog("Informe o nome do seu Produto: ");
				Produto produto = new Produto(marca, tipo, nome);
				try{
					sistem.cadastraProduto(produto);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
			else if(opcaoInt == 3){
				String pais = JOptionPane.showInputDialog("Informe o Pais do seu Funcionario: ");
				String estado = JOptionPane.showInputDialog("Informe o estado do seu Funcionario: ");
				String cidade = JOptionPane.showInputDialog("Informe a cidade do seu Funcionario: ");
				String bairo = JOptionPane.showInputDialog("Informe o bairro do seu Funcionario: ");
				String rua = JOptionPane.showInputDialog("Informe a rua do seu Funcionario: ");
				String numero = JOptionPane.showInputDialog("Informe o numero da casa do seu Funcionario: ");
				String CEP = JOptionPane.showInputDialog("Informe o CEP da cidade do seu Funcionario: ");
				Endereco endereco = new Endereco(pais, estado, cidade, bairo, rua, numero, CEP);
				String email = JOptionPane.showInputDialog("Informe o email do seu Funcionario: ");
				String numeroContato = JOptionPane.showInputDialog("Informe o numero para contato do seu Funcionario: ");
				Contato contato = new Contato(email,numeroContato);
				String tipo = JOptionPane.showInputDialog("Informe o tipo de Funcionario: ");
				String nome = JOptionPane.showInputDialog("Informe o nome do seu Cliente: ");
				String CPF = JOptionPane.showInputDialog("Informe o CPF do seu Cliente: ");
				Funcionario func = new Funcionario(tipo, nome, CPF, contato, endereco);
				try{
					sistem.cadastraFuncionario(func);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
			else if(opcaoInt == 4){
				String nome = JOptionPane.showInputDialog("Informe o nome do Cliente que voce deseja pesquisar: ");
				String cpf = JOptionPane.showInputDialog("Informe o CPF do Cliente que voce deseja pesquisar: ");
				Cliente clientePesquisado = null;
				try{
					clientePesquisado = sistem.pesquisaCliente(nome, cpf);
				}catch (Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				JOptionPane.showMessageDialog(null,"Nome: "+clientePesquisado.getNome()+"CPF: "+clientePesquisado.getCPF()+clientePesquisado.getContatos().toString()+clientePesquisado.getEndereco().toString());
			}
		}
	}
}
