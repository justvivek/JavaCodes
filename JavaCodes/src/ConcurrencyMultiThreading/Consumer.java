package ConcurrencyMultiThreading;

public class Consumer extends Thread{
	MyCompany c;
	
	public Consumer(MyCompany c) {
		this.c = c;
	}
	public void run() {
		while(true) {
			this.c.consume_item();
			try {
				Thread.sleep(2000);
			}catch(Exception e) {}
		}
	}
}
