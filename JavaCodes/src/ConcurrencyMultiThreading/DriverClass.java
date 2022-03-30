package ConcurrencyMultiThreading;

public class DriverClass {
	public static void main(String[] args) {
		MyCompany mc = new MyCompany();
		Producer p= new Producer(mc);
		Consumer c = new Consumer(mc);
		p.start();
		c.start();
	}
}
