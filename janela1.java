import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class janela1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCelular;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtCep;
	private JTextField txtEstado;
	private JTextField txtPais;
	private JTextField txtCpf;
	private JTextField txtTipo;

	/**
	 * Create the frame.
	 */
	public janela1(SistemaSalao system) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 496);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		txtNome = new JTextField();
		txtNome.setToolTipText("Nome");
		txtNome.setBounds(10, 112, 225, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("E-mail");
		txtEmail.setBounds(10, 168, 225, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.setToolTipText("Celular");
		txtCelular.setBounds(10, 224, 225, 20);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setToolTipText("Cidade");
		txtCidade.setBounds(10, 280, 225, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setToolTipText("Bairro");
		txtBairro.setBounds(10, 336, 225, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtRua = new JTextField();
		txtRua.setToolTipText("Rua");
		txtRua.setBounds(10, 392, 225, 20);
		contentPane.add(txtRua);
		txtRua.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setToolTipText("N\u00FAmero");
		txtNumero.setBounds(245, 112, 225, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtCep = new JTextField();
		txtCep.setToolTipText("CEP");
		txtCep.setBounds(245, 168, 225, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setToolTipText("Estado");
		txtEstado.setBounds(245, 224, 225, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		txtPais = new JTextField();
		txtPais.setToolTipText("Pa\u00EDs");
		txtPais.setBounds(245, 280, 225, 20);
		contentPane.add(txtPais);
		txtPais.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setToolTipText("CPF");
		txtCpf.setBounds(245, 336, 225, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setToolTipText("Tipo");
		txtTipo.setBounds(245, 392, 225, 20);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				
			}
		});
		btnVoltar.setBounds(61, 423, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnSalvar = new JButton("salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = txtNome.getText();
				String email = txtEmail.getText();
				String numero = txtCelular.getText();
				Contato contato = new Contato(email,numero);
				String cidade = txtCidade.getText();
				String bairro = txtBairro.getText();
				String rua = txtRua.getText();
				numero = txtNumero.getText();
				String cep = txtCep.getText();
				String estado = txtEstado.getText();
				String pais = txtPais.getText();
				Endereco endereco = new Endereco(pais,estado,cidade,bairro,rua,numero,cep);
				String cpf = txtCpf.getText();
				String tipo = txtTipo.getText();
				Funcionario funcionario = new Funcionario(tipo,nome,cpf ,contato,endereco);
				
				try {
					
					system.cadastraFuncionario(funcionario);
					
					JOptionPane.showMessageDialog(null,"funcionario cadastrado com sucesso");
					
					setVisible(false);
					
				}catch(JaExisteException JEe) {
					
					JOptionPane.showMessageDialog(null, JEe.getMessage());
					
				}catch(Exception a) {
					
					JOptionPane.showMessageDialog(null,"Ocorreu algum erro, tente novamente por favor.");
					
				}
				
			}
		});
		btnSalvar.setBounds(307, 423, 89, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome.setBounds(10, 87, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblEmail.setBounds(10, 143, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Telefone: ");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 199, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cidade: ");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 255, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Bairro: ");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 311, 62, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Rua: ");
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 367, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("N\u00FAmero: ");
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(245, 87, 70, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CEP: ");
		lblNewLabel_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(245, 143, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Estado: ");
		lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(245, 199, 70, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Pa\u00EDs: ");
		lblNewLabel_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(245, 255, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("CPF: ");
		lblNewLabel_8.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(245, 311, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Tipo: ");
		lblNewLabel_9.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(245, 367, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Informe os dados");
		lblNewLabel_10.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_10.setBounds(157, 11, 196, 37);
		contentPane.add(lblNewLabel_10);
		
	}
}