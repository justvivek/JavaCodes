package MathProblems;

public class PrimeFactors {
	static int primeFactors(int num){
		int nof = 0;
		while(num%2 == 0) {
			nof++;
			System.out.print(2+ " ");
			num =num/2;
		}
		for(int i=3; i<=Math.sqrt(num); i += 2) {
			while(num%i ==0) {
				nof++;
				System.out.print(i+ " ");
				num =num/i;
			}
		}
		if(num>2) {
			nof++;
			System.out.print(num+ " ");
		}
		return nof;
	}
	public static void main(String[] args) {
		int n = 225;
		int factors = primeFactors(n);
		System.out.println("\nTotal factors are: "+ factors);
	}
}
