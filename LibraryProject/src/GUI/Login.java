package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Person.Member;
import Person.Person;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUserId.setBounds(286, 80, 81, 36);
		contentPane.add(lblUserId);
		
		userId_textField = new JTextField();
		userId_textField.setBounds(371, 81, 188, 36);
		contentPane.add(userId_textField);
		userId_textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPassword.setBounds(286, 175, 81, 36);
		contentPane.add(lblPassword);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=userId_textField.getText();
				String password = password_textField.getText();
				System.out.println(username+password);
			}
		});
		btnSignIn.setBounds(301, 264, 112, 36);
		contentPane.add(btnSignIn);
		
		JButton btnSignUp = new JButton("Sign up ");
		btnSignUp.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSignUp.setBounds(447, 264, 112, 36);
		contentPane.add(btnSignUp);
		
		password_textField = new JTextField();
		password_textField.setColumns(10);
		password_textField.setBounds(371, 176, 188, 36);
		contentPane.add(password_textField);
		
		JLabel Icon_lbl = new JLabel("");
		Icon_lbl.setBounds(10, 69, 266, 241);
		Image img = new ImageIcon(this.getClass().getResource("/image/Apps-preferences-system-login-icon.png")).getImage();
		Icon_lbl.setIcon(new ImageIcon (img));
		contentPane.add(Icon_lbl);
	}
}
