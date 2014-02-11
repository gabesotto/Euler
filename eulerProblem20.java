import java.math.BigInteger;
public class eulerProblem20{
	public static void main(String[] args){
		//computer 100 factorial in a bigInt
		BigInteger temp = factorial(100fibonacci s);

		//convert to string
		char[] digits = temp.toString().toCharArray();
		int[] digitsInt = new int[digits.length]; 

		//convert to int array and sum.
		int sum = 0;
		for(int i = 0; i < digits.length; i++){
			digitsInt[i] = Character.digit(digits[i], 10);
			sum += digitsInt[i];
		}
		System.out.println(sum);
	}

	public static BigInteger factorial(int n){
		BigInteger product = new BigInteger("1");
		for(int i = 2; i <= n; i++){
			String intString = Integer.toString(i);
			product = product.multiply(new BigInteger(intString));
		}
		return product;
	}
}