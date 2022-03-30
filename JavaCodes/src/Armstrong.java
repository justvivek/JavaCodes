public class Armstrong {
	
	int power(int x, int y) {
		if(y ==0 )
			return 1;
		if(y%2 == 0)
			return power(x, y/2)*power(x, y/2);
		return x*power(x, y/2)*power(x, y/2);
	}
	
	int order(int x) {
		int n=0;
		while(x!= 0) {
			n++;
			x = x/10;
		}
		return n;
	}
	
	boolean isArmstrong(int x) {
		int sum=0, n =x;
		int y = order(x);
		while(n != 0) {
			int temp = n%10;
			sum += power(temp, y);
			n = n/10;
		}
		return sum == x;
	}
	
	public static void main(String[] args) {
		Armstrong obj = new Armstrong();
		System.out.println(obj.isArmstrong(153));
		System.out.println(obj.isArmstrong(1253));
		
	}
}

