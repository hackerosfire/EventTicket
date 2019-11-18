package com.EventTicket.EventTicket;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class AdminFrame extends JFrame {
		private JPanel contentPane;
		private JPasswordField passwordField;
	
		/**
		 * Launch the application.
		 */
		public static void adminFrame() {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AdminFrame frame = new AdminFrame();
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
		public AdminFrame() {
			setTitle("Create Accounts");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 522, 334);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Username");
			lblNewLabel.setBounds(55, 48, 70, 14);
			contentPane.add(lblNewLabel);
			
			JFormattedTextField formattedTextField = new JFormattedTextField();
			formattedTextField.setBounds(135, 45, 130, 20);
			contentPane.add(formattedTextField);
			
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setBounds(55, 80, 70, 14);
			contentPane.add(lblPassword);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(135, 77, 130, 20);
			contentPane.add(passwordField);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"admin", "organisator", "distributor"}));
			comboBox.setBounds(135, 108, 130, 20);
			contentPane.add(comboBox);
			
			JLabel lblNewLabel_1 = new JLabel("Account Type");
			lblNewLabel_1.setBounds(35, 111, 90, 14);
			contentPane.add(lblNewLabel_1);
			
			JButton btnCreateAccount = new JButton("Create Account");
			btnCreateAccount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String userName = String.valueOf(formattedTextField.getText());
					String password = String.valueOf(passwordField.getPassword());
					String accType = String.valueOf(comboBox.getSelectedItem());
					if(accType=="admin")
					{
						TestMain a = new TestMain();
						if(a.getAdminByName(userName).getUsername().equals(userName) || a.getAdminByName(userName).getUsername().equals(null))//throws exception if username is not in database
						{
							JOptionPane.showMessageDialog(null, "Username already in use", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							a.addAdmin(userName, password);
							JOptionPane.showMessageDialog(null, "Account Created", "InfoBox: " + "Success", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					if(accType=="organisator")
					{
						TestMain o = new TestMain();
						if(o.getOrganisatorByName(userName).getUsername().equals(userName) || o.getAdminByName(userName).getUsername().equals(null))
						{
							JOptionPane.showMessageDialog(null, "Username already in use", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							o.addOrganisator(userName, password);
							JOptionPane.showMessageDialog(null, "Account Created", "InfoBox: " + "Success", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					if(accType=="distributor")
					{
						TestMain d = new TestMain();
						if(d.getDistributorByName(userName).getUsername().equals(userName) || d.getAdminByName(userName).getUsername().equals(null))
						{
							JOptionPane.showMessageDialog(null, "Username already in use", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							d.addDistributor(userName, password);
							JOptionPane.showMessageDialog(null, "Account Created", "InfoBox: " + "Success", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
				}
			});
			btnCreateAccount.setBounds(135, 153, 130, 23);
			contentPane.add(btnCreateAccount);
			
			JLabel lblWelcome = new JLabel("Welcome");
			lblWelcome.setBounds(55, 11, 70, 14);
			contentPane.add(lblWelcome);
			//lblNewLabel_2.setText();
			
			
		}
	}
