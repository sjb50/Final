package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Books.Book;
import Books.BookCollection;
import Person.Employee;
import Person.PersonCollection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class AddBook extends JFrame implements Serializable {
	String imageFile = "";
	String bookFile = "books.txt";
	BookCollection books = new BookCollection();
	private JPanel contentPane;
	private JTextField textField_AuthorName;
	private JTextField textField_TitleName;
	private JTextField ErrTextField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AddBook() {
		loadFile();
		Book[] array = books.getBooks();
		System.out.println(array[0]);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		JLabel lblAddBook = new JLabel("Add Book");
		lblAddBook.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAddBook.setBounds(10, 0, 188, 55);
		contentPane.add(lblAddBook);

		JLabel Library_lbl = new JLabel("");
		Library_lbl.setBounds(161, 0, 126, 118);
		Image libraryimg = new ImageIcon(this.getClass().getResource("/image/image.png")).getImage();
		Library_lbl.setIcon(new ImageIcon(libraryimg));
		contentPane.add(Library_lbl);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground (Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(40, 299, 146, 109);
		contentPane.add(lblNewLabel_1);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(386, 393, 104, 34);
		contentPane.add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_TitleName.getText().equals("") || textField_AuthorName.getText().equals("")
						|| imageFile.equals("")) {
					ErrTextField.setVisible(true);
					
				} else {
					ErrTextField.setVisible(false);
					Book newBook = new Book(textField_TitleName.getText(), textField_AuthorName.getText(), imageFile);
					books.add(newBook);
					saveFile();
					System.out.println("\n" + newBook);
					setVisible(false);
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
		});

		JLabel displayLbl = new JLabel("");
		displayLbl.setBackground(new Color(102, 153, 51));
		displayLbl.setBounds(40, 239, 146, 34);
		contentPane.add(displayLbl);

		textField_AuthorName = new JTextField();
		textField_AuthorName.setBounds(227, 119, 175, 34);
		contentPane.add(textField_AuthorName);
		textField_AuthorName.setColumns(10);

		textField_TitleName = new JTextField();
		textField_TitleName.setColumns(10);
		textField_TitleName.setBounds(227, 181, 175, 34);
		contentPane.add(textField_TitleName);

		ErrTextField = new JTextField();
		ErrTextField.setBackground(new Color(153, 204, 255));
		ErrTextField.setText("Please complete form");
		ErrTextField.setBounds(227, 320, 182, 26);
		contentPane.add(ErrTextField);
		ErrTextField.setVisible(false);
		ErrTextField.setColumns(10);

		JLabel photolabel = new JLabel("Photo File Name");
		photolabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		photolabel.setBounds(40, 235, 118, 34);
		contentPane.add(photolabel);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(227, 239, 175, 34);
		contentPane.add(textField);

		JButton btnCheckPhoto = new JButton("Choose Photo");
		btnCheckPhoto.setBounds(237, 278, 155, 34);
		contentPane.add(btnCheckPhoto);
		
		btnCheckPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(textField.getText().equals(""))) {
					try {
					Image libraryimg = new ImageIcon(this.getClass().getResource("/image/"+textField.getText())).getImage();
					Image newimg = libraryimg.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
					lblNewLabel_1.setIcon(new ImageIcon(newimg));
					contentPane.add(lblNewLabel_1);
					imageFile="/image/"+textField.getText();
					}
					catch (Exception ex) {
						ErrTextField.setVisible(true);
					}
				
					
					
				}
				
				
			}
		});
	}

		

	public void loadFile() {
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(bookFile);
			ObjectInputStream in = new ObjectInputStream(file);
			// Method for deserialization of object
			books = (BookCollection) in.readObject();
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
			FileOutputStream file = new FileOutputStream(bookFile);
			ObjectOutputStream out = new ObjectOutputStream(file);
			// Method for serialization of object
			out.writeObject(books);
			out.close();
			file.close();
			System.out.println("Object has been serialized");

		}

		catch (IOException ex) {
			System.out.println(ex);
		}

	}
}
