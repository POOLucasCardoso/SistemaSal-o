import javax.swing.JOptionPane;
public class SalaoMenu {
	public static void main(String args[]){
		
		SistemaSalao system = new SistemaSalao();

	   /*1.Cadastrar o Cliente
		*2.Pesquisar Cliente
		*3.Remover Cliente
		*4.Cadastrar funcionario
		*5.Pesquisar funcionario
		*6.Remover funcionario
		*7.Adicionar produto
		*8.Pesquisar produto
		*9.Remover produto
		*10.Adicionar serviço
		*11.Pesquisar serviço
		*12.Remover serviço
		*13.Agendar
		*/
		
		String opcao = JOptionPane.showInputDialog("Informe uma das Opções:");
		
		int opcao2 = -1;
		
		String cpf;
		String nome;
		String email;
		String numero;
		String cidade;
		String bairro;
		String rua;
		String cep;
		String estado;
		String pais;
		String tipo;
		String marca;
		double preco;
		Endereco endereco;
		Contato contato;
		Cliente cliente;
		Funcionario funcionario;
		Produto produto;
		Servico servico;
		Apontamento apontamento;
		
		while(true){
			
			switch(opcao) {
			
			case("1"):
				
				nome = JOptionPane.showInputDialog("Por favor, informe o nome do cliente no campo abaixo.");
				email = JOptionPane.showInputDialog("Informe o e-mail de "+nome+":");
				numero = JOptionPane.showInputDialog("Informe o celular de "+nome+":");
				contato = new Contato(email,numero);
				cidade = JOptionPane.showInputDialog("Informe a cidade onde "+nome+" mora:");
				bairro = JOptionPane.showInputDialog("Informe o bairro onde "+nome+" mora:");
				rua = JOptionPane.showInputDialog("Informe a rua onde "+nome+" mora:");
				numero = JOptionPane.showInputDialog("Informe o número da casa de "+nome+":");
				cep = JOptionPane.showInputDialog("Informe o CEP de"+nome+":");
				estado = JOptionPane.showInputDialog("Informe o estado onde "+nome+" mora:");
				pais = JOptionPane.showInputDialog("Informe o país de "+nome+":");
				endereco = new Endereco(pais,estado,cidade,bairro,rua,numero,cep);
				cpf = JOptionPane.showInputDialog("Informe o CPF de "+nome+":");
				cliente = new Cliente(contato,endereco,nome,cpf);
				
				try {
					
					system.cadastraCliente(cliente);
					
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
					
				}catch(JaExisteException JEe){
					
					JOptionPane.showMessageDialog(null, JEe.getMessage());
					
				}catch(Exception e){
					
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, por favor, tente novamente");
					
				}
				
				break;
				
			case("2"):
				
				cpf = JOptionPane.showInputDialog("Qual o CPF do cliente que desejas pesquisar?");
				
				try {
			
					cliente = system.pesquisaCliente(cpf);
					
					JOptionPane.showMessageDialog(null, cliente.toString());

					int pesquisaC = JOptionPane.showConfirmDialog(null, "Ele(a) é inadimplente?");

					if (pesquisaC == 0) { system.atualizarCliente(cliente); }
						
				}catch(NaoExisteException NEe){
					
					JOptionPane.showMessageDialog(null, NEe.getMessage());
					
				}catch(Exception e) {
					
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");
					
				}
				
				break;
				
			case("3"):
				
				cpf = JOptionPane.showInputDialog("Qual o CPF desse cliente?");
				
				try {
					
					system.removeCliente(cpf);
					
					JOptionPane.showInputDialog("Cliente removido com sucesso.");
						
				}catch(NaoExisteException NEe){
					
					JOptionPane.showMessageDialog(null, NEe.getMessage());
					
				}catch(Exception e) {
					
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");
					
				}
				
				break;
				
			case("4"):
				

				nome = JOptionPane.showInputDialog("Por favor, informe o nome do funcionário no campo abaixo.");
				email = JOptionPane.showInputDialog("Informe o e-mail de "+nome+":");
				numero = JOptionPane.showInputDialog("Informe o celular de "+nome+":");
				contato = new Contato(email,numero);
				cidade = JOptionPane.showInputDialog("Informe a cidade onde "+nome+" mora:");
				bairro = JOptionPane.showInputDialog("Informe o bairro onde "+nome+" mora:");
				rua = JOptionPane.showInputDialog("Informe a rua onde "+nome+" mora:");
				numero = JOptionPane.showInputDialog("Informe o número da casa de "+nome+":");
				cep = JOptionPane.showInputDialog("Informe o CEP de"+nome+":");
				estado = JOptionPane.showInputDialog("Informe o estado onde "+nome+" mora:");
				pais = JOptionPane.showInputDialog("Informe o país de "+nome+":");
				endereco = new Endereco(pais,estado,cidade,bairro,rua,numero,cep);
				cpf = JOptionPane.showInputDialog("Informe o CPF de "+nome+":");
				tipo = JOptionPane.showInputDialog("Informe o tipo de funcionário que "+nome+" é:");
				funcionario = new Funcionario(tipo,nome,cpf ,contato,endereco);
				
				try {
					
					system.cadastraFuncionario(funcionario);
					
					JOptionPane.showInputDialog("funcionario cadastrado com sucesso");
					
				}catch(JaExisteException JEe) {
					
					JOptionPane.showMessageDialog(null, JEe.getMessage());
					
				}catch(Exception e) {
					
					JOptionPane.showMessageDialog(null,"Ocorreu algum erro, tente novamente por favor.");
					
				}
				
				break;
				
			case("5"):
				
				cpf = JOptionPane.showInputDialog("Qual o CPF do funcionário que desejas pesquisar?");

				try {

					funcionario = system.pesquisaFuncionario(cpf);

					JOptionPane.showMessageDialog(null, funcionario.toString());

				} catch (NaoExisteException NEe) {

					JOptionPane.showMessageDialog(null, NEe.getMessage());

				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");

				}

				break;
				
			case("6"):

				cpf = JOptionPane.showInputDialog("Qual o CPF desse cliente?");
				
				try {
					
					system.removeFuncionario(cpf);
					
					JOptionPane.showInputDialog("Funcionário removido com sucesso.");
						
				}catch(NaoExisteException NEe){
					
					JOptionPane.showMessageDialog(null, NEe.getMessage());
					
				}catch(Exception e) {
					
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");
					
				}
				
				break;
				
			case("7"):
				
				nome = JOptionPane.showInputDialog("Qual o nome do produto?");
				marca = JOptionPane.showInputDialog("Qual a marca do produto?");
				tipo = JOptionPane.showInputDialog("Qual o tipo do produto?");
				numero = JOptionPane.showInputDialog("Qual o preço dele?");
				
				try {
					
					preco = Double.parseDouble(numero);
					
					if(preco<0) {
						
						JOptionPane.showMessageDialog(null, "Preço inválido.");
						
						break;
						
					}
					
					produto = new Produto(marca, tipo, nome, preco);
					
					system.cadastraProduto(produto);
					
				}catch(JaExisteException JEe) {
					
					JOptionPane.showMessageDialog(null, JEe.getMessage());
					
				}catch(NumberFormatException NFe) {
					
					JOptionPane.showMessageDialog(null, "Preço inválido");
					
				}catch(Exception e) {
					
					JOptionPane.showMessageDialog(null, "Ocorreu um erro, por favor, tente novamente.");
					
				}
				
				break;
				
			case("8"):
				
				nome = JOptionPane.showInputDialog("Qual o nome do produto que desejas pesquisar?");
				marca = JOptionPane.showInputDialog("Qual a marca desse produto:");

				try {

					produto = system.pesquisaProduto(nome, marca);

					JOptionPane.showMessageDialog(null, produto.toString());

				} catch (NaoExisteException NEe) {

					JOptionPane.showMessageDialog(null, NEe.getMessage());

				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");

				}

				break;
				
			case("9"):
				
				nome = JOptionPane.showInputDialog("Qual o nome do produto?");
				marca = JOptionPane.showInputDialog("Qual a marca desse produto:");

				try {

					system.removeProduto(nome, marca);

					JOptionPane.showInputDialog("Produto removido com sucesso.");

				} catch (NaoExisteException NEe) {

					JOptionPane.showMessageDialog(null, NEe.getMessage());

				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");

				}

				break;
				
			case("10"):
				
				tipo = JOptionPane.showInputDialog("Qual o tipo de serviço que desejas incluir?");
				numero = JOptionPane.showInputDialog("Qual o preco sesse serviço?");
				
				try {
					
					preco = Double.parseDouble(numero);
					
					servico = new Servico(tipo,preco);
					
					opcao2 = JOptionPane.showConfirmDialog(null, "Desejas cadastrar algum produto nessessário a esse servoço?");
					
					while(opcao2==0){
						
						nome = JOptionPane.showInputDialog("Qual o nome do produto?");
						marca = JOptionPane.showInputDialog("Qual a marca desse produto:");
						
						try {
						
						produto = system.pesquisaProduto(nome, marca);
						
						servico.addProduto(produto);
						
						}catch(NaoExisteException NEe) {
							
							JOptionPane.showMessageDialog(null, NEe.getMessage());
							
						}catch(JaExisteException JEe) {
							
							JOptionPane.showMessageDialog(null, JEe.getMessage());
							
						}catch(Exception e) {
							
							JOptionPane.showMessageDialog(null,"Ocorreu algum erro, por vavor, tente novamente.");
							
						}
						
						opcao2 = JOptionPane.showConfirmDialog(null, "Desejas cadastrar outro produto?");
						
					}
					
					system.cadastraServico(servico);
					
					JOptionPane.showMessageDialog(null, "Servico cadastrado com sucesso.");
					
				}catch(JaExisteException JEe) {
					
					JOptionPane.showMessageDialog(null, JEe.getMessage());
					
				}catch(NumberFormatException NFe){
					
					JOptionPane.showMessageDialog(null,"Preço inválido.");
					
				}catch(Exception e) {
					
					JOptionPane.showMessageDialog(null,"Ocorreu algum erro, por vavor, tente novamente.");
					
				}
				
				break;
				
			case("11"):
				
				tipo = JOptionPane.showInputDialog("Qual o tipo de serviço que desejas pesquisar?");
			
				try {
					
					servico = system.pesquisaServico(tipo);
					
					JOptionPane.showMessageDialog(null,servico.toString());
					
				}catch(NaoExisteException NEe) {
					
					JOptionPane.showMessageDialog(null,NEe.getMessage());
					
				}catch(Exception e) {
					
					JOptionPane.showMessageDialog(null,"Ocorreu algum erro, por vavor, tente novamente.");
					
				}
				
				break;
				
			case("12"):
				
				tipo = JOptionPane.showInputDialog("Qual o tipo de serviço que desejas excluir?");
			
				try {

					system.removeServico(tipo);

					JOptionPane.showInputDialog("Servico removido com sucesso.");

				} catch (NaoExisteException NEe) {

					JOptionPane.showMessageDialog(null, NEe.getMessage());

				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");

				}

				break;
				
			case("13"):
				
				try {
					
					nome = JOptionPane.showInputDialog("Qual a data do apontamento?");
					numero = JOptionPane.showInputDialog("De que horas?");

					cpf = JOptionPane.showInputDialog("Qual o CPF do cliente?");
					
					cliente = system.pesquisaCliente(cpf);
					
					cpf = JOptionPane.showInputDialog("Qual o CPF do funcionário responsável?");
					
					funcionario = system.pesquisaFuncionario(cpf);
					
					tipo = JOptionPane.showInputDialog("Qual o tipo de serviço que será realizado?");
					
					servico = system.pesquisaServico(tipo);
					
					apontamento = new Apontamento(nome,numero,cliente,funcionario,servico);
					
					system.agendar(apontamento);
					
				}catch(NaoExisteException NEe) {
					
					JOptionPane.showMessageDialog(null, NEe.getMessage());
					
				}catch(JaExisteException JEe) {
					
					JOptionPane.showMessageDialog(null, JEe.getMessage());
					
				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");

				}
				
				break;
	
			default:
				
				JOptionPane.showMessageDialog(null, "Não existe essa opção, por favor, escolha outra.");
			
			}
			
			opcao = JOptionPane.showInputDialog("Informe uma das Opções:");

		}
		
	}
	
}