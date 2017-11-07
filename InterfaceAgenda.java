import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class InterfaceAgenda extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public InterfaceAgenda(SistemaSalao system) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 442);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new janela4(system);
				
			}
		});
		btnAgendar.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnAgendar.setBounds(118, 57, 208, 54);
		contentPane.add(btnAgendar);
		
		JButton button_3 = new JButton("Voltar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		button_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button_3.setBounds(10, 379, 89, 23);
		contentPane.add(button_3);
		
		JLabel label = new JLabel("ESCOLHA UMA OPÇÃO");
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label.setBounds(108, 11, 264, 35);
		contentPane.add(label);
		
		
		JTextArea txtrAgendamentos = new JTextArea();
		String texto = ("Agendamentos: \n");
		txtrAgendamentos.setBounds(10, 122, 424, 246);
		for (Apontamento a: system.agenda) {
			
			texto += a.getData()+", "+a.getHora()+": " +a.getServico().getTipo()+" de "+a.getCliente().getNome()+" com "+a.getFuncionario().getNome();
			
		}
		txtrAgendamentos.setText(texto);
		contentPane.add(txtrAgendamentos);
		
	}
}