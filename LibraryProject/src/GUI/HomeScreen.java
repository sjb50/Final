package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollBar;

public class HomeScreen extends JFrame {

	private JPanel contentPane;
	private JTextField search_textField;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public HomeScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 747);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Library_lbl = new JLabel("");
		Library_lbl.setBounds(286, -46, 148, 147);
		Image img = new ImageIcon(this.getClass().getResource("/image/Books-1-icon.png")).getImage();
		Library_lbl.setIcon(new ImageIcon(img));
		contentPane.add(Library_lbl);

		JLabel search_lbl = new JLabel("");
		search_lbl.setBackground(Color.WHITE);
		search_lbl.setBounds(107, 169, 31, 32);
		Image img1 = new ImageIcon(this.getClass().getResource("/image/search-icon.png")).getImage();
		search_lbl.setIcon(new ImageIcon(img1));
		contentPane.add(search_lbl);

		JLabel lblNewLabel = new JLabel("SAN LIBRARY");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(10, -20, 325, 121);
		contentPane.add(lblNewLabel);

		String[] sortMethod = { "Author", "Title" };
		JComboBox sort_comboBox = new JComboBox(sortMethod);
		sort_comboBox.setFont(new Font("Arial", Font.BOLD, 15));
		sort_comboBox.setForeground(Color.BLACK);
		sort_comboBox.setBackground(Color.BLACK);
		sort_comboBox.setBounds(132, 169, 105, 32);
		contentPane.add(sort_comboBox);

		search_textField = new JTextField();
		search_textField.setBounds(237, 169, 293, 32);
		contentPane.add(search_textField);
		search_textField.setColumns(10);

		JButton logout_btn = new JButton("");
		logout_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		logout_btn.setBackground(Color.WHITE);
		logout_btn.setBounds(630, 11, 91, 55);
		Image logoutimg = new ImageIcon(this.getClass().getResource("/image/LOGOUT.png")).getImage();
		logout_btn.setIcon(new ImageIcon(logoutimg));
		contentPane.add(logout_btn);

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("EditorPane.border"));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 91, 731, 55);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton addBook_btn = new JButton("Add Book");
		addBook_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBook newBook = new AddBook();
				newBook.setVisible(true);
			}
		});
		addBook_btn.setBounds(10, 11, 150, 33);
		panel.add(addBook_btn);
		addBook_btn.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		JButton bookCollection_btn = new JButton("Book Collection");
		bookCollection_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		bookCollection_btn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bookCollection_btn.setBounds(170, 11, 176, 33);
		panel.add(bookCollection_btn);
		bookCollection_btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		JButton memberSignup_btn = new JButton("Member Sign Up");
		memberSignup_btn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		memberSignup_btn.setBounds(356, 11, 176, 33);
		memberSignup_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberSignUp newMember = new MemberSignUp();
				newMember.setVisible(true);
			}
		});
		panel.add(memberSignup_btn);

		JButton memberList_btn = new JButton("Member List");
		memberList_btn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		memberList_btn.setBounds(542, 11, 179, 33);
		panel.add(memberList_btn);
		memberList_btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		JButton btnNewButton = new JButton("Search ");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(540, 169, 91, 32);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(10, 240, 711, 457);
		contentPane.add(textField);
		textField.setColumns(10);

	}
}
