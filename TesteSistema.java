import static org.junit.Assert.*;

import org.junit.Test;

public class TesteSistema {
	
	public void testCadastra() {
		SistemaSalao sistema = new SistemaSalao();
		String pais = "Brasil";
		String estado = "Paraiba";
		String cidade = "Rio Tinto";
		String bairro = "Centro";
		String rua = "Rua do Tambor";
		String numero = "130";
		String CEP = "55940-000";
		String email = "fulan.silva@dce.ufpb.br";
		String num = "0000-0000";
		String nome = "Fulano";
		String CPF = "000000-00";
		Endereco endereco = new Endereco(pais,estado,cidade,bairro,rua,numero,CEP);
		Contato contatos = new Contato(email,num);
		Cliente cliente = new Cliente(contatos,endereco,nome,CPF);
		try{
			sistema.cadastraCliente(cliente);
			Cliente c = sistema.pesquisaCliente("Fulano","000000-00");
			assertEquals(c, cliente);
		}
		catch(Exception e){
			fail("N�o funciona !");
		}
	}

}
