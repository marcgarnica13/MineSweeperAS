package gui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

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
				if (textField.getText().isEmpty() || textField_1.getPassword().length == 0)
					JOptionPane.showMessageDialog(null, "Usuari o password sense indicar", "System Message", JOptionPane.INFORMATION_MESSAGE);
				else {
					try {
						ctrl.btnEnterPressed(textField.getText(), textField_1.getPassword());
						dispose();
						new MainView(ctrl);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "System Message", JOptionPane.INFORMATION_MESSAGE);
					}
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
