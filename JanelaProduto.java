import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;

public class JanelaProduto extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaProduto(SistemaSalao system) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 440);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Cadastra");
		button.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button.setBounds(120, 76, 208, 54);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Pesquisa");
		button_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button_1.setBounds(120, 159, 208, 54);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Remove");
		button_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button_2.setBounds(120, 243, 208, 54);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Voltar");
		button_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button_3.setBounds(10, 367, 89, 23);
		contentPane.add(button_3);
		
		JLabel label = new JLabel("ESCOLHA UMA OP\u00C7\u00C3O");
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label.setBounds(108, 11, 264, 35);
		contentPane.add(label);
	}
}