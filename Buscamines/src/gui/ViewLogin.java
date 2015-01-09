package gui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class ViewLogin extends JFrame {

	private JugarPartidaCtrl ctrl;
	private JTextField textField;
	private JPasswordField textField_1;

	public ViewLogin(JugarPartidaCtrl ctrl) {
		this.ctrl = ctrl;
		initializeFrame();
		setTitle("Buscamines");
		pack();
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(58, 43, 67, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(58, 72, 67, 14);
		getContentPane().add(lblPassword);

		textField = new JTextField();
		textField.setBounds(134, 43, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JPasswordField();
		textField_1.setBounds(134, 72, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(36, 137, 89, 23);
		getContentPane().add(btnEnter);
		
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//----FALTA FICAR UNA OR AMB UNA EXCEPCIO DEL DOMINI DE QUE NO ES CORRECTE
				if (textField.getText().isEmpty() || textField_1.getPassword().length == 0)
					JOptionPane.showMessageDialog(null, "Usuari o password incorrecte", "System Message", JOptionPane.INFORMATION_MESSAGE);
				else {
					dispose();
					new MainView(ctrl);
				}
			}
		});

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(172, 137, 89, 23);
		getContentPane().add(btnExit);

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	private void initializeFrame() {
		setMinimumSize(new Dimension(300, 200));
		setPreferredSize(getMinimumSize());
		setResizable(false);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    try {
			this.setIconImage(new ImageIcon(getClass().getResource("/images/logo.png")).getImage());
		} catch (Exception e) {
		}

	}

}
