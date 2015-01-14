package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ScrollPaneConstants;

import data.HibernateUtil;
import domain.controllers.UcConsultarNivells.TupleNivells;

public class MainView extends JFrame {
	
	JugarPartidaCtrl ctrl;
	JPanel btnPanel;
	JPanel lvlPanel;
	
	public MainView(JugarPartidaCtrl ctrl) {
		this.ctrl = ctrl;
		initializeFrame();
		setTitle("Buscamines");
		pack();
		getContentPane().setLayout(null);
		
		btnPanel = new JPanel();
		btnPanel.setBounds(358, 138, 89, 23);
		getContentPane().add(btnPanel);
		btnPanel.setLayout(null);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(0, 0, 89, 23);
		btnPanel.add(btnPlay);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<TupleNivells> nivells = new ArrayList();
				try {
					nivells = ctrl.btnPlayPressed();
					changeToLevelPanel(nivells);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "System Message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(380, 280, 89, 23);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HibernateUtil.shutdown();
			}
		});
		getContentPane().add(btnExit);
		
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(MainView.class.getResource("/images/logo.png")));
		lblNewLabel.setBounds(10, 14, 309, 299);
		getContentPane().add(lblNewLabel);
		
		setVisible(true);
	}
	
	private void initializeFrame() {
		setMinimumSize(new Dimension(500, 350));
		setPreferredSize(getMinimumSize());
		setResizable(false);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			this.setIconImage(new ImageIcon(getClass().getResource("/images/logo.png")).getImage());
		} catch (Exception e) {
		}
	}
	
	private void changeToLevelPanel(List<TupleNivells> nivells) {
		lvlPanel = new JPanel();
		lvlPanel.setBounds(319, 39, 165, 156);
		getContentPane().add(lvlPanel);
		lvlPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(319, 80, 160, 88);
		getContentPane().add(scrollPane);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for (TupleNivells tuple : nivells) {
			listModel.addElement(tuple.nom +" "+ Integer.toString(tuple.nombreCasellesxFila) + "x" + Integer.toString(tuple.nombreCasellesxColumna) + " Mines: " + Integer.toString(tuple.nombreMines));
		}
		JList<String> list = new JList<String>(listModel);
		scrollPane.setViewportView(list);
		list.setBounds(0, 25, 165, 123);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setSelectedIndex(0);
		
		JLabel lblNewLabel_1 = new JLabel("Elegeix el nivell:");
		lblNewLabel_1.setBounds(0, 0, 121, 14);
		lvlPanel.add(lblNewLabel_1);
		getContentPane().remove(btnPanel);
		getContentPane().add(lvlPanel);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setBounds(358, 206, 89, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				try {
					ctrl.btnStartPressed(nivells.get(index));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		
		pack();
		repaint();
	}
}
