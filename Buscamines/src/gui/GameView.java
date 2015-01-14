package gui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import data.HibernateUtil;
import domain.controllers.UcJugarPartida;
import domain.controllers.UcJugarPartida.Tresult;


public class GameView extends JFrame {
	
	private int rows, cols;
	JugarPartidaCtrl ctrl;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtMessageArea;
	private JPanel gridPanel;
	private int tirades;
	
	public GameView(int rows, int cols, JugarPartidaCtrl jugarPartidaCtrl) {
		this.rows = rows;
		this.cols = cols;
		this.ctrl = jugarPartidaCtrl;
		this.tirades = 0;
		
		initializeFrame();
		int w = (int) getSize().getWidth();
		int h = (int) getSize().getHeight();
		getContentPane().setLayout(null);
		
		JLabel lblTemps = new JLabel("Temps:");
		lblTemps.setBounds(10, 11, 46, 14);
		getContentPane().add(lblTemps);
		
		JLabel lblTirades = new JLabel("Tirades:");
		lblTirades.setBounds(10, 33, 46, 14);
		getContentPane().add(lblTirades);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setForeground(Color.RED);
		textField.setBackground(Color.DARK_GRAY);
		textField.setEditable(false);
		textField.setBounds(66, 8, 86, 20);
		getContentPane().add(textField);
		textField.setText("000");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.RED);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setBackground(Color.DARK_GRAY);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(66, 30, 86, 20);
		textField_1.setText(Integer.toString(tirades));
		getContentPane().add(textField_1);
		
		txtMessageArea = new JTextField();
		txtMessageArea.setBackground(Color.WHITE);
		txtMessageArea.setHorizontalAlignment(SwingConstants.CENTER);
		txtMessageArea.setText("Message area");
		txtMessageArea.setEditable(false);
		txtMessageArea.setBounds(w/2- 89, 8, 223, 42);
		getContentPane().add(txtMessageArea);
		txtMessageArea.setColumns(10);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(w-110, 17, 89, 23);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDialog("Segur que voleu sortir?");
			}
		});
		getContentPane().add(btnExit);
		
		configureGrid();
		
		setVisible(true);		
	}
	
	private void initializeFrame() {
		setTitle("Buscamines");
		int w,h;
		w = (26*cols < 500)?500:26*cols;
		h = (26*rows < 320)?320:26*rows;
		System.out.println(w+"x");
		System.out.println(h+"x");
		setMinimumSize(new Dimension(w,h));
		setPreferredSize(getMinimumSize());
		setResizable(false);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			this.setIconImage(new ImageIcon(getClass().getResource("/images/logo.png")).getImage());
		} catch (Exception e) {
		}
	}
	
	private void configureGrid() {
		gridPanel = new JPanel();
		int w = (int) getSize().getWidth();
		int h = (int) getSize().getHeight();
		gridPanel.setBounds((w/2)-(20*cols/2), (h/2)-(20*rows/2), 20*cols, 20*rows);
		getContentPane().add(gridPanel);
		gridPanel.setLayout(new GridLayout(rows,cols));
		System.out.println("Abans de entrar al for xato");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				JButton butCasella = new JButton();
				gridPanel.add(butCasella);
				butCasella.addMouseListener(new HandlerCasella(i+1,j+1,this));
				butCasella.setMargin(new Insets(0,0,0,0));
				butCasella.setFont(new Font("Tahoma", Font.BOLD, 16));
			}
		}
		System.out.println("Ja he fet el for xato");

	}
	
	private void showDialog(String textToShow) {
		int rep = JOptionPane.showConfirmDialog(null, textToShow, "System Message", 2);
		if (rep == JOptionPane.YES_OPTION) {
			HibernateUtil.shutdown();
			dispose();
		}
	}
	
	public void casellaClicadaEsquerre(String text) {
		txtMessageArea.setText(text);
	}
	
	public void casellaClicadaDreta(int x, int y) {
		txtMessageArea.setText(x+" "+y+" dreta");
	}
	
	private void actualitzaVista() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				JButton b = (JButton) gridPanel.getComponent(i*rows + j);
				ArrayList<Integer> infoC = null;
				try {
					infoC = ctrl.infoCasella(i+1,j+1);
					if (infoC.get(0) == 1) {
						b.setText(Integer.toString(infoC.get(1)));
						b.setEnabled(false);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	}
	
	private class HandlerCasella implements MouseListener {
		private int r,c;
		GameView cont;
		
		public HandlerCasella(int i, int j, GameView cont) {
			r = i;
			c = j;
			this.cont = cont;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e))
				try {
					System.out.println(Integer.toString(r) + " " + Integer.toString(c));
					Tresult result = ctrl.mouseEsquerrePressed(r,c);
					JButton b = (JButton) e.getSource();
					if (result.acabada) {
						System.out.println("Acabada");
						if (result.guanyada) {
							System.out.println("acabada ----------------");
							new MessageView("CONGRATULATIONS! "
									+ Integer.toString(result.numero)
									+ " points", ctrl);
							dispose();
						} else {
							new MessageView("GAME OVER", ctrl);
							dispose();
						}
					} else {
						b.setText(Integer.toString(result.numero));
						b.setEnabled(false);
						actualitzaVista();
						casellaClicadaEsquerre("Correct");
					}
					++tirades;
					textField_1.setText(Integer.toString(tirades));
				} catch (Exception e1) {
					casellaClicadaEsquerre(e1.getMessage());
				}
			else if (SwingUtilities.isRightMouseButton(e))
				try {
					ctrl.mouseDretPressed(r,c);
					JButton b = (JButton) e.getSource();
					if (b.getText().equals("*")) {
						b.setText("");
					}
					else {
						b.setText("*");
					}
					
				} catch (Exception e1) {
					casellaClicadaEsquerre(e1.getMessage());
				}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

}
