public class eulerProblem23{
	public static void main(String[] args){
		final long startTime = System.currentTimeMillis();
		int[] abundant = generateAbundantNumbers(28123);
		int sum = 0;
		for(int n = 0; n <= 28123; n++){
			double percent = (((double)n/28123) * 100);
			//System.out.println(n);
			if(n % 500 == 0){
				System.out.println("Percent complete: " + percent);
			}
			//System.out.println(n);
			if(!isAbundantSum(n, abundant)){
				sum += n;
			}
		}
		System.out.println("Sum of all the positive integers which cannot be written as the sum of two abundant numbers: " + sum);
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) );
	}

	public static int sumProperDivisors(int n){
		int sum = 0;
		//int sqrt = (int)Math.sqrt(n);
		for(int i = 1; i < n/2 + 1; i++){
			if(n % i == 0){
				sum += i;
			}
		}
		return sum;
	}

	public static boolean isAbundant(int n){
		int sum = sumProperDivisors(n);
		return(sum > n) ? true : false;
	}

	//for small max.
	public static int[] generateAbundantNumbers(int max){
		int index = 0;
		int[] abundantTemp = new int[max];
		int[] abundant;
		
		//loop to max and find all abundant numbers 0(n^2)
		//12 is smallest abundant
		for(int i = 12; i < max + 1; i++){
			if(isAbundant(i)){
				abundantTemp[index++] = i;
			}
		}

		//resize array an return.
		abundant = new int[index];
		for(int i = 0; i < index; i++){
			abundant[i] = abundantTemp[i];
		}
		return abundant;
	}

	private static boolean isAbundantSum(int n, int[] abundant){
		for(int i = 0; i < abundant.length; i++){
			if(abundant[i] > n){
				return false;
			}
			for(int j = i; j < abundant.length; j++){
				if(abundant[i] + abundant[j] == n){
					return true;
				}
			}
		}
		return false;
	}
}