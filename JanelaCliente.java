import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class JanelaCliente extends JFrame{

	private JPanel contentPane;
	private JButton btnCadastra;
	private JButton btnRemove;
	private JButton btnPesquisa;
	private JButton btnVoltar;
	private JLabel lblEscolhaUmaOpo;
	
	/**
	 * Create the frame.
	 */
	public JanelaCliente(SistemaSalao system) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 440);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		btnCadastra = new JButton("Cadastra");
		btnCadastra.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnCadastra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new janela2(system);
				
			}
		});
		btnCadastra.setBounds(120, 76, 208, 54);
		contentPane.add(btnCadastra);
		
		btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf = JOptionPane.showInputDialog("Qual o CPF desse cliente?");
				
				try {
					
					system.removeCliente(cpf);
					
					JOptionPane.showInputDialog("Cliente removido com sucesso.");
						
				}catch(NaoExisteException NEe){
					
					JOptionPane.showMessageDialog(null, NEe.getMessage());
					
				}catch(Exception a) {
					
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");
					
				}
				
			}
		});
		btnRemove.setBounds(120, 243, 208, 54);
		contentPane.add(btnRemove);
		
		btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf = JOptionPane.showInputDialog("Qual o CPF do cliente que desejas pesquisar?");
				
				try {
			
					Cliente cliente = system.pesquisaCliente(cpf);
					
					JOptionPane.showMessageDialog(null, cliente.toString());

					int pesquisaC = JOptionPane.showConfirmDialog(null, "Ele(a) é inadimplente?");

					if (pesquisaC == 0) { system.atualizarCliente(cliente); }
						
				}catch(NaoExisteException NEe){
					
					JOptionPane.showMessageDialog(null, NEe.getMessage());
					
				}catch(Exception a) {
					
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente por favor.");
					
				}
				
			}
		});
		btnPesquisa.setBounds(120, 159, 208, 54);
		contentPane.add(btnPesquisa);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
			}
		});
		btnVoltar.setBounds(10, 367, 89, 23);
		contentPane.add(btnVoltar);
		
		lblEscolhaUmaOpo = new JLabel("ESCOLHA UMA OP\u00C7\u00C3O");
		lblEscolhaUmaOpo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblEscolhaUmaOpo.setBounds(108, 11, 264, 35);
		contentPane.add(lblEscolhaUmaOpo);
	}

}
