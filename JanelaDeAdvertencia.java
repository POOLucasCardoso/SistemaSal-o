import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JanelaDeAdvertencia extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaDeAdvertencia(String texto) {
		setTitle("Aten\u00E7\u00E3o!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 123);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		JLabel label = new JLabel(texto);
		contentPane.add(label, BorderLayout.CENTER);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(JanelaDeAdvertencia.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
		contentPane.add(lblIcon, BorderLayout.WEST);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(Color.PINK);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		contentPane.add(btnOk, BorderLayout.EAST);
	}

}
