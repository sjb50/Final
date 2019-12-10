
package GUI;

import Person.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame implements Serializable {
	static String peopleFile = "peopleCollection.txt";
	PersonCollection people = new PersonCollection();
	private JPanel contentPane;
	private JTextField userId_textField;
	private JTextField password_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUserId.setBounds(286, 80, 81, 36);
		contentPane.add(lblUserId);

		JLabel loginFailLbl = new JLabel("Log in failed");
		loginFailLbl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		loginFailLbl.setBounds(418, 206, 89, 36);
		contentPane.add(loginFailLbl);
		loginFailLbl.setVisible(false);

		JLabel Icon_lbl = new JLabel("");
		Icon_lbl.setBounds(10, 69, 266, 241);
		Image img = new ImageIcon(this.getClass().getResource("/image/Apps-preferences-system-login-icon.png"))
				.getImage();
		Icon_lbl.setIcon(new ImageIcon(img));
		contentPane.add(Icon_lbl);

		;

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPassword.setBounds(286, 175, 81, 36);
		contentPane.add(lblPassword);

		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setBackground(Color.WHITE);
		btnSignIn.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loadFile();
					int username = Integer.parseInt(userId_textField.getText());
					String password = password_textField.getText();
					for (int count = 0; count < people.getManyMembers(); count++) {
						if (people.getPeople()[count] instanceof Employee) {
							Employee tester = (Employee) people.getPeople()[count];
							if (tester.getPassword().equals(password) && tester.getId() == username) {
								HomeScreen home = new HomeScreen();
								home.setVisible(true);
								break;
							}
						}
					}
				} catch (Exception ex) {
					loginFailLbl.setVisible(true);
				}
				loginFailLbl.setVisible(true);
			}
		});
		btnSignIn.setBounds(406, 249, 112, 36);
		contentPane.add(btnSignIn);

		JButton btnSignUp = new JButton("New Employee");
		btnSignUp.setBackground(Color.WHITE);
		btnSignUp.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSignUp.setBounds(406, 11, 153, 36);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration empSignUp = new Registration();
				empSignUp.setVisible(true);
			}
		});
		contentPane.add(btnSignUp);

		password_textField = new JTextField();
		password_textField.setColumns(10);
		password_textField.setBounds(371, 176, 188, 36);
		contentPane.add(password_textField);

		userId_textField = new JTextField();
		userId_textField.setBounds(371, 81, 188, 36);
		contentPane.add(userId_textField);
		userId_textField.setColumns(10);
	}

	public void loadFile() {
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(peopleFile);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			people = (PersonCollection) in.readObject();

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
}
