package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MessageView extends JFrame {

	private String text;
	private JFrame previous;
	private JugarPartidaCtrl ctrl;
	
	public MessageView(String textToShow,JugarPartidaCtrl ctrl, JFrame prev) {
		this.text = textToShow;
		this.previous = prev;
		this.ctrl = ctrl;
		setTitle("System Message");
		setMinimumSize(new Dimension(300,200));
		setResizable(false);
		setLocationRelativeTo(null);
		try {
			this.setIconImage(new ImageIcon(getClass().getResource("/javax/swing/plaf/metal/icons/Error.gif")).getImage());
		} catch (Exception e) {
		}
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(textToShow);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(82, 45, 202, 42);
		getContentPane().add(lblNewLabel);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(103, 137, 89, 23);
		getContentPane().add(btnOk);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MessageView.class.getResource("/javax/swing/plaf/metal/icons/Error.gif")));
		lblNewLabel_1.setBounds(29, 45, 32, 42);
		getContentPane().add(lblNewLabel_1);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionBtnOk();
			}
		});
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				actionBtnOk();
			}
		});
		
		setTitle("System Message");
	    pack();
	    setVisible(true);
	}
	
	private void actionBtnOk() {
		setVisible(false);
		previous.setVisible(true);
		previous.setEnabled(true);
		dispose();
	}
}
