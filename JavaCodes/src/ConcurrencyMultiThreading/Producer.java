package ConcurrencyMultiThreading;

public class Producer extends Thread{
	MyCompany c;
	public Producer(MyCompany c) {
		this.c = c;
	}
	
	public void run() {
		int item =1;
		while(true) {
			this.c.produce_item(item);
			item++;
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
		}
	}
}
