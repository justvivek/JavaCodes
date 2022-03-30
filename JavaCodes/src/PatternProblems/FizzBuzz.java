package PatternProblems;

public class FizzBuzz {
	public static void main(String[] args) {
		//Novice Way
		/*
		for(int i=1; i<=100; i++)
		{
			if(i%15 ==0 ) System.out.println("FizzBuzz");
			else if(i%5 ==0 ) System.out.println("Buzz");
			else if(i%3 ==0 ) System.out.println("Fizz");
			else System.out.println(i);
		}
		*/
		
		//A little better Approach
		/*
		for(int i=1; i<=100; i++) {
			String ans ="";
			if(i%3 == 0) ans += "Fizz";
			if(i%5 == 0) ans += "Buzz";
			if(ans == "") {
				System.out.println(i);
			}else
				System.out.println(ans);
		}
		*/
		
		//Best approach Without modulo
		int c3=0;
		int c5=0;
		for(int i=1; i<=100; i++) {
			String ans = "";
			c3++;
			c5++;
			if(c3 == 3) {ans += "Fizz"; c3=0;}
			if(c5 == 5) {ans += "Buzz"; c5=0;}
			if(ans == "") {
				System.out.println(i);
			}else
				System.out.println(ans);
		}
	}
}
