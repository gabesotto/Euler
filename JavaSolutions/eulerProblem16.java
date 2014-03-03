import java.math.BigInteger;
public class eulerProblem16{
	public static void main(String[] args){
		//calculate 2^1000 change to char array
		BigInteger two = new BigInteger("2");
		char[] digits = two.pow(1000).toString().toCharArray();
		int[] digitsInt = new int[digits.length];
		
		//loop through, and cast to int array.
		for(int i = 0; i < digits.length; i++){
			digitsInt[i] = Character.digit(digits[i], 10);
		}

		//loop through ints and sum.
		int sum = 0;
		for(int i = 0; i < digitsInt.length; i++){
			sum += digitsInt[i];
		}

		System.out.println("Sum of all the digits of 2^1000 = " + sum);
	}
}
