package com.EventTicket.EventTicket;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	static int currentId;
	static String currentUserName;

	/**
	 * Launch the application.
	 */
	public static void loginFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"admin", "organisator", "distributor"}));
		comboBox.setBounds(149, 95, 105, 20);
		contentPane.add(comboBox);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(43, 42, 60, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(43, 67, 60, 14);
		contentPane.add(lblPassword);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(149, 39, 218, 20);
		contentPane.add(formattedTextField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(149, 64, 218, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				TestMain obj = new TestMain();
				
				if(String.valueOf(comboBox.getSelectedItem())=="admin") {
					Admin a = obj.getAdminByName(String.valueOf(formattedTextField.getText()));
					if(a.getUsername().equals(String.valueOf(formattedTextField.getText())))
					{
						if(a.getPassword().equals(String.valueOf(passwordField.getPassword()))) {
							System.out.println("login successful - admin");
							currentId = a.getId();
							currentUserName = a.getUsername();
							AdminFrame admFrm = new AdminFrame();
							admFrm.adminFrame();
							dispose();
						}
						else
						{
							dispose();
							frame1 mainframe = new frame1();
							mainframe.frame();
						}
					}
				}
				else if(String.valueOf(comboBox.getSelectedItem())=="organisator") {
					Organisator o = obj.getOrganisatorByName(String.valueOf(formattedTextField.getText()));
					if(o.getUsername().equals(String.valueOf(formattedTextField.getText())))
					{
						if(o.getPassword().equals(String.valueOf(passwordField.getPassword()))) {
							System.out.println("login successful - organisator");
							currentId = o.getOrganisatorid();
							currentUserName = o.getUsername();
							OrgFrame orgFrm = new OrgFrame();
							orgFrm.orgFrame();
							dispose();
						}
						else
						{
							dispose();
							frame1 mainframe = new frame1();
							mainframe.frame();
						}
					}
					
				}
				else if(String.valueOf(comboBox.getSelectedItem())=="distributor") {
					Distributor d = obj.getDistributorByName(String.valueOf(formattedTextField.getText()));
					if(d.getUsername().equals(String.valueOf(formattedTextField.getText())))
					{
						if(d.getPassword().equals(String.valueOf(passwordField.getPassword()))) {
							System.out.println("login successful - distributor");
							currentId = d.getId();
							currentUserName = d.getUsername();
							dispose();
						}
						else
						{
							dispose();
							//JOptionPane.showMessageDialog(null, "Wrong information", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
							frame1 mainframe = new frame1();
							mainframe.frame();
						}
					}
				}
			}
		});
		btnLogin.setBounds(149, 145, 89, 23);
		contentPane.add(btnLogin);
	}

	public static int getCurrentId() {
		return currentId;
	}
	public static String getCurrentUserName() {
		return currentUserName;
	}
	

}
