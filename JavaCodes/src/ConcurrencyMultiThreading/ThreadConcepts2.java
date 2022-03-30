package ConcurrencyMultiThreading;

class Mythread3 extends Thread{
	public void run() {
		//task of thread
		System.out.println("\n\nUser defined Thread ");
	}
}
public class ThreadConcepts2 {
	public static void main(String[] args) {
		Mythread3 t3 = new Mythread3();
		System.out.println("Main Starts...");
		
		Thread t = Thread.currentThread();
		String name = t.getName();
		
		System.out.println("Current running Thread name:- "+ name);
		
		try {
			Thread.sleep(3000);
		}catch (Exception e) {}
		
		t.setName("My Main");
		System.out.println("After renaming Current running Thread name:- "+ t.getName());
		t3.start();
		System.out.println("Id of thread "+t.getId());
		System.out.println("Main Ends...");
	}
}
