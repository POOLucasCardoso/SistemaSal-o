import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class janela5 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public janela5(SistemaSalao system) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JLabel label = new JLabel("Informe os Dados");
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label.setBounds(140, 0, 189, 26);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(123, 102, 225, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(123, 182, 225, 20);
		contentPane.add(textField_1);
		
		JLabel lblTipoDeServico = new JLabel("Tipo de servico:");
		lblTipoDeServico.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTipoDeServico.setBounds(123, 71, 148, 20);
		contentPane.add(lblTipoDeServico);
		
		JLabel lblPrecoDoServico = new JLabel("Preco do servico:");
		lblPrecoDoServico.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPrecoDoServico.setBounds(123, 151, 148, 20);
		contentPane.add(lblPrecoDoServico);
		
		JButton button = new JButton("voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		button.setBounds(10, 237, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("salvar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tipo = textField.getText();
				String numero = textField_1.getText();
				
				if(tipo == ""){
					JOptionPane.showMessageDialog(null, "Não deixe nada em branco");
				}
				else if(numero == ""){
					JOptionPane.showMessageDialog(null, "Não deixe nada em branco");
				}
				else{
					try {
						
						double preco = Double.parseDouble(numero);
						
						Servico servico = new Servico(tipo,preco);
						
						system.cadastraServico(servico);


					} catch (JaExisteException JEe) {

						JOptionPane.showMessageDialog(null, JEe.getMessage());
						
					}catch (NumberFormatException NFe){
						
						JOptionPane.showMessageDialog(null, "Valor inválido.");

					} catch (Exception a) {

						JOptionPane.showMessageDialog(null, "Ocorreu algum erro, por vavor, tente novamente.");

					}
					
				}		
					JOptionPane.showMessageDialog(null, "Servico cadastrado com sucesso.");
				
				}
		});
		button_1.setBounds(381, 237, 89, 23);
		contentPane.add(button_1);
	}
}
