import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class JanelaFuncionario extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public JanelaFuncionario(SistemaSalao system) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 440);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JButton btnCadastra = new JButton("Cadastra");
		btnCadastra.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnCadastra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new janela1(system);
				
			}
		});
		btnCadastra.setBounds(120, 76, 208, 54);
		contentPane.add(btnCadastra);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf = JOptionPane.showInputDialog("Qual o CPF desse funcionário?");
				
				try {
					
					system.removeFuncionario(cpf);
					
					JOptionPane.showMessageDialog(null,"Funcionário removido com sucesso.");
						
				}catch(NaoExisteException NEe){
					
					JOptionPane.showMessageDialog(null, NEe.getMessage());
					
				}catch(Exception a) {
					
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");
					
				}
				
				
			}
		});
		btnRemove.setBounds(120, 243, 208, 54);
		contentPane.add(btnRemove);
		
		JButton btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf = JOptionPane.showInputDialog("Qual o CPF do funcionário que desejas pesquisar?");

				try {

					Funcionario funcionario = system.pesquisaFuncionario(cpf);

					JOptionPane.showMessageDialog(null, funcionario.toString());

				} catch (NaoExisteException NEe) {

					JOptionPane.showMessageDialog(null, NEe.getMessage());

				} catch (Exception a) {

					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");

				}

				
			}
		});
		btnPesquisa.setBounds(120, 159, 208, 54);
		contentPane.add(btnPesquisa);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnVoltar.setBounds(10, 367, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel label = new JLabel("ESCOLHA UMA OP\u00C7\u00C3O");
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label.setBounds(108, 11, 264, 35);
		contentPane.add(label);
		setVisible(true);
	}

}