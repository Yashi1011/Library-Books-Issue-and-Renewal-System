package library;

//Student page class.

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.RowFilter;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Student_page extends JFrame {

	private static final long serialVersionUID = 6358545763856087625L;
	private JPanel contentPane;
	private JTable table;
	private JTextField SearchText;
	private TableModel model;
	private TableRowSorter sorter;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_page frame = new Student_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//@throws IOException.
	
	//Funtion that places all the data which is stored in ArrayList of class Books in each row.
	public void showBooks() throws IOException {
		Books b = new Books();
		ArrayList<Books> list = b.getdata();
		Object[] row = new Object[7];
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getid();
			row[1]=list.get(i).gettitle();
			row[2]=list.get(i).getlanguage();
			row[3]=list.get(i).getauthor();
			row[4]=list.get(i).getpublished_year();
			row[5]=list.get(i).getcopies();
			row[6]=list.get(i).getavailable_copies();
			model.addRow(row);
			
		}
	}
	
	//Create the frame.
	
	public Student_page() throws IOException {
		
		setTitle("Books List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setResizable(false);

		model = new DefaultTableModel();
		sorter = new TableRowSorter<>(model);
		table = new JTable(model);
		table.setBounds(25, 51, 479, 367);
		table.setAutoCreateRowSorter(true);
	    table.setRowSorter(sorter);
		contentPane.add(table);
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		String[] columnName = {"Id","Title","Language","Author","Published_year","Copies","Available Copies"};
		model.setColumnIdentifiers(columnName);
		
		//Function to show the books in the file.
		showBooks();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 70, 882, 319);
		contentPane.add(scrollPane);
		
		//Home button ActionEvent.
		JButton Homebtn = new JButton("Home");
		Homebtn.setBackground(new Color(255, 140, 0));
		Homebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome w = new Welcome();
				w.setVisible(true);
				dispose();
			}
		});
		Homebtn.setBounds(392, 405, 115, 29);
		contentPane.add(Homebtn);
		
		SearchText = new JTextField();
		SearchText.setBounds(454, 26, 200, 26);
		contentPane.add(SearchText);
		SearchText.setBackground(Color.WHITE);
		SearchText.setColumns(20);
		
		JLabel Searchlbl = new JLabel("Search");
		Searchlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Searchlbl.setBounds(306, 20, 90, 38);
		contentPane.add(Searchlbl);
		
		//Searching option.
		SearchText.getDocument().addDocumentListener(new DocumentListener() {
	         @Override
	         public void insertUpdate(DocumentEvent e) {
	            search(SearchText.getText());
	         }
	         @Override
	         public void removeUpdate(DocumentEvent e) {
	            search(SearchText.getText());
	         }
	         @Override
	         public void changedUpdate(DocumentEvent e) {
	            search(SearchText.getText());
	         }
	         public void search(String str) {
	            if (str.length() == 0) {
	               sorter.setRowFilter(null);
	            } else {
	               sorter.setRowFilter(RowFilter.regexFilter(str));
	            }
	         }
	      });
		
	}
}
