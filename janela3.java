import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class janela3 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public janela3(SistemaSalao system) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 74, 225, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("Informe os Dados");
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label.setBounds(144, 11, 189, 26);
		contentPane.add(label);
		
		JLabel lblTipoDeProduto = new JLabel("Tipo de produto:");
		lblTipoDeProduto.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTipoDeProduto.setBounds(10, 105, 130, 20);
		contentPane.add(lblTipoDeProduto);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(244, 74, 225, 20);
		contentPane.add(textField_1);
		
		JLabel lblMarcaDoProduto = new JLabel("Marca do produto:");
		lblMarcaDoProduto.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblMarcaDoProduto.setBounds(244, 48, 130, 20);
		contentPane.add(lblMarcaDoProduto);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do produto:");
		lblNomeDoProduto.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNomeDoProduto.setBounds(10, 43, 130, 20);
		contentPane.add(lblNomeDoProduto);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 136, 225, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(244, 136, 225, 20);
		contentPane.add(textField_3);
		
		JLabel lblPrecoDoProduto = new JLabel("Preco do produto:");
		lblPrecoDoProduto.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPrecoDoProduto.setBounds(244, 105, 130, 20);
		contentPane.add(lblPrecoDoProduto);
		
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		button.setBounds(10, 227, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("salvar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textField.getText();
				String marca = textField_1.getText();
				String tipo = textField_2.getText();
				String numero = textField_3.getText();
				
				try {
					
					double preco = Double.parseDouble(numero);
					
					if(preco<0) {
						
						JOptionPane.showMessageDialog(null,"Preço inválido.");
						
					}else {
					
						Produto produto = new Produto(marca, tipo, nome, preco);
					
						system.cadastraProduto(produto);
						
						JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso");
					
					}
					
				}catch(JaExisteException JEe) {
					
					JOptionPane.showMessageDialog(null,JEe.getMessage());
					
					dispose();
					
				}catch(NumberFormatException NFe) {
					
					JOptionPane.showMessageDialog(null,"Preço inválido.");
					
				}catch(Exception a) {
					
					JOptionPane.showMessageDialog(null,"Ocorreu um erro, por favor, tente novamente.");
					
				}
				
			}
		});
		button_1.setBounds(380, 227, 89, 23);
		contentPane.add(button_1);
	}
}
