import java.util.Arrays;
import java.util.Scanner;


public class eulerProblem3{
	//Globals
	static boolean[] primes = new boolean[1000000]; //booleans to represent first 1 mil numbers being prime or not.

	//Main
	//Precondition : User supplies a integer input of reasonable size.
	//Postcondition: Output the greatest prime factor.
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to see its greatest prime factor: ");
		long input = scanner.nextLong();
		
		long targetNumber = input;
		for(long i = 2; i*i <= targetNumber; i++){
			while(PrimeFactor(targetNumber,i)){
				targetNumber /= i;
			}
		}
		
		System.out.println(targetNumber);

		long answer = targetNumber;
		System.out.println("Greatest Prime Factor of " + input + " is " + answer + ".");
	}


	//Functions!

	public static boolean PrimeFactor(long number, long i)
	{
    	return number % i == 0;
	}
}