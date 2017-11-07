import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class JanelaMestra extends JFrame implements ActionListener,WindowListener {

	private JPanel contentPane;
	JButton btnCliente;
	JButton btnFuncionario;
	SistemaSalao system = new SistemaSalao();
	private JButton btnProduto;
	private JButton btnServico;
	private JButton btnAgenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaMestra frame = new JanelaMestra();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaMestra() {
		setTitle("Sistema Sal\u00E3o");
		addWindowListener(this);
		setBounds(100, 100, 739, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(this);
		btnCliente.setBounds(481, 61, 126, 39);
		contentPane.add(btnCliente);
		
		btnFuncionario = new JButton("Funcion\u00E1rio");
		btnFuncionario.addActionListener(this);
		btnFuncionario.setBounds(481, 111, 126, 39);
		contentPane.add(btnFuncionario);
		
		btnProduto = new JButton("Produto");
		btnProduto.addActionListener(this);
		btnProduto.setBounds(481, 161, 126, 39);
		contentPane.add(btnProduto);
		
		btnServico = new JButton("Servi\u00E7o");
		btnServico.addActionListener(this);
		btnServico.setBounds(481, 211, 126, 39);
		contentPane.add(btnServico);
		
		btnAgenda = new JButton("Agenda");
		btnAgenda.addActionListener(this);
		btnAgenda.setBounds(481, 11, 126, 39);
		contentPane.add(btnAgenda);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				
				system.finaliza();
				
				}catch(Exception e){
					
					JOptionPane.showMessageDialog(null,"Ocorreu algum erro, \nseus dados não serão salvos ao fechar o programa.");
					
				}
				
			}
		});
		btnSalvar.setBounds(634, 219, 89, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JanelaMestra.class.getResource("Logo.png")));
		lblNewLabel.setBounds(70, 5, 261, 261);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCliente) {
			
			new JanelaCliente(system);
			
		}else if(e.getSource()==btnFuncionario) {
			
			new JanelaFuncionario(system);
			
		}else if(e.getSource()==btnServico) {
			
			new JanelaServico(system);
			
		}else if(e.getSource()==btnProduto) {
			
			new JanelaProduto(system);
			
		}else if(e.getSource()==btnAgenda) {
			
			new InterfaceAgenda(system);
			
		}
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		try {
			system.finaliza();
			System.exit(-1);
		}catch(Exception a){
			int conf = JOptionPane.showConfirmDialog(null, "Ocorreu algum erro no salvamento dos seus dados,\ndeseja sair assim mesmo?");
			if (conf == 0) {
				System.exit(-1);
			}
		}
		
		
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}