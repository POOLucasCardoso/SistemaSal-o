import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;

public class JanelaMestra extends JFrame implements ActionListener {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JLabel lblAa = new JLabel("");
		lblAa.setIcon(null);
		lblAa.setBounds(162, 53, 161, 114);
		contentPane.add(lblAa);
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
}
