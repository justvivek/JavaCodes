package ConcurrencyMultiThreading;

public class MyCompany {
	int n;
	//f= false, then it's producer chance to produce item
	//f = true, then it's consumer chance to consume item 
	boolean f = false;
	
	
	//Producing the data for Consumer
	synchronized public void produce_item(int n){
		if(f)
			try{wait();} catch(Exception e) {}
		this.n = n;
		System.out.println("Produced:- "+ this.n);
		f = true;
		notify();
	}
	
	//Consuming the data produced by Producer
	synchronized public int consume_item() {
		if(!f)
			try{wait();} catch(Exception e) {}
		System.out.println("Consumed:- "+ this.n);
		f = false;
		notify();
		return this.n;
	}
}
