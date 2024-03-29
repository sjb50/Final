package GUI;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Component;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.border.EtchedBorder;

import Books.*;
import Person.*;
import Person.*;
import helpers.*;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
//import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.Panel;

public class HomeScreen extends JFrame {
	String memberCollectionFile = "memberCollection.txt";
	PersonCollection members = new PersonCollection();
	String BookCollectionFile = "books.txt";
	BookCollection books = new BookCollection();
	private JPanel contentPane;
	private JPanel test;
	private JTextField search_textField;
	private JTextField textField;

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public HomeScreen() throws IOException {
		loadBookFile();
		loadPeopleFile();
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
		Image img = new ImageIcon(this.getClass().getResource("/image/image.png")).getImage();
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

		search_textField = new JTextField();
		search_textField.setBounds(237, 169, 293, 32);
		contentPane.add(search_textField);
		search_textField.setColumns(10);

		JButton logout_btn = new JButton("");
		logout_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
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

		bookCollection_btn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bookCollection_btn.setBounds(170, 11, 176, 33);
		panel.add(bookCollection_btn);

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

		JButton btnSearch = new JButton("Search ");
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSearch.setBounds(540, 169, 91, 32);
		contentPane.add(btnSearch);

		String[] sortMethod = { "Author", "Title", "Member Id" };
		JComboBox sort_comboBox = new JComboBox(sortMethod);
		sort_comboBox.setFont(new Font("Arial", Font.BOLD, 15));
		sort_comboBox.setForeground(Color.BLACK);
		sort_comboBox.setBackground(Color.WHITE);
		sort_comboBox.setBounds(132, 169, 105, 32);
		contentPane.add(sort_comboBox);

		test = new JPanel();
		// test.setSize(new Dimension(700, 700));
		test.setBackground(Color.black);
		JScrollPane scrollPane = new JScrollPane(test, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		test.setLayout(new BoxLayout(test, BoxLayout.Y_AXIS));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(36, 215, 669, 405);
		contentPane.add(scrollPane);

		bookCollection_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadBookFile();
				loadPeopleFile();
				test.removeAll();
				test.setVisible(false);
				for (int count = 0; count < books.getManyBooks(); count++) {
					JPanel bookContainer = new JPanel();
					bookContainer.setMaximumSize(new Dimension(640, 150));
					bookContainer.setMinimumSize(new Dimension(639, 149));
					bookContainer.setBackground(Color.lightGray);
					JTextArea match = new JTextArea(books.getBooks()[count].toString());
					Image img1 = new ImageIcon(this.getClass().getResource(books.getBooks()[count].getPicture()))
							.getImage();
					Image newimg = img1.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
					match.setBackground(Color.LIGHT_GRAY);
					match.setMaximumSize(new Dimension(640, 150));
					match.setMinimumSize(new Dimension(639, 149));

					JLabel photo = new JLabel();
					photo.setMaximumSize(new Dimension(50, 50));
					photo.setMinimumSize(new Dimension(10, 10));
					photo.setIcon(new ImageIcon(newimg));
					photo.setBackground(Color.lightGray);

					JPanel breaker = new JPanel();
					breaker.setBackground(Color.BLACK);
					breaker.setMaximumSize(new Dimension(640, 10));
					bookContainer.add(match);
					bookContainer.add(photo);

					if (!(books.getBooks()[count].isCheckOut())) {
						JButton checkout = new JButton("Checkout");
						checkout.setActionCommand(Integer.toString(count));
						checkout.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println(e.getActionCommand());
								JPanel checkOutPage = new JPanel();
								checkOutPage.setSize(new Dimension(50, 50));
								checkOutPage.setVisible(true);
								String input="0";
								Member checkerOut=null;
								try {
								input = JOptionPane.showInputDialog(contentPane,
										books.getBooks()[new Integer(e.getActionCommand())].toString()
												+ "\nEnter Member ID");
								checkerOut = (Member) members.searchByMemberId(new Integer(input));
								}catch (Exception ex) {
									input="0";
								}
								
								if (checkerOut != null) {

									checkerOut.checkOut(books.getBooks()[new Integer(e.getActionCommand())]);
									//bookContainer.remove(comp);

									System.out.println(checkerOut);
									saveBookFile();
									savePeopleFile();

								}
								saveBookFile();
							}

						});
						bookContainer.add(checkout);
					}
					test.add(bookContainer);
					test.add(breaker);

				}
				test.setVisible(true);
			}

		});

		memberList_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPeopleFile();
				test.removeAll();
				test.setVisible(false);
				for (int count = 0; count < members.getManyMembers(); count++) {
					Member person = (Member) members.getPeople()[count];
					JTextArea match = new JTextArea(person.toString());
					match.setEditable(false);
					match.setBackground(Color.lightGray);

					match.setMinimumSize(new Dimension(639, 149));

					JPanel breaker = new JPanel();
					breaker.setBackground(Color.BLACK);
					breaker.setMaximumSize(new Dimension(640, 10));

					JButton returnBtn = new JButton("Return");
					returnBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					returnBtn.setBounds(540, 10, 91, 32);
					returnBtn.setActionCommand(Integer.toString(count));
					returnBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int index = Integer.parseInt(e.getActionCommand());
							match.setVisible(false);
							Member returner = (Member) members.getPeople()[index];
							System.out.println(returner.getCheckedOutBooks().getNumCheckedOut());
							Book[] listOfBooks = returner.getCheckedOutBooks().popToArray();
							JComboBox bookToReturn = new JComboBox(listOfBooks);
							Book returnedBook = (Book) bookToReturn.getSelectedItem();

							JPanel menu = new JPanel();
							JButton comfirmReturn = new JButton("Confirm");
							comfirmReturn.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									Book returnedBook = (Book) bookToReturn.getSelectedItem();
									returner.returnBook(books, returnedBook);
									saveBookFile();
									savePeopleFile();
									match.setVisible(false);
									match.setVisible(true);
								}
							});

							menu.setBounds(156, 15, 50, 100);
							menu.add(bookToReturn);
							menu.add(comfirmReturn);
							menu.setBackground(Color.WHITE);
							menu.setBounds(156, 15, 269, 105);
							match.add(menu);
							match.setVisible(true);
						}
					});

					JButton payBtn = new JButton("Pay Fee");
					payBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					payBtn.setBounds(440, 10, 91, 32);
					payBtn.setActionCommand(Integer.toString(count));
					payBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
							int index = Integer.parseInt(e.getActionCommand());
							Member payer = (Member) members.getPeople()[index];
							String input = JOptionPane.showInputDialog(contentPane,"\nHow much would you like to pay?");
							double  payment= Double.parseDouble(input);
							payer.payFee(payment);
							savePeopleFile();
							}
							catch (Exception ex) {
								
							}
						}
					});

					JButton lostBtn = new JButton("Lost Book");
					lostBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					lostBtn.setBounds(440, 50, 192, 32);
					lostBtn.setActionCommand(Integer.toString(count));
					lostBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int index = Integer.parseInt(e.getActionCommand());
							match.setVisible(false);
							Member returner = (Member) members.getPeople()[index];
							System.out.println(returner.getCheckedOutBooks().getNumCheckedOut());
							Book[] listOfBooks = returner.getCheckedOutBooks().popToArray();
							JComboBox bookToReturn = new JComboBox(listOfBooks);
							Book returnedBook = (Book) bookToReturn.getSelectedItem();

							JPanel menu = new JPanel();
							JButton comfirmCharge = new JButton("Confirm");
							menu.add(comfirmCharge);
							match.add(menu);
							menu.setBounds(156, 15, 50, 100);
							menu.add(bookToReturn);
							menu.add(comfirmCharge);
							menu.setBackground(Color.RED);
							menu.setBounds(156, 15, 269, 105);
							match.setVisible(true);
							comfirmCharge.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									Member returner = (Member) members.getPeople()[index];
									System.out.println(returner);
									Book lostBook = (Book) bookToReturn.getSelectedItem();
									returner.charge(books, lostBook);

									saveBookFile();
									savePeopleFile();

									match.add(menu);
									match.setVisible(true);
								}

							});
						}
					});
					if (!(person.getCheckedOutBooks().getNumCheckedOut()==0)){
					match.add(lostBtn);
					match.add(returnBtn);
		}
					match.add(payBtn);

					test.add(match);
					test.add(breaker);
				}
				test.setVisible(true);
			}

		});

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				test.removeAll();
				test.setVisible(false);
				if (search_textField.equals(null)) {
					System.out.println(" please select an option:");
				}
				String s = (String) sort_comboBox.getSelectedItem();
				loadBookFile();
				loadPeopleFile();
				Book found;
				switch (s) {
				case "Author":{
					Sorting.bookMergeSortByAuthor(books.getBooks(), 0, books.getManyBooks());
					
					found = books.SearchByAuthor(search_textField.getText());
					JPanel breaker = new JPanel();
					breaker.setBackground(Color.BLACK);
					breaker.setMaximumSize(new Dimension(640, 10));
					//for (int count = 0; count < books.getManyBooks(); count++) {
						JTextArea match1 = new JTextArea("");
						try {
						match1 = new JTextArea(found.toString());
						
						Image img1 = new ImageIcon(this.getClass().getResource(found.getPicture()))
								.getImage();
						Image newimg = img1.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
						JLabel photo = new JLabel();
						
						photo.setMaximumSize(new Dimension(50, 50));
						photo.setMinimumSize(new Dimension(10, 10));
						photo.setBackground(Color.LIGHT_GRAY);
						photo.setIcon(new ImageIcon(newimg));
						photo.setBounds(230, 15, 120, 120);
						
						test.add(photo);
						
						match1.setBackground(Color.LIGHT_GRAY);
						match1.setMaximumSize(new Dimension(640, 150));
						match1.setMinimumSize(new Dimension(639, 149));

						
						match1.add(photo);
						test.add(match1);
						}
						catch (Exception e) {
							
						}
						if (found!=null && !(found.isCheckOut())) {
							System.out.println("Here");
							JButton checkout = new JButton("Checkout");
							checkout.setBounds(400,50, 100,50);
							test.add(checkout);
							checkout.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									System.out.println(e.getActionCommand());
									JPanel checkOutPage = new JPanel();
									checkOutPage.setSize(new Dimension(50, 50));
									checkOutPage.setVisible(true);
									
									String input = JOptionPane.showInputDialog(contentPane,
											found.toString()
													+ "\nEnter Member ID");
									Member checkerOut = (Member) members.searchByMemberId(new Integer(input));
									if (checkerOut != null) {

										checkerOut.checkOut(found);

										System.out.println(checkerOut);
										savePeopleFile();

									}
									saveBookFile();
								}

							});
							match1.add(checkout);
						}
						test.add(breaker);
						test.setVisible(true);
					//}

				}
					break;
				case "Title":{
					Sorting.bookMergeSortByTitle(books.getBooks(), 0, books.getManyBooks());
					found = books.SearchByTitle(search_textField.getText());
					JPanel breaker = new JPanel();
					breaker.setBackground(Color.BLACK);
					breaker.setMaximumSize(new Dimension(640, 10));
					JTextArea match1 = new JTextArea("");
					try {
					match1 = new JTextArea(found.toString());
					
					Image img1 = new ImageIcon(this.getClass().getResource(found.getPicture()))
							.getImage();
					Image newimg = img1.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
					JLabel photo = new JLabel();
					photo.setBounds(230, 15, 120, 120);
					
					photo.setBackground(Color.blue);
					photo.setIcon(new ImageIcon(newimg));
					match1.setBackground(Color.lightGray);
					match1.setMaximumSize(new Dimension(640, 150));
					match1.setMinimumSize(new Dimension(639, 149));

					
					match1.add(photo);
					test.add(match1);
					}
					catch (Exception e) {
						
					}
					if (found!=null && !(found.isCheckOut())) {
						System.out.println("Here");
						JButton checkout = new JButton("Checkout");
						checkout.setBounds(400,50, 100,50);
						test.add(checkout);
						checkout.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println(e.getActionCommand());
								JPanel checkOutPage = new JPanel();
								checkOutPage.setSize(new Dimension(50, 50));
								checkOutPage.setVisible(true);
								String input = JOptionPane.showInputDialog(contentPane,
										found.toString()
												+ "\nEnter Member ID");
								Member checkerOut = (Member) members.searchByMemberId(new Integer(input));
								if (checkerOut != null) {

									checkerOut.checkOut(found);

									System.out.println(checkerOut);
									savePeopleFile();

								}
								saveBookFile();
							}

						});
						match1.add(checkout);
					}
					test.add(breaker);
					test.setVisible(true);
				//}

			}		
					break;
				case "Member Id":
					int myint = 0;
					// Sorting.memberSortByMemberId(member.getPeople(),0,member.getManyMembers());
					try {
						myint = Integer.parseInt(search_textField.getText());
						System.out.println(myint);


					Member person = (Member) members.searchByMemberId(myint);
					JTextArea match3 = new JTextArea(person.toString());
					
					match3.setBackground(Color.lightGray);
					match3.setMaximumSize(new Dimension(640, 150));
					match3.setMinimumSize(new Dimension(639, 149));

					JPanel breaker3 = new JPanel();
					breaker3.setBackground(Color.BLACK);
					breaker3.setMaximumSize(new Dimension(640, 10));

					test.add(match3);
					test.add(breaker3);
					JButton returnBtn = new JButton("Return");
					returnBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					returnBtn.setBounds(540, 10, 91, 32);
					returnBtn.setActionCommand(Integer.toString(person.getId()));
					JButton lostBtn = new JButton("Lost Book");
					lostBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					lostBtn.setBounds(440, 50, 192, 32);
					lostBtn.setActionCommand(Integer.toString(person.getId()));
					if (person.getCheckedOutBooks().getNumCheckedOut()!=0)
					match3.add(lostBtn);
					JButton payBtn = new JButton("Pay Fee");
					payBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					payBtn.setBounds(440, 10, 91, 32);
					payBtn.setActionCommand(Integer.toString(person.getId()));
					match3.add(payBtn);
					payBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
							int index = Integer.parseInt(e.getActionCommand());
							Member payer = (Member) members.searchByMemberId(index);
							String input = JOptionPane.showInputDialog(contentPane,"\nHow much would you like to pay?");
							double  payment= Double.parseDouble(input);
							payer.payFee(payment);
							savePeopleFile();
							}
							catch (Exception ex) {	
							}
						}
					});
					lostBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int index = Integer.parseInt(e.getActionCommand());
							match3.setVisible(false);
							Member returner = (Member) members.searchByMemberId(index);
							System.out.println(returner.getCheckedOutBooks().getNumCheckedOut());
							Book[] listOfBooks = returner.getCheckedOutBooks().popToArray();
							JComboBox bookToReturn = new JComboBox(listOfBooks);
							Book returnedBook = (Book) bookToReturn.getSelectedItem();

							JPanel menu = new JPanel();
							JButton comfirmCharge = new JButton("Confirm");
							menu.add(comfirmCharge);
							match3.add(menu);
							menu.setBounds(156, 15, 50, 100);
							
							menu.add(bookToReturn);
							menu.add(comfirmCharge);
							menu.setBackground(Color.RED);
							menu.setBounds(156, 15, 269, 105);
							match3.setVisible(true);
							comfirmCharge.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									System.out.println(returner);
									Book lostBook = (Book) bookToReturn.getSelectedItem();
									returner.charge(books, lostBook);

									saveBookFile();
									savePeopleFile();

									match3.add(menu);
									match3.setVisible(true);
								}
								
							});
							test.setVisible(true);
						}
					});
					if (person.getCheckedOutBooks().getNumCheckedOut()!=0)
					match3.add(returnBtn);
					returnBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int index = Integer.parseInt(e.getActionCommand());
							match3.setVisible(false);
							Member returner = (Member) members.searchByMemberId(index);
							System.out.println(returner.getCheckedOutBooks().getNumCheckedOut());
							Book[] listOfBooks = returner.getCheckedOutBooks().popToArray();
							JComboBox bookToReturn = new JComboBox(returner.getCheckedOutBooks().popToArray());
							Book returnedBook = (Book) bookToReturn.getSelectedItem();

							JPanel menu = new JPanel();
							JButton comfirmReturn = new JButton("Confirm");
							menu.add(bookToReturn);
							menu.add(comfirmReturn);
							comfirmReturn.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									Book returnedBook = (Book) bookToReturn.getSelectedItem();
									returner.returnBook(books, returnedBook);
									saveBookFile();
									savePeopleFile();
									match3.setVisible(false);
									match3.setVisible(true);
								}
							});
							
							menu.setBounds(156, 15, 50, 100);
							menu.add(bookToReturn);
							menu.add(comfirmReturn);
							menu.setBackground(Color.WHITE);
							menu.setBounds(156, 15, 269, 105);
							match3.add(menu);
							match3.setVisible(true);
						}
					});
					} catch (Exception e) {
						System.err.println(e);
					}
					test.setVisible(true);
				}
			}

		});
	}

	/**
	 * @Specifications:
	 * @Param:
	 * @Precondition:
	 * @Postcondition:
	 * @Throws:
	 */
	private void loadMemberFile() {
		// TODO Auto-generated method stub

	}

	/**
	 * @Specifications:
	 * @Param:
	 * @Precondition:
	 * @Postcondition:
	 * @Throws:
	 */

	public void loadPeopleFile() {
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(memberCollectionFile);
			ObjectInputStream in = new ObjectInputStream(file);
			// Method for deserialization of object
			members = (PersonCollection) in.readObject();
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

	public void loadBookFile() {
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(BookCollectionFile);
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

	public void saveBookFile() {
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(BookCollectionFile);
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

	public void savePeopleFile() {
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(memberCollectionFile);
			ObjectOutputStream out = new ObjectOutputStream(file);
			// Method for serialization of object
			out.writeObject(members);
			out.close();
			file.close();
			System.out.println("Object has been serialized");

		}

		catch (IOException ex) {
			System.out.println(ex);
		}

	}
}
