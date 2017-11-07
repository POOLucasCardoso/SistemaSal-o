import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

@SuppressWarnings("serial")
public class janela4 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnVoltar;

	/**
	 * Create the frame.
	 */
	public janela4(SistemaSalao system) {
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(244, 120, 225, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 120, 225, 20);
		contentPane.add(textField_3);
		
		JComboBox servicoBox = new JComboBox<>();
		servicoBox.setBounds(127, 180, 225, 21);
		servicoBox.addItem("Serviço");
		for(String i: system.nomeServicos()) {
			servicoBox.addItem(i);
		}
		contentPane.add(servicoBox);
		
		JComboBox clienteBox = new JComboBox<>();
		clienteBox.setBounds(245, 60, 225, 21);
		clienteBox.addItem("Cliente");
		for(Cliente i: system.todosClientes()) {
			clienteBox.addItem(i.getCPF()+" - "+i.getNome());
		}
		contentPane.add(clienteBox);
		
		JComboBox funcionarioBox = new JComboBox<>();
		funcionarioBox.setBounds(10, 60, 225, 20);
		funcionarioBox.addItem("Funcionário");
		for(Funcionario i: system.todosFuncionarios()) {
			funcionarioBox.addItem(i.getCPF()+" - "+i.getNome());
		}
		contentPane.add(funcionarioBox);
		
		
		JButton btnSalvar = new JButton("salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					
					String data = textField_3.getText();
					
					String horario = textField_2.getText();
					
					String cpf = ((String)clienteBox.getItemAt(clienteBox.getSelectedIndex())).substring(0, 11);

					Cliente cliente = system.pesquisaCliente(cpf);

					cpf = ((String)funcionarioBox.getItemAt(funcionarioBox.getSelectedIndex())).substring(0, 11);

					Funcionario funcionario = system.pesquisaFuncionario(cpf);

					String tipo = (String)servicoBox.getItemAt(servicoBox.getSelectedIndex());

					Servico servico = system.pesquisaServico(tipo);
					
					if (funcionario.getTipo()!=servico.getTipo()) {
						
						JOptionPane.showMessageDialog(null, "Tipo do funcionário não se enquadra para o serviço");
						
					} else {

						Apontamento apontamento = new Apontamento(data,horario,cliente,funcionario,servico);

						system.agendar(apontamento);

						JOptionPane.showMessageDialog(null, "Agendamento cadastrado com sussesso");
					
					}

				}catch(NaoExisteException NEe) {
					
					JOptionPane.showMessageDialog(null, NEe.getMessage());
					
				}catch(JaExisteException JEe) {
					
					JOptionPane.showMessageDialog(null, JEe.getMessage());
					
				} catch (Exception a) {

					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");

				}
				
			}
		});
		btnSalvar.setBounds(263, 211, 89, 23);
		contentPane.add(btnSalvar);
		
		btnVoltar = new JButton("voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		btnVoltar.setBounds(127, 211, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNomeDoFuncionario = new JLabel("Nome do funcion\u00E1rio:");
		lblNomeDoFuncionario.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNomeDoFuncionario.setBounds(10, 33, 148, 20);
		contentPane.add(lblNomeDoFuncionario);
		
		JLabel lblTipoDeServico = new JLabel("Data:");
		lblTipoDeServico.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTipoDeServico.setBounds(10, 89, 130, 20);
		contentPane.add(lblTipoDeServico);
		
		JLabel lblData = new JLabel("Hor\u00E1rio:");
		lblData.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblData.setBounds(244, 89, 130, 20);
		contentPane.add(lblData);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do cliente:");
		lblNomeDoCliente.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNomeDoCliente.setBounds(244, 29, 130, 20);
		contentPane.add(lblNomeDoCliente);
		
		JLabel label_4 = new JLabel("Informe os Dados");
		label_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label_4.setBounds(149, 0, 189, 26);
		contentPane.add(label_4);
		
		JLabel lblTipoDeServico_1 = new JLabel("Tipo de servico:");
		lblTipoDeServico_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTipoDeServico_1.setBounds(127, 149, 130, 20);
		contentPane.add(lblTipoDeServico_1);
	}
}
