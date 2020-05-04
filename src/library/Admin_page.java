package library;

//Admin Page class.

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Admin_page extends JFrame {

	private JPanel contentPane;
	private JTextField idtext;
	private JTextField titletext;
	private JTextField authortext;
	private JTextField copiestext;
	private JTextField yeartext;
	private JTextField langtext;
	private JPanel addbookpnl;
	private JPanel issuebookpnl;
	private JPanel returnbookpnl;
	
	//Main.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_page frame = new Admin_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the frame.
	public Admin_page() {
		
		setTitle("Hello Admin!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 490);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton logout = new JButton("Logout");
		logout.setBackground(new Color(255, 222, 173));
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure?", "Logout!!",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					Admin_login adminlogin = new Admin_login();
					adminlogin.setVisible(true);
					dispose();
				}
			}
		});
		logout.setBounds(742, 31, 115, 29);
		contentPane.add(logout);
		
		//Seperate panels for add, issue and return books.
		
		addbookpnl = new JPanel();
		addbookpnl.setBackground(Color.WHITE);
		addbookpnl.setBounds(36, 104, 821, 300);
		addbookpnl.setLayout(null);
		addbookpnl.setVisible(false);
		contentPane.add(addbookpnl);
		
		issuebookpnl = new JPanel();
		issuebookpnl.setBackground(Color.WHITE);
		issuebookpnl.setBounds(36, 104, 821, 300);
		issuebookpnl.setLayout(null);
		issuebookpnl.setVisible(false);
		contentPane.add(issuebookpnl);
		
		returnbookpnl = new JPanel();
		returnbookpnl.setBackground(Color.WHITE);
		returnbookpnl.setBounds(36, 104, 821, 300);
		returnbookpnl.setLayout(null);
		returnbookpnl.setVisible(false);
		contentPane.add(returnbookpnl);
		
		JButton addBook = new JButton("Add Book");
		addBook.setBackground(new Color(255, 222, 173));
		addBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				issuebookpnl.setVisible(false);
				returnbookpnl.setVisible(false);
				addbookpnl.setVisible(true);
				issuebookpnl.removeAll();
				returnbookpnl.removeAll();
				addBook();
			}
		});
		addBook.setBounds(41, 31, 140, 29);
		contentPane.add(addBook);
		
		
		JButton issueBook = new JButton("Issue Book");
		issueBook.setBackground(new Color(255, 222, 173));
		issueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnbookpnl.setVisible(false);
				addbookpnl.setVisible(false);
				issuebookpnl.setVisible(true);
				addbookpnl.removeAll();
				returnbookpnl.removeAll();
				issueBook();
			}
		});
		issueBook.setBounds(238, 31, 133, 29);
		contentPane.add(issueBook);
		
		JButton returnBook = new JButton("Return Book");
		returnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addbookpnl.setVisible(false);
				issuebookpnl.setVisible(false);
				returnbookpnl.setVisible(true);
				addbookpnl.removeAll();
				issuebookpnl.removeAll();
				returnBook();
			}
		});
		returnBook.setBackground(new Color(255, 222, 173));
		returnBook.setBounds(426, 31, 149, 29);
		contentPane.add(returnBook);
		
	}
	
	//Function to add components on add book panel.
	private void addBook() {
		
		JLabel addbookheading = new JLabel("Enter book details");
		addbookheading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addbookheading.setBounds(309, 16, 172, 20);
		addbookpnl.add(addbookheading);
		
		JLabel title = new JLabel("Title");
		title.setBounds(47, 128, 69, 20);
		addbookpnl.add(title);
		
		JLabel author = new JLabel("Author");
		author.setBounds(47, 180, 69, 20);
		addbookpnl.add(author);
		
		JLabel year = new JLabel("Year of publication ");
		year.setBounds(488, 180, 144, 20);
		addbookpnl.add(year);
		
		JLabel copies = new JLabel("No of copies");
		copies.setBounds(489, 75, 95, 20);
		addbookpnl.add(copies);
		
		JLabel language = new JLabel("Language");
		language.setBounds(489, 128, 69, 20);
		addbookpnl.add(language);
		
		JLabel idlbl = new JLabel("ID");
		idlbl.setBounds(47, 75, 69, 20);
		addbookpnl.add(idlbl);
		
		idtext = new JTextField();
		idtext.setBackground(Color.WHITE);
		idtext.setEditable(false);
		idtext.setBounds(129, 72, 146, 26);
		addbookpnl.add(idtext);
		idtext.setColumns(30);
		
		titletext = new JTextField();
		titletext.setBackground(Color.WHITE);
		titletext.setBounds(131, 125, 146, 26);
		addbookpnl.add(titletext);
		titletext.setColumns(30);
		
		authortext = new JTextField();
		authortext.setBackground(Color.WHITE);
		authortext.setBounds(131, 177, 146, 26);
		addbookpnl.add(authortext);
		authortext.setColumns(30);
		
		copiestext = new JTextField();
		copiestext.setBackground(Color.WHITE);
		copiestext.setBounds(635, 72, 146, 26);
		addbookpnl.add(copiestext);
		copiestext.setColumns(30);
		
		yeartext = new JTextField();
		yeartext.setBackground(Color.WHITE);
		yeartext.setBounds(635, 177, 146, 26);
		addbookpnl.add(yeartext);
		yeartext.setColumns(30);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"eng", "en-CA", "en-US", "en-GB", "spa"}));
		comboBox.setSelectedIndex(1);
		comboBox.setBounds(635, 125, 146, 26);
		addbookpnl.add(comboBox);
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lan = (String)comboBox.getItemAt(comboBox.getSelectedIndex());
				//Checking year.
				if(Integer.parseInt(yeartext.getText())<=999 && Integer.parseInt(yeartext.getText())>=10000) {
				}
				else {
					//Checking if no. of copies are integers.
					if(copiestext.getText().matches("[0-9]*")) {
						Functions_add_issue_return fun = new Functions_add_issue_return();
						try {
							int id_add = fun.addBook(titletext.getText(), lan, authortext.getText(), Integer.parseInt(yeartext.getText()), Integer.parseInt(copiestext.getText()));
							idtext.setText(Integer.toString(id_add));
						} catch (IOException exc) {
							exc.printStackTrace();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Copies are not integers", "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		add.setBackground(new Color(255, 222, 173));
		add.setBounds(353, 255, 115, 29);
		addbookpnl.add(add);
	}
	
	//Function to add components on issue book panel.
	private void issueBook() {
		JLabel issuebookheading = new JLabel("Enter book ID");
		issuebookheading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		issuebookheading.setBounds(331, 16, 172, 20);
		issuebookpnl.add(issuebookheading);
		
		JLabel title = new JLabel("Title");
		title.setBounds(47, 128, 69, 20);
		issuebookpnl.add(title);
		
		JLabel author = new JLabel("Author");
		author.setBounds(47, 180, 69, 20);
		issuebookpnl.add(author);
		
		JLabel year = new JLabel("Year of publication ");
		year.setBounds(488, 180, 144, 20);
		issuebookpnl.add(year);
		
		JLabel copies = new JLabel("Available copies");
		copies.setBounds(489, 75, 131, 20);
		issuebookpnl.add(copies);
		
		JLabel language = new JLabel("Language");
		language.setBounds(489, 128, 69, 20);
		issuebookpnl.add(language);
		
		JLabel idlbl = new JLabel("ID");
		idlbl.setBounds(47, 75, 69, 20);
		issuebookpnl.add(idlbl);
		
		idtext = new JTextField();
		idtext.setBackground(Color.WHITE);
		idtext.setBounds(129, 72, 146, 26);
		issuebookpnl.add(idtext);
		idtext.setColumns(30);
		
		titletext = new JTextField();
		titletext.setEditable(false);
		titletext.setBackground(Color.WHITE);
		titletext.setBounds(131, 125, 251, 26);
		issuebookpnl.add(titletext);
		titletext.setColumns(30);
		
		authortext = new JTextField();
		authortext.setEditable(false);
		authortext.setBackground(Color.WHITE);
		authortext.setBounds(131, 177, 251, 26);
		issuebookpnl.add(authortext);
		authortext.setColumns(30);
		
		copiestext = new JTextField();
		copiestext.setEditable(false);
		copiestext.setBackground(Color.WHITE);
		copiestext.setBounds(635, 72, 146, 26);
		issuebookpnl.add(copiestext);
		copiestext.setColumns(30);
		
		yeartext = new JTextField();
		yeartext.setEditable(false);
		yeartext.setBackground(Color.WHITE);
		yeartext.setBounds(635, 177, 146, 26);
		issuebookpnl.add(yeartext);
		yeartext.setColumns(30);
		
		langtext = new JTextField();
		langtext.setBackground(Color.WHITE);
		langtext.setEditable(false);
		langtext.setBounds(635, 125, 146, 26);
		issuebookpnl.add(langtext);
		langtext.setColumns(10);
		
		JButton issue = new JButton("Issue");
		issue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Functions_add_issue_return fun = new Functions_add_issue_return();
				try {
					fun.issue(Integer.parseInt(idtext.getText()));
					JOptionPane.showMessageDialog(null, titletext.getText()+" is issued", "Issued", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception exc) {
					JOptionPane.showMessageDialog(null, exc, "ERROR", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		issue.setEnabled(false);
		issue.setBackground(new Color(255, 222, 173));
		issue.setBounds(427, 240, 157, 29);
		issuebookpnl.add(issue);
		
		JButton check = new JButton("Check availability");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Books b = new Books();
				Books book;
				ArrayList<Books> list = new ArrayList<Books>();
				try {
					list = b.getdata();
					if(idtext.getText().matches("[0-9]*")){
						int id = Integer.parseInt(idtext.getText());
						if(id>=1 && id<=list.size()) {
							book = list.get(id-1);
							titletext.setText(book.gettitle());
							yeartext.setText(Integer.toString(book.getpublished_year()));
							copiestext.setText(Integer.toString(book.getavailable_copies()));
							langtext.setText(book.getlanguage());
							authortext.setText(book.getauthor());
							if(book.getavailable_copies()>0) {
								issue.setEnabled(true);
							}
							else {
								issue.setEnabled(false);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Book doesn't exists!", "ERROR", JOptionPane.WARNING_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Enter integer", "ERROR", JOptionPane.ERROR_MESSAGE);
						idtext.setText("");
					}
				}
				catch(Exception exc) {
					JOptionPane.showMessageDialog(null, exc, "ERROR", JOptionPane.WARNING_MESSAGE);
					exc.printStackTrace();
				}
			}
		});
		check.setBounds(210, 240, 172, 29);
		check.setBackground(new Color(255, 222, 173));
		issuebookpnl.add(check);
	}
	
	//Function to add components on return book panel.
	private void returnBook() {
		JLabel issuebookheading = new JLabel("Enter book ID");
		issuebookheading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		issuebookheading.setBounds(331, 16, 172, 20);
		returnbookpnl.add(issuebookheading);
		
		JLabel title = new JLabel("Title");
		title.setBounds(47, 128, 69, 20);
		returnbookpnl.add(title);
		
		JLabel author = new JLabel("Author");
		author.setBounds(47, 180, 69, 20);
		returnbookpnl.add(author);
		
		JLabel year = new JLabel("Year of publication ");
		year.setBounds(488, 180, 144, 20);
		returnbookpnl.add(year);
		
		JLabel copies = new JLabel("Issued copies");
		copies.setBounds(489, 75, 131, 20);
		returnbookpnl.add(copies);
		
		JLabel language = new JLabel("Language");
		language.setBounds(489, 128, 69, 20);
		returnbookpnl.add(language);
		
		JLabel idlbl = new JLabel("ID");
		idlbl.setBounds(47, 75, 69, 20);
		returnbookpnl.add(idlbl);
		
		idtext = new JTextField();
		idtext.setBackground(Color.WHITE);
		idtext.setBounds(129, 72, 146, 26);
		returnbookpnl.add(idtext);
		idtext.setColumns(30);
		
		titletext = new JTextField();
		titletext.setEditable(false);
		titletext.setBackground(Color.WHITE);
		titletext.setBounds(131, 125, 251, 26);
		returnbookpnl.add(titletext);
		titletext.setColumns(30);
		
		authortext = new JTextField();
		authortext.setEditable(false);
		authortext.setBackground(Color.WHITE);
		authortext.setBounds(131, 177, 251, 26);
		returnbookpnl.add(authortext);
		authortext.setColumns(30);
		
		copiestext = new JTextField();
		copiestext.setEditable(false);
		copiestext.setBackground(Color.WHITE);
		copiestext.setBounds(635, 72, 146, 26);
		returnbookpnl.add(copiestext);
		copiestext.setColumns(30);
		
		yeartext = new JTextField();
		yeartext.setEditable(false);
		yeartext.setBackground(Color.WHITE);
		yeartext.setBounds(635, 177, 146, 26);
		returnbookpnl.add(yeartext);
		yeartext.setColumns(30);
		
		langtext = new JTextField();
		langtext.setBackground(Color.WHITE);
		langtext.setEditable(false);
		langtext.setBounds(635, 125, 146, 26);
		returnbookpnl.add(langtext);
		langtext.setColumns(10);
		
		//Return book button.
		JButton returnbook = new JButton("Return");
		returnbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Functions_add_issue_return fun = new Functions_add_issue_return();
				try {
					fun.returnbook(Integer.parseInt(idtext.getText()));
					JOptionPane.showMessageDialog(null, titletext.getText()+" is retured", "Issued", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception exc) {
					JOptionPane.showMessageDialog(null, exc, "ERROR", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		returnbook.setEnabled(false);
		returnbook.setBackground(new Color(255, 222, 173));
		returnbook.setBounds(427, 241, 115, 29);
		returnbookpnl.add(returnbook);
		
		//Check button.
		JButton check = new JButton("Check");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Books b = new Books();
				Books book;
				ArrayList<Books> list = new ArrayList<Books>();
				try {
					list = b.getdata();
					//ID should be a number only.
					if(idtext.getText().matches("[0-9]*")){
						int id = Integer.parseInt(idtext.getText());
						//Id should not be out of range.
						if(id>=1 && id<=list.size()) {
							book = list.get(id-1);
							titletext.setText(book.gettitle());
							yeartext.setText(Integer.toString(book.getpublished_year()));
							copiestext.setText(Integer.toString(book.getissued_copies()));
							langtext.setText(book.getlanguage());
							authortext.setText(book.getauthor());
							//Activating return book button.
							if(book.getissued_copies()!=0) {
								returnbook.setEnabled(true);
							}
							else {
								returnbook.setEnabled(false);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Book doesn't exists!", "ERROR", JOptionPane.WARNING_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Enter integer", "ERROR", JOptionPane.ERROR_MESSAGE);
						idtext.setText("");
					}
				}
				catch(Exception exc) {
					JOptionPane.showMessageDialog(null, exc, "ERROR", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		check.setBackground(new Color(255, 222, 173));
		check.setBounds(248, 241, 115, 29);
		returnbookpnl.add(check);
	}
}
