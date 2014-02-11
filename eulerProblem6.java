public class eulerProblem6{
	public static void main(String[] args){
		long sumOfSquare = 0;
		long squareOfSum = 0;

		for(int i = 1; i <= 100; i++){
			sumOfSquare += (i*i);
		}
		System.out.println("Sum of Square of first 100 natural numbers is " + sumOfSquare);
		for(int j = 1; j <= 100; j++){
			squareOfSum += j;
		}
		squareOfSum = squareOfSum*squareOfSum;
		System.out.println("Square of the sum of the first 100 natural numbers is " + squareOfSum);
		System.out.println("The difference is " + squareOfSum + " - " + sumOfSquare + " = " + (squareOfSum - sumOfSquare));
	}
}