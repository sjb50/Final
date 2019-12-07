package GUI;
import Person.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Registration extends JFrame {
	PersonCollection collection = new PersonCollection();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField password_textField;
	private JTextField textField_3;

	/**
	 * Launch the application. test
	 */


	/**
	 * Create the frame.
	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 460);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLibrary = new JLabel("SAN LIBRARY ");
		lblLibrary.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		lblLibrary.setBounds(47, 13, 216, 40);
		contentPane.add(lblLibrary);
		
		JLabel lblLibrary_Account = new JLabel("Create your Library Account");
		lblLibrary_Account.setFont(new Font("Arial", Font.BOLD, 15));
		lblLibrary_Account.setBounds(47, 64, 216, 26);
		contentPane.add(lblLibrary_Account);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Arial", Font.BOLD, 15));
		lblFirstName.setBounds(47, 124, 95, 26);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Arial", Font.BOLD, 15));
		lblLastName.setBounds(47, 161, 95, 26);
		contentPane.add(lblLastName);
		
		JLabel password_lbl = new JLabel("Password");
		password_lbl.setFont(new Font("Arial", Font.BOLD, 15));
		password_lbl.setBounds(47, 197, 95, 26);
		contentPane.add(password_lbl);
		
		JLabel lblContact = new JLabel("Contact:");
		lblContact.setFont(new Font("Arial", Font.BOLD, 15));
		lblContact.setBounds(47, 234, 95, 26);
		contentPane.add(lblContact);
		
		JButton btnSubmit = new JButton("Submit ");
		btnSubmit.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSubmit.setBackground(new Color(112, 128, 144));
		btnSubmit.setBounds(156, 309, 141, 33);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee newEmployee = new Employee(textField.getText(),textField_1.getText(),password_textField.getName());
				collection.add(newEmployee);
				
			}
		});
		contentPane.add(btnSubmit);
		
		textField = new JTextField();
		textField.setBackground(new Color(192, 192, 192));
		textField.setBounds(148, 124, 181, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(192, 192, 192));
		textField_1.setColumns(10);
		textField_1.setBounds(148, 161, 181, 26);
		contentPane.add(textField_1);
		
		password_textField = new JTextField();
		password_textField.setBackground(new Color(192, 192, 192));
		password_textField.setForeground(new Color(192, 192, 192));
		password_textField.setColumns(10);
		password_textField.setBounds(148, 201, 181, 26);
		contentPane.add(password_textField);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(192, 192, 192));
		textField_3.setColumns(10);
		textField_3.setBounds(148, 238, 181, 26);
		contentPane.add(textField_3);
		
	
		JLabel lblBackImage = new JLabel();
		lblBackImage.setFont(new Font("Arial", Font.PLAIN, 11));
		lblBackImage.setBackground(new Color(153, 204, 255));
		lblBackImage.setBounds(0, 0, 408, 421);
		contentPane.add(lblBackImage);
	
	}

}
