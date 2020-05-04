package library;

//All the necessary functions are written in this class.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Functions_add_issue_return {
	
	//Function to check if book already exists or not.
	private boolean check(ArrayList<Books> b,String title) {
		boolean x = true;
		for(int i = 0;i<b.size();i++) {
			Books book = b.get(i);
			if(title.trim().equalsIgnoreCase(book.gettitle())) {
				x = false;
				return x;
			}
		}
		return x;
	}
	
	//Function to add book to the file.
	public int addBook(String title, String language,String author,int published_year,int copies) throws IOException {
		Books b = new Books();
		ArrayList<Books> list = new ArrayList<Books>();
		try {
			list = b.getdata();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		if(check(list,title)) {
			BufferedWriter bw = null;
			FileWriter fw = null;
	        PrintWriter pw = null;
			try{
				fw = new FileWriter("book.csv", true); 
				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw);
				pw.println((list.size()+1)+"/"+title.trim()+"/"+language+"/"+author+"/"+published_year+"/"+copies+"/"+copies+"/0");
				JOptionPane.showMessageDialog(null, "Book "+title+" added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception exc) {
				JOptionPane.showMessageDialog(null, exc, "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			finally {
				bw.close();
				fw.close();
				pw.close();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Book already exists", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		return list.size()+1;
	}
	
	//Function to issue a book.
	public void issue(int id) throws IOException{
		FileWriter writer = null;
		try{
			Books b = new Books();
			ArrayList<Books> list = new ArrayList<Books>();
			list = b.getdata();
			Books book = list.get(id-1);
	        if(list.get(id-1).getavailable_copies()>0) {
	        	list.get(id-1).issued_copies+=1;
	        	list.get(id-1).available_copies-=1;
	        }
	        else {
	        	JOptionPane.showMessageDialog(null, "Copies are not available", "Warning", JOptionPane.WARNING_MESSAGE);
	        }
	        writer = new FileWriter("book.csv");
	        String s = "Id/Title/Language/Author/Published_year/Copies/Available Copies/Issues copies\r\n";
	        writer.write(s);
	        for(int i = 0;i<list.size();i++) {
	        	book = list.get(i);
	        	s = Integer.toString(book.getid())+"/"+book.gettitle()+"/"+book.getlanguage()+"/"+book.getauthor()+"/"+book.getpublished_year()+"/"+book.getcopies()+"/"+book.available_copies+"/"+book.getissued_copies()+"\r\n";
	        	writer.write(s);
	        }
	     }
	     catch (IOException ioe){
	         ioe.printStackTrace();
	     }
		finally {
			writer.close();
		}
	}

	//Function to issue a book.
	public void returnbook(int id) throws IOException{
		try{
			Books b = new Books();
			ArrayList<Books> list = new ArrayList<Books>();
			list = b.getdata();
			Books book = list.get(id-1);
	        if(list.get(id-1).getissued_copies()>0) {
	        	list.get(id-1).issued_copies-=1;
	        	list.get(id-1).available_copies+=1;
	        }
	        else {
	        	JOptionPane.showMessageDialog(null, "No issued books!!", "Warning", JOptionPane.WARNING_MESSAGE);
	        }
	        FileWriter writer = new FileWriter("book.csv");
	        String s = "Id/Title/Language/Author/Published_year/Copies/Available Copies/Issues copies\r\n";
	        writer.write(s);
	        for(int i = 0;i<list.size();i++) {
	        	book = list.get(i);
	        	s = Integer.toString(book.getid())+"/"+book.gettitle()+"/"+book.getlanguage()+"/"+book.getauthor()+"/"+book.getpublished_year()+"/"+book.getcopies()+"/"+book.available_copies+"/"+book.getissued_copies()+"\r\n";
	        	writer.write(s);
	        }
	        writer.close();
	     }
	     catch (IOException ioe){
	         ioe.printStackTrace();
	     }
	}
}
