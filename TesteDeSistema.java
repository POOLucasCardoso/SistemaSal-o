import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

public class TesteDeSistema {

	@Test
	public void testeDeArquivo() {
		
		SistemaSalao sys = new SistemaSalao();
		
		String nome = "João";
		String email = "joao@dce.ufpb.br";
		String numero = "99999-9999";
		Contato contato = new Contato(email,numero);
		String cidade = "Rio Tinto";
		String bairro = "Centro";
		String rua = "Rua dos Bobos";
		numero = "00";
		String cep = "00000-000";
		String estado = "PB";
		String pais = "Brasil";
		Endereco endereco = new Endereco(pais,estado,cidade,bairro,rua,numero,cep);
		String cpf = "123.456.789-00";
		Cliente cliente = new Cliente(contato,endereco,nome,cpf);
		
		System.out.println("---rrrrrrr----->>>>>");
		
		try {
			
			sys.cadastraCliente(cliente);
			
		}catch(JaExisteException JEe){
			
			fail(JEe.getMessage());
			
		}catch(Exception e){
			
			fail(e.getMessage());
			
		}
		
		try {
	
			Cliente clienteP = sys.pesquisaCliente(cpf);
			
			assertTrue(clienteP.equals(cliente));

		}catch(NaoExisteException NEe){
			
			fail(NEe.getMessage());
			
		}catch(Exception e) {
			
			fail("erro");
			
		}
		
		
		try {
		
			sys.finaliza();
		
		}catch(Exception e) {
			
			fail(e.getMessage());
			
		}
		
		SistemaSalao sys2 = new SistemaSalao();
		
		try {
			
		cliente = sys2.pesquisaCliente(cpf);
		
		}catch(Exception e) {
			e.printStackTrace();
			
			fail(e.getMessage());
			
		}
		
	}

}
