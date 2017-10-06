import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaFuncionario extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public JanelaFuncionario(SistemaSalao system) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastra = new JButton("Cadastra");
		btnCadastra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new janela1(system);
				
			}
		});
		btnCadastra.setBounds(64, 52, 89, 23);
		contentPane.add(btnCadastra);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf = JOptionPane.showInputDialog("Qual o CPF desse funcionário?");
				
				try {
					
					system.removeFuncionario(cpf);
					
					JOptionPane.showInputDialog("Funcionário removido com sucesso.");
						
				}catch(NaoExisteException NEe){
					
					JOptionPane.showMessageDialog(null, NEe.getMessage());
					
				}catch(Exception a) {
					
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");
					
				}
				
				
			}
		});
		btnRemove.setBounds(64, 141, 89, 23);
		contentPane.add(btnRemove);
		
		JButton btnPesquisa = new JButton("Pesquisa");
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
		btnPesquisa.setBounds(231, 102, 89, 23);
		contentPane.add(btnPesquisa);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
			}
		});
		btnVoltar.setBounds(231, 187, 89, 23);
		contentPane.add(btnVoltar);
		setVisible(true);
	}

}
