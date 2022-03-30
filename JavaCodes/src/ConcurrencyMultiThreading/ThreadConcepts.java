package ConcurrencyMultiThreading;

class Mythread1 implements Runnable{
	public void run() {//task of thread
		System.out.println("Mythread1 class implements Runnable and hence need to define run() method of Interface Runnable ");
		int[] nums = {1,2,3,4,5,6};
		for(int num: nums) {
			System.out.println("Mythread1 class run() method printing i value " + num);
			try{
				Thread.sleep(1000);
			}catch (Exception e){}
		}
	}
}

class Mythread2 extends Thread{
	public void run() {//task of thread
		System.out.println("Mythread1 class extends Thread class and we are overriding run() method of class Thread ");
		int[] nums = {6,5,4,3,2,1};
		for(int num: nums) {
			System.out.println("Mythread2 class run() method printing i value " + num);
			try{
				Thread.sleep(1100);
			}catch (Exception e){}
		}
	}
}

public class ThreadConcepts {
	//main is also a thread, for every java program first main thread will start 
	public static void main(String[] args) {
		Mythread1 t1 = new Mythread1();
		Mythread2 t2 = new Mythread2();
		
		System.out.println("Main() method execution starts here");
		//to start Thread t1 we need to pass our thread to Thread class constructor and then Thread class object will start the t1 thread.
		Thread t = new Thread(t1);
		t.start();
		
		//to start Thread t2 we can directly call start method as we are inheriting all methods of Thread class.
		t2.start();
		
		System.out.println("Main() method execution ends here");
	}
}
