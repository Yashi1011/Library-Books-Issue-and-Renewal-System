package library;

//Class to try Multithreading.
//I created a class Test to run 2 threads.

public class Test implements Runnable{
	
	Welcome w;
	Test(String s){
		System.out.println(s);
	}
	
	public static void main(String args[]) {
		Test t1 = new Test("Thread1");
		Test t2 = new Test("Thread2");
		t1.run();
		t2.run();
	}

	@Override
	public void run() {
		w = new Welcome();
		w.setVisible(true);
	}
}
;