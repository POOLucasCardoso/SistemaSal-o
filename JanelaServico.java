import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JanelaServico extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaServico(SistemaSalao system) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 440);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JButton button = new JButton("Cadastra");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new janela5(system);
			}
		});
		button.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button.setBounds(120, 76, 208, 54);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Pesquisa");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tipo = JOptionPane.showInputDialog("Qual o tipo de serviço que desejas pesquisar?");
				
				try {
					
					Servico servico = system.pesquisaServico(tipo);
					
					JOptionPane.showMessageDialog(null,servico.toString());
					
					int confirm = JOptionPane.showConfirmDialog(null, "Desejas adicionar um produto necessário ao servico?");
					
					while(confirm == 0) {
						
						String nome = JOptionPane.showInputDialog("Qual o nome do produto que desejas adicionar?");
						
						String marca = JOptionPane.showInputDialog("Qual a marca desse produto?");
						
						Produto produto = system.pesquisaProduto(nome, marca);
						
						servico.addProduto(produto);
						
						confirm = JOptionPane.showConfirmDialog(null, "Desejas adicionar um outro produto?");
						
					}
					
				}catch(NaoExisteException NEe) {
					
					JOptionPane.showMessageDialog(null,NEe.getMessage());
					
				}catch(Exception a) {
					
					JOptionPane.showMessageDialog(null,"Ocorreu algum erro, por vavor, tente novamente.");
					
				}
				
			}
		});
		button_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button_1.setBounds(120, 159, 208, 54);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Remove");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tipo = JOptionPane.showInputDialog("Qual o tipo de serviço que desejas excluir?");
				
				try {

					system.removeServico(tipo);

					JOptionPane.showInputDialog("Servico removido com sucesso.");

				} catch (NaoExisteException NEe) {

					JOptionPane.showMessageDialog(null, NEe.getMessage());

				} catch (Exception a) {

					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");

				}
				
			}
		});
		button_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button_2.setBounds(120, 243, 208, 54);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Voltar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		button_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button_3.setBounds(10, 367, 89, 23);
		contentPane.add(button_3);
		
		JLabel label = new JLabel("ESCOLHA UMA OP\u00C7\u00C3O");
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label.setBounds(108, 11, 264, 35);
		contentPane.add(label);
	}
}