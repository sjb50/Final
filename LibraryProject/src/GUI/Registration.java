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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Registration extends JFrame implements Serializable {
	String peopleFile = "peopleCollection.txt";
	PersonCollection collection = new PersonCollection();
	private JPanel contentPane;
	private JTextField NametextField;
	private JTextField password_textField;
	private JTextField ContactField;

	/**
	 * Launch the application. test
	 */

	/**
	 * Create the frame.
	 */
	public Registration() {
		loadFile();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 424, 460);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblError = new JLabel("Error:Missing data, please fill out everything");
		lblError.setBounds(57, 238, 272, 26);
		contentPane.add(lblError);
		lblError.setVisible(false);

		JLabel lblLibrary = new JLabel("SAN LIBRARY ");
		lblLibrary.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		lblLibrary.setBounds(47, 13, 216, 40);
		contentPane.add(lblLibrary);

		JLabel lblLibrary_Account = new JLabel("Create your Library Account");
		lblLibrary_Account.setFont(new Font("Arial", Font.BOLD, 15));
		lblLibrary_Account.setBounds(47, 64, 216, 26);
		contentPane.add(lblLibrary_Account);

		JLabel lblFirstName = new JLabel("Name:");
		lblFirstName.setFont(new Font("Arial", Font.BOLD, 15));
		lblFirstName.setBounds(47, 124, 95, 26);
		contentPane.add(lblFirstName);

		JLabel password_lbl = new JLabel("Password");
		password_lbl.setFont(new Font("Arial", Font.BOLD, 15));
		password_lbl.setBounds(47, 164, 95, 26);
		contentPane.add(password_lbl);

		JLabel lblContact = new JLabel("Contact:");
		lblContact.setFont(new Font("Arial", Font.BOLD, 15));
		lblContact.setBounds(47, 201, 95, 26);
		contentPane.add(lblContact);

		JButton btnSubmit = new JButton("Submit ");
		btnSubmit.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSubmit.setBackground(new Color(112, 128, 144));
		btnSubmit.setBounds(156, 309, 141, 33);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (NametextField.getText().equals("") || ContactField.getText().equals("")
						|| password_textField.getText().equals("")) {
					lblError.setVisible(true);
				} else {
					lblError.setVisible(false);
					Employee newEmployee = new Employee(NametextField.getText(), ContactField.getText(),
							password_textField.getText());
					System.out.println(newEmployee);
					collection.add(newEmployee);
					saveFile();
					System.out.println(collection.readAll());
				}
			}
		});
		contentPane.add(btnSubmit);

		NametextField = new JTextField();
		NametextField.setBackground(new Color(192, 192, 192));
		NametextField.setBounds(148, 124, 181, 26);
		contentPane.add(NametextField);
		NametextField.setColumns(10);

		password_textField = new JTextField();
		password_textField.setBackground(new Color(192, 192, 192));
		password_textField.setForeground(Color.BLACK);
		password_textField.setColumns(10);
		password_textField.setBounds(148, 165, 181, 26);
		contentPane.add(password_textField);

		ContactField = new JTextField();
		ContactField.setBackground(new Color(192, 192, 192));
		ContactField.setColumns(10);
		ContactField.setBounds(148, 202, 181, 26);
		contentPane.add(ContactField);

		JLabel lblBackImage = new JLabel();
		lblBackImage.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblBackImage.setBackground(new Color(153, 204, 255));
		lblBackImage.setBounds(0, 11, 408, 421);
		contentPane.add(lblBackImage);
	}

	public void loadFile() {
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(peopleFile);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			collection = (PersonCollection) in.readObject();

			in.close();
			file.close();

		}

		catch (IOException ex) {
			System.out.println(ex);
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}
	}

	
	public void saveFile() {
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(peopleFile);
			ObjectOutputStream out = new ObjectOutputStream(file);
			// Method for serialization of object
			out.writeObject(collection);
			out.close();
			file.close();
			System.out.println("Object has been serialized");

		}

		catch (IOException ex) {
			System.out.println(ex);
		}

	}
}
