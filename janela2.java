import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
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
		setBounds(100, 100, 495, 432);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(null);
		setResizable(false);
		
		cx1 = new JTextField();
		cx1.setToolTipText("Nome:");
		cx1.setBounds(10, 73, 225, 20);
		contentPane.add(cx1);
		cx1.setColumns(10);
		
		cx2 = new JTextField("");
		cx2.setBounds(10, 135, 225, 20);
		contentPane.add(cx2);
		cx2.setColumns(10);
		
		cx3 = new JTextField("");
		cx3.setToolTipText("Celular");
		cx3.setBounds(10, 196, 225, 20);
		contentPane.add(cx3);
		cx3.setColumns(10);
		
		cx4 = new JTextField("");
		cx4.setToolTipText("Cidade");
		cx4.setBounds(10, 253, 225, 20);
		contentPane.add(cx4);
		cx4.setColumns(10);
		
		cx5 = new JTextField("");
		cx5.setToolTipText("Bairro");
		cx5.setBounds(10, 308, 225, 20);
		contentPane.add(cx5);
		cx5.setColumns(10);
		
		cx6 = new JTextField("");
		cx6.setToolTipText("Rua");
		cx6.setBounds(10, 360, 225, 20);
		contentPane.add(cx6);
		cx6.setColumns(10);
		
		cx7 = new JTextField("");
		cx7.setToolTipText("N\u00FAmero");
		cx7.setBounds(245, 73, 225, 20);
		contentPane.add(cx7);
		cx7.setColumns(10);
		
		cx8 = new JTextField("");
		cx8.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		cx8.setToolTipText("CEP");
		cx8.setBounds(245, 135, 225, 20);
		contentPane.add(cx8);
		cx8.setColumns(10);
		
		cx9 = new JTextField("");
		cx9.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		cx9.setBounds(245, 196, 225, 20);
		contentPane.add(cx9);
		cx9.setColumns(10);
		
		cx10 = new JTextField("");
		cx10.setToolTipText("Brasil");
		cx10.setBounds(245, 253, 225, 20);
		contentPane.add(cx10);
		cx10.setColumns(10);
		
		cx11 = new JTextField("CPF");
		cx11.setToolTipText("CPF");
		cx11.setText("");
		cx11.setBounds(245, 308, 225, 20);
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
				
				if (cpf.length()!=11) {
					JOptionPane.showMessageDialog(null,"CPF Inválido.");
				}
				else if(cidade == ""){
					JOptionPane.showMessageDialog(null, "Não deixe nada em branco");
				}
				else if(bairro == ""){
					JOptionPane.showMessageDialog(null, "Não deixe nada em branco");
				}
				else if(rua == ""){
					JOptionPane.showMessageDialog(null, "Não deixe nada em branco");
				}
				else if(estado == ""){
					JOptionPane.showMessageDialog(null, "Não deixe nada em branco");
				}
				else if(pais == ""){
					JOptionPane.showMessageDialog(null, "Não deixe nada em branco");
				}
				else if(nome == ""){
					JOptionPane.showMessageDialog(null, "Não deixe nada em branco");
				}
				else if(numero.length() != 11){
					JOptionPane.showMessageDialog(null, "Numero Inválido");
				}
				else if(!(email.contains("@"))){
					JOptionPane.showMessageDialog(null, "Email Inválido");
				}
				else if(cep.length() != 8){
					JOptionPane.showMessageDialog(null, "CEP Inválido");
				}
				
				else {

					try {

						system.cadastraCliente(cliente);

						JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.");

						dispose();

					} catch (JaExisteException JEe) {

						JOptionPane.showMessageDialog(null, JEe.getMessage());

					} catch (Exception e) {

						JOptionPane.showMessageDialog(null, "Ocorreu algum erro, por favor, tente novamente");

					}

				}

			}
		});
		btnSalvar.setBounds(381, 359, 89, 23);
		contentPane.add(btnSalvar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnVoltar.setBounds(245, 359, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome.setBounds(10, 48, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblEmail.setBounds(10, 110, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCelular.setBounds(10, 171, 62, 14);
		contentPane.add(lblCelular);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCidade.setBounds(10, 228, 62, 14);
		contentPane.add(lblCidade);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblBairro.setBounds(10, 283, 46, 14);
		contentPane.add(lblBairro);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblRua.setBounds(10, 339, 46, 14);
		contentPane.add(lblRua);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNmero.setBounds(245, 48, 62, 14);
		contentPane.add(lblNmero);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCep.setBounds(245, 110, 46, 14);
		contentPane.add(lblCep);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblEstado.setBounds(245, 173, 62, 14);
		contentPane.add(lblEstado);
		
		JLabel lblPas = new JLabel("Pa\u00EDs: ");
		lblPas.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPas.setToolTipText("Pa\u00EDs:");
		lblPas.setBounds(245, 228, 46, 14);
		contentPane.add(lblPas);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCpf.setBounds(245, 283, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblInformeOsDados = new JLabel("Informe os Dados");
		lblInformeOsDados.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblInformeOsDados.setBounds(152, 11, 189, 26);
		contentPane.add(lblInformeOsDados);
		
	}
}