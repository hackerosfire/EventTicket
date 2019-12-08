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
import java.util.List;

public class DistributorFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField lastnameField;
	private JTextField egnField;
	private List<Invitation> invs = null;
	private List<Invitation> acceptedInvs = null;

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
		setBounds(100, 100, 645, 300);
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
		JComboBox invitations = new JComboBox();
		invitations.setBounds(285, 10, 86, 20);
		contentPane.add(invitations);
		
		JComboBox acceptedEvents = new JComboBox();
		acceptedEvents.setBounds(285, 35, 87, 20);
		contentPane.add(acceptedEvents);
		
		JLabel lblPending = new JLabel("Pending Invitations");
		lblPending.setBounds(175, 13, 120, 14);
		contentPane.add(lblPending);
		
		JLabel lblAccepted = new JLabel("Accepted Events");
		lblAccepted.setBounds(175, 38, 120, 14);
		contentPane.add(lblAccepted);
		
		JButton btnAcceptInvite = new JButton("Accept");
		btnAcceptInvite.setBounds(381, 9, 89, 23);
		contentPane.add(btnAcceptInvite);
		
		JButton btnDeclineInvite = new JButton("Decline");
		btnDeclineInvite.setBounds(480, 9, 89, 23);
		contentPane.add(btnDeclineInvite);
		invs = TestMain.getPendingInvitationsByDistributorId(login.getCurrentId());
		if(invs == null )
		{
			System.out.println("null invitations");
		}
		else
		{
			invitations.setModel(new DefaultComboBoxModel(invs.toArray()));
		}
		acceptedInvs = TestMain.getAcceptedInvitationsByDistributorId(login.getCurrentId());
		if(acceptedInvs == null )
		{
			System.out.println("null invitations");
		}
		else
		{
		acceptedEvents.setModel(new DefaultComboBoxModel(acceptedInvs.toArray()));
		}
		btnAcceptInvite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Invitation i = new Invitation();
				i = (Invitation) invitations.getSelectedItem();
				TestMain.acceptInv(i.getId());
				invs = TestMain.getPendingInvitationsByDistributorId(login.getCurrentId());
				if(invs == null )
				{
					System.out.println("null invitations");
					invitations.setModel(new DefaultComboBoxModel(invs.toArray()));
				}
				else
				{
				invitations.setModel(new DefaultComboBoxModel(invs.toArray()));
				}
				acceptedInvs = TestMain.getAcceptedInvitationsByDistributorId(login.getCurrentId());
				if(acceptedInvs == null )
				{
					System.out.println("null invitations");
				}
				else
				{
				acceptedEvents.setModel(new DefaultComboBoxModel(acceptedInvs.toArray()));
				}

			}
		});
		btnDeclineInvite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Invitation i = new Invitation();
				i = (Invitation) invitations.getSelectedItem();
				TestMain.declineInv(i.getId());
				invs = TestMain.getPendingInvitationsByDistributorId(login.getCurrentId());
				if(invs == null )
				{
					System.out.println("null invitations");
					invitations.setModel(new DefaultComboBoxModel(invs.toArray()));
				}
				else
				{
				invitations.setModel(new DefaultComboBoxModel(invs.toArray()));
				}
				acceptedInvs = TestMain.getAcceptedInvitationsByDistributorId(login.getCurrentId());
				if(acceptedInvs == null )
				{
					System.out.println("null invitations");
				}
				else
				{
				acceptedEvents.setModel(new DefaultComboBoxModel(acceptedInvs.toArray()));
				}

			}
		});

	}
}
