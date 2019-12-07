package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Person.Employee;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField_AuthorName;
	private JTextField textField_TitleName;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AddBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 477);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Authore Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(40, 118, 118, 34);
		contentPane.add(lblNewLabel);

		JLabel lblTitleName = new JLabel("Title Name:");
		lblTitleName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTitleName.setBounds(40, 180, 118, 34);
		contentPane.add(lblTitleName);

		textField_AuthorName = new JTextField();
		textField_AuthorName.setBounds(227, 119, 175, 34);
		contentPane.add(textField_AuthorName);
		textField_AuthorName.setColumns(10);

		textField_TitleName = new JTextField();
		textField_TitleName.setColumns(10);
		textField_TitleName.setBounds(227, 181, 175, 34);
		contentPane.add(textField_TitleName);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(386, 393, 104, 34);
		contentPane.add(btnSubmit);

		JLabel lblNewLabel_1 = new JLabel("Display");
		lblNewLabel_1.setBackground(new Color(102, 153, 51));
		lblNewLabel_1.setBounds(40, 239, 146, 154);
		contentPane.add(lblNewLabel_1);

		JButton btnChoosePhoto = new JButton("Choose");
		btnChoosePhoto.setBounds(227, 239, 104, 34);
		contentPane.add(btnChoosePhoto);
		btnChoosePhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser chooser = new JFileChooser();
				    FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "JPG & GIF Images", "jpg", "gif");
				    chooser.setFileFilter(filter);
				    int returnVal = chooser.showOpenDialog(new JFileChooser());
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				       System.out.println("You chose to open this file: " +
				            chooser.getSelectedFile().getName());
				    }
			}
		});

		JLabel lblAddBook = new JLabel("Add Book");
		lblAddBook.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAddBook.setBounds(10, 0, 188, 55);
		contentPane.add(lblAddBook);

		JLabel Library_lbl = new JLabel("");
		Library_lbl.setBounds(161, 0, 126, 118);
		Image libraryimg = new ImageIcon(this.getClass().getResource("/image/Books-1-icon.png")).getImage();
		Library_lbl.setIcon(new ImageIcon(libraryimg));
		contentPane.add(Library_lbl);
	}

}
