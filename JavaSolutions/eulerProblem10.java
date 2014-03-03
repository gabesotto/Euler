import java.lang.Integer;
public class eulerProblem10{
	public static void main(String[] args){
		System.out.println(generatePrimes(2000000));
		System.out.println(java.lang.Integer.MAX_VALUE);
	}

		//sums all primes up to max.
	private static long generatePrimes(int max){
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

		long [] primes = new long [numOfPrimes];
		int index = 0;
		for(int i = 2; i< max; i++){
			if(!isComposite[i]){
				primes[index++] = i;
			}
		}
		long sum = 0;
		for (int i = 0; i < numOfPrimes; i++){
			if(i < 100){
			System.out.println(primes[i]);}
			sum += primes[i];
		}

		return sum;
	}
}