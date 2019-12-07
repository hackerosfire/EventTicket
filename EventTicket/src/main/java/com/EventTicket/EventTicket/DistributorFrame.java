package com.EventTicket.EventTicket;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DistributorFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField lastnameField;
	private JTextField egnField;

	/**
	 * Launch the application.
	 */
	public static void DistributorFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DistributorFrame frame = new DistributorFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DistributorFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 38, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 73, 59, 14);
		contentPane.add(lblLastName);
		
		JLabel lblEgn = new JLabel("EGN");
		lblEgn.setBounds(10, 110, 46, 14);
		contentPane.add(lblEgn);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 150, 46, 14);
		contentPane.add(lblPrice);
		
		JComboBox eventComboBox = new JComboBox();
		eventComboBox.setBounds(78, 10, 87, 20);
		contentPane.add(eventComboBox);
		eventComboBox.setModel(new DefaultComboBoxModel(TestMain.getEvents().toArray()));
		
		JLabel priceLabel = new JLabel("Click to load Price");
		priceLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				priceLabel.setText(String.valueOf(((Event) eventComboBox.getSelectedItem()).getPrice()));
			}
		});
		priceLabel.setBounds(78, 150, 46, 14);
		contentPane.add(priceLabel);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("EventTicket");
			EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
			if(TestMain.getTicketsSold(egnField.getText())<=Integer.valueOf(((Event) eventComboBox.getSelectedItem()).getPerPerson()))
				TestMain.addТicket(nameField.getText(), lastnameField.getText(), egnField.getText(),em.getReference(Distributor.class, login.getCurrentId()),(Event)eventComboBox.getSelectedItem());
			else
			{
				JOptionPane.showMessageDialog(null,"Tickets per person limit reached!");
			}
			}

		});
		btnBuy.setBounds(76, 227, 89, 23);
		contentPane.add(btnBuy);
		
		nameField = new JTextField();
		nameField.setBounds(79, 35, 86, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		lastnameField = new JTextField();
		lastnameField.setBounds(79, 70, 86, 20);
		contentPane.add(lastnameField);
		lastnameField.setColumns(10);
		
		egnField = new JTextField();
		egnField.setBounds(79, 107, 86, 20);
		contentPane.add(egnField);
		egnField.setColumns(10);
		
		JLabel lblEvent = new JLabel("Event");
		lblEvent.setBounds(10, 13, 46, 14);
		contentPane.add(lblEvent);
		

	}
}
