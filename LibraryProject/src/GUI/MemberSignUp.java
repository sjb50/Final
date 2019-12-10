package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Books.BookCollection;
import Person.Member;
import Person.Person;
import Person.PersonCollection;

import java.awt.Color;
import javax.swing.JButton;

public class MemberSignUp extends JFrame {

	String memberCollectionFile = "memberCollection.text";
	PersonCollection member = new PersonCollection();

	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_contact;

	public MemberSignUp() {
		loadFile();
		setBackground(new Color(153, 204, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		JLabel lblFirstName = new JLabel("Name:");
		lblFirstName.setFont(new Font("Arial", Font.BOLD, 15));
		lblFirstName.setBounds(47, 152, 95, 26);
		contentPane.add(lblFirstName);

		JLabel lblContact = new JLabel("Contact:");
		lblContact.setFont(new Font("Arial", Font.BOLD, 15));
		lblContact.setBounds(47, 214, 95, 26);
		contentPane.add(lblContact);

		textField_name = new JTextField();
		textField_name.setBackground(Color.LIGHT_GRAY);
		textField_name.setBounds(169, 154, 150, 24);
		contentPane.add(textField_name);
		textField_name.setColumns(10);

		textField_contact = new JTextField();
		textField_contact.setBackground(Color.LIGHT_GRAY);
		textField_contact.setColumns(10);
		textField_contact.setBounds(169, 216, 150, 24);
		contentPane.add(textField_contact);

		JTextField ErrTextField = new JTextField();
		ErrTextField.setBackground(Color.WHITE);
		ErrTextField.setText("Error:Missing data, please fill out everything");
		ErrTextField.setBounds(47, 264, 227, 26);
		contentPane.add(ErrTextField);
		ErrTextField.setVisible(false);
		ErrTextField.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 15));
		btnSubmit.setBounds(188, 301, 95, 33);
		contentPane.add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_contact.getText().equals("") || textField_name.getText().equals("")) {
					ErrTextField.setVisible(true);
				} else {
					ErrTextField.setVisible(false);
					Member newmember = new Member(textField_name.getText(),textField_contact.getText());
					System.out.println(newmember);
					member.add(newmember);
					saveFile();
					System.out.println(member.readAll());
				}

			}

		});

	}

	public void loadFile() {
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(memberCollectionFile);
			ObjectInputStream in = new ObjectInputStream(file);
			// Method for deserialization of object
			member = (PersonCollection) in.readObject();
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
			FileOutputStream file = new FileOutputStream(memberCollectionFile);
			ObjectOutputStream out = new ObjectOutputStream(file);
			// Method for serialization of object
			out.writeObject(member);
			out.close();
			file.close();
			System.out.println("Object has been serialized");

		}

		catch (IOException ex) {
			System.out.println(ex);
		}

	}

}
