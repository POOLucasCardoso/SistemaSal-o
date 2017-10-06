import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 495, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		txtNome = new JTextField();
		txtNome.setText("nome");
		txtNome.setBounds(10, 11, 225, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText("E-mail");
		txtEmail.setBounds(10, 42, 225, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.setText("celular");
		txtCelular.setBounds(10, 73, 225, 20);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setText("Cidade");
		txtCidade.setBounds(10, 104, 225, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setText("bairro");
		txtBairro.setBounds(10, 135, 225, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtRua = new JTextField();
		txtRua.setText("rua");
		txtRua.setBounds(10, 166, 225, 20);
		contentPane.add(txtRua);
		txtRua.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setText("n\u00FAmero");
		txtNumero.setBounds(245, 11, 225, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtCep = new JTextField();
		txtCep.setText("CEP");
		txtCep.setBounds(245, 42, 225, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setText("estado");
		txtEstado.setBounds(245, 73, 225, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		txtPais = new JTextField();
		txtPais.setText("Brasil");
		txtPais.setBounds(245, 104, 225, 20);
		contentPane.add(txtPais);
		txtPais.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setText("CPF");
		txtCpf.setBounds(245, 135, 225, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setText("tipo");
		txtTipo.setToolTipText("");
		txtTipo.setBounds(245, 166, 225, 20);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				
			}
		});
		btnVoltar.setBounds(67, 197, 89, 23);
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
					
					JOptionPane.showInputDialog("funcionario cadastrado com sucesso");
					
					setVisible(false);
					
				}catch(JaExisteException JEe) {
					
					JOptionPane.showMessageDialog(null, JEe.getMessage());
					
				}catch(Exception a) {
					
					JOptionPane.showMessageDialog(null,"Ocorreu algum erro, tente novamente por favor.");
					
				}
				
			}
		});
		btnSalvar.setBounds(290, 197, 89, 23);
		contentPane.add(btnSalvar);
		
	}
}
