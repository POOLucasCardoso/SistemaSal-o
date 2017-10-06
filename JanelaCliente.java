import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class JanelaCliente extends JFrame{

	private JPanel contentPane;
	private JButton btnCadastra;
	private JButton btnRemove;
	private JButton btnPesquisa;
	private JButton btnVoltar;
	
	/**
	 * Create the frame.
	 */
	public JanelaCliente(SistemaSalao system) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		btnCadastra = new JButton("Cadastra");
		btnCadastra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new janela2(system);
				
			}
		});
		btnCadastra.setBounds(60, 48, 89, 23);
		contentPane.add(btnCadastra);
		
		btnRemove = new JButton("Remove");
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
		btnRemove.setBounds(60, 124, 89, 23);
		contentPane.add(btnRemove);
		
		btnPesquisa = new JButton("Pesquisa");
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
		btnPesquisa.setBounds(224, 90, 89, 23);
		contentPane.add(btnPesquisa);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
			}
		});
		btnVoltar.setBounds(224, 177, 89, 23);
		contentPane.add(btnVoltar);
	}

}
