package library;

//Books class to store information about a book or all the books.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Books {
	
	int id,published_year,copies,available_copies,issued_copies;
	String title,language,author;
	
	//Empty constructor.
	Books(){
		
	}
	
	//Overloading the constructor.
	Books(int id, String title, String language,String author,int published_year,int copies,int available_copies,int issued_copies){
		this.id = id;
		this.title = title;
		this.language = language;
		this.copies = copies;
		this.author = author;
		this.published_year = published_year;
		this.available_copies = available_copies;
		this.issued_copies = issued_copies;
	}
	
	public int getid() {
		return id;
	}
	public String gettitle() {
		return title;
	}
	public String getlanguage() {
		return language;
	}
	public int getcopies() {
		return copies;
	}
	public String getauthor() {
		return author;
	}
	public int getpublished_year() {
		return published_year;
	}
	public int getavailable_copies() {
		return available_copies;
	}
	public int getissued_copies() {
		return issued_copies;
	}
	
	//Function to read the book.csv file and store the whole data in the ArrayList.
	public ArrayList<Books> getdata() throws IOException{
		BufferedReader br = null;
		ArrayList<Books> booksList = new ArrayList<Books>();
		try{
			br = new BufferedReader(new FileReader("book.csv"));
			String firstLine = br.readLine().trim();
			String line = br.readLine();
			Books b;
			
			while(line!=null) {
				String[] s = line.split("/");
				b = new Books(Integer.parseInt(s[0]),s[1],s[2],s[3],Integer.parseInt(s[4]),Integer.parseInt(s[5]),Integer.parseInt(s[6]),Integer.parseInt(s[7]));
				booksList.add(b);
				line = br.readLine();
			}
			
		}
		catch(Exception exc) {
			JOptionPane.showMessageDialog(null, exc, "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			try {
				br.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return booksList;
	}
	
}