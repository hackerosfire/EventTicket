package com.EventTicket.EventTicket;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

public class OrgFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void orgFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrgFrame frame = new OrgFrame();
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
	public OrgFrame() {
		setTitle("Organisator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addEvent = new JButton("Add Event");
		addEvent.setBounds(130, 343, 89, 23);
		contentPane.add(addEvent);
		
		JButton btnNewButton_1 = new JButton("Edit Event");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(347, 93, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(347, 28, 138, 20);
		contentPane.add(comboBox);
		
		JFormattedTextField textName = new JFormattedTextField();
		textName.setBounds(130, 28, 110, 20);
		contentPane.add(textName);
		
		JFormattedTextField textCapacity = new JFormattedTextField();
		textCapacity.setBounds(130, 59, 110, 20);
		contentPane.add(textCapacity);
		
		JFormattedTextField textPrice = new JFormattedTextField();
		textPrice.setBounds(130, 90, 110, 20);
		contentPane.add(textPrice);
		
		JFormattedTextField textTPP = new JFormattedTextField();
		textTPP.setBounds(130, 121, 110, 20);
		contentPane.add(textTPP);
		
		JLabel lblEventName = new JLabel("Event Name");
		lblEventName.setBounds(10, 31, 110, 14);
		contentPane.add(lblEventName);
		
		JLabel lblEventCapacity = new JLabel("Event Capacity");
		lblEventCapacity.setBounds(10, 62, 110, 14);
		contentPane.add(lblEventCapacity);
		
		JLabel lblNewLabel = new JLabel("Ticket Price");
		lblNewLabel.setBounds(10, 93, 110, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ticker Per Person");
		lblNewLabel_1.setBounds(10, 124, 110, 14);
		contentPane.add(lblNewLabel_1);
		
		JFormattedTextField textLocation = new JFormattedTextField();
		textLocation.setBounds(130, 152, 110, 20);
		contentPane.add(textLocation);
		
		JLabel lblNewLabel_2 = new JLabel("Location");
		lblNewLabel_2.setBounds(10, 155, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblDate = new JLabel("Day");
		lblDate.setBounds(10, 180, 46, 14);
		contentPane.add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("YYYY/M/d");
		dateChooser.setBounds(128, 183, 91, 20);
		contentPane.add(dateChooser);
		addEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String evName, location;
				double ticketPrice;
				int tpp,capacity;
				//Date evDate=new Date(dateChooser.getDate().toString());
				java.util.Date datee = (java.util.Date) dateChooser.getDate();
				java.sql.Date sqlDate = new java.sql.Date(datee.getTime());
				sqlDate.setMonth(datee.getMonth());
				sqlDate.setDate(datee.getDay());
				sqlDate.setYear(datee.getYear());
				evName = String.valueOf(textName.getText());
				location = String.valueOf(textLocation.getText());
				capacity = Integer.valueOf(textCapacity.getText());
				tpp = Integer.valueOf(textTPP.getText());
				ticketPrice = Double.valueOf(textPrice.getText());
				//System.out.println(evDate.getDate());
				TestMain.addEvent(evName, location, capacity, tpp, ticketPrice,sqlDate);
			}
		});
	}
}
