public class eulerProblem4{
	public static void main(String[] args){

		int[] palindromes = new int[1000*1000];
		int index = 0;

		for(int i = 100; i < 1000; i++){
			for(int j = 100; j < 1000; j++){
				if(isPalindromic(i*j)){
					System.out.println("With i = " + i + " and j = " + j + " multiplies to a palindromic of " + (i * j) + " adding to array...");
					palindromes[index] = i*j;
					index++;
				}
			}
		}
		System.out.println("The biggest palindromic of the product of 2 three digit numbers is " + max(palindromes));
	}

	public static boolean isPalindromic(int n){
		String nString = Integer.toString(n);
		String nReverse = reverseString(nString);
		return (nString.equals(nReverse));
	}

	public static String reverseString(String s){
		return new StringBuffer(s).reverse().toString();
	}

	public static int max(int[] n){
		int max = 0;
		for(int i = 0; i < n.length; i++){
			if(n[i] >=  max){
				max = n[i];
			}
		}
		return max;
	}
}