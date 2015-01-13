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

import data.HibernateUtil;

public class MessageView extends JFrame {

	private String text;
	private JugarPartidaCtrl ctrl;
	
	public MessageView(String textToShow,JugarPartidaCtrl ctrl) {
		this.text = textToShow;
		this.ctrl = ctrl;
		
		setTitle("System Message");
		setMinimumSize(new Dimension(300,200));
		setResizable(false);
		setLocationRelativeTo(null);
		try {
			this.setIconImage(new ImageIcon(getClass().getResource("/images/logo.png")).getImage());
		} catch (Exception e) {
		}
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(textToShow);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(45, 46, 202, 42);
		getContentPane().add(lblNewLabel);
		
		JButton btnOk = new JButton("New Game");
		btnOk.setBounds(29, 137, 115, 23);
		getContentPane().add(btnOk);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(169, 137, 89, 23);
		getContentPane().add(btnExit);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionBtnOk();
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionBtnExit();
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				actionBtnExit();
			}
		});
		
		setTitle("System Message");
	    pack();
	    setVisible(true);
	}
	
	private void actionBtnOk() {
		new MainView(ctrl);
		dispose();
	}
	
	private void actionBtnExit() {
		HibernateUtil.shutdown();
		dispose();
	}
}
