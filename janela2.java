import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class janela2 extends JFrame {

	private JPanel contentPane;
	private JTextField cx1;
	private JTextField cx2;
	private JTextField cx11;
	private JTextField cx4;
	private JTextField cx9;
	private JTextField cx8;
	private JTextField cx5;
	private JTextField cx10;
	private JTextField cx7;
	private JTextField cx3;
	private JTextField cx6;
	private JButton btnSalvar;
	private JButton btnVoltar;

	/**
	 * Create the frame.
	 */
	public janela2(SistemaSalao system) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(null);
		
		cx1 = new JTextField();
		cx1.setText("nome");
		cx1.setBounds(10, 11, 225, 20);
		contentPane.add(cx1);
		cx1.setColumns(10);
		
		cx2 = new JTextField("E-mail");
		cx2.setBounds(10, 42, 225, 20);
		contentPane.add(cx2);
		cx2.setColumns(10);
		
		cx3 = new JTextField("celular");
		cx3.setBounds(10, 73, 225, 20);
		contentPane.add(cx3);
		cx3.setColumns(10);
		
		cx4 = new JTextField("Cidade");
		cx4.setBounds(10, 104, 225, 20);
		contentPane.add(cx4);
		cx4.setColumns(10);
		
		cx5 = new JTextField("bairro");
		cx5.setBounds(10, 135, 225, 20);
		contentPane.add(cx5);
		cx5.setColumns(10);
		
		cx6 = new JTextField("rua");
		cx6.setBounds(10, 166, 225, 20);
		contentPane.add(cx6);
		cx6.setColumns(10);
		
		cx7 = new JTextField("número");
		cx7.setBounds(245, 11, 225, 20);
		contentPane.add(cx7);
		cx7.setColumns(10);
		
		cx8 = new JTextField("CEP");
		cx8.setBounds(245, 42, 225, 20);
		contentPane.add(cx8);
		cx8.setColumns(10);
		
		cx9 = new JTextField("estado");
		cx9.setBounds(245, 73, 225, 20);
		contentPane.add(cx9);
		cx9.setColumns(10);
		
		cx10 = new JTextField("Brasil");
		cx10.setBounds(245, 104, 225, 20);
		contentPane.add(cx10);
		cx10.setColumns(10);
		
		cx11 = new JTextField("CPF");
		cx11.setText("CPF");
		cx11.setBounds(245, 135, 225, 20);
		contentPane.add(cx11);
		cx11.setColumns(10);
		
		btnSalvar = new JButton("salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nome = cx1.getText();
				String email = cx2.getText();
				String numero = cx3.getText();
				Contato contato = new Contato(email,numero);
				String cidade = cx4.getText();
				String bairro = cx5.getText();
				String rua = cx6.getText();
				numero = cx7.getText();
				String cep = cx8.getText();
				String estado = cx9.getText();
				String pais = cx10.getText();
				Endereco endereco = new Endereco(pais,estado,cidade,bairro,rua,numero,cep);
				String cpf = cx11.getText();
				Cliente cliente = new Cliente(contato,endereco,nome,cpf);
				
				try {
					
					system.cadastraCliente(cliente);
					
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
					
					setVisible(false);
					
				}catch(JaExisteException JEe){
					
					JOptionPane.showMessageDialog(null, JEe.getMessage());
					
				}catch(Exception e){
					
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, por favor, tente novamente");
					
				}
				
				
				
			}
		});
		btnSalvar.setBounds(380, 165, 89, 23);
		contentPane.add(btnSalvar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
			}
		});
		btnVoltar.setBounds(245, 165, 89, 23);
		contentPane.add(btnVoltar);
		
	}

}
