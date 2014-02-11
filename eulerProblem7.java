import java.util.Scanner;
public class eulerProblem7{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number n > 0, to see the nth prime:  ");
		int input = scanner.nextInt();
		int result = generatePrimes(110000, input);
		System.out.println("The " + input+"th prime is " + result);

	}

	//generate the nth prime. index[1]
	private static int generatePrimes(int max, int n){
		boolean[] isComposite = new boolean[max+1];
		for(int i = 2; i*i <= max; i++){
			for(int j = i; i* j <= max; j++){
				isComposite[i*j] = true;
			}
		}

		int numOfPrimes = 0;
		for(int i = 2; i <= max; i++){
			if(!isComposite[i]){
				numOfPrimes++;
			}
		}

		int [] primes = new int [numOfPrimes];
		int index = 0;
		for(int i = 2; i< max; i++){
			if(!isComposite[i]){
				primes[index++] = i;
			}
		}
		return primes[n-1];
	}
}
