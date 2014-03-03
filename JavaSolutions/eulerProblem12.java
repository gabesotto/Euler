import java.text.DecimalFormat;
public class eulerProblem12{
	public static void main(String[] args){
		final long startTime = System.currentTimeMillis();
		DecimalFormat formatter = new DecimalFormat("##0.0######");
		int i = 1;
		int[] primes = generatePrimes(46337);
		System.out.println(primes[0]);
		
		while(true){
			double triNum = generateTriangleNum(i);
			int divisors = numOfDivisors(triNum, primes, primes.length);
			//System.out.println("Tri-number " + triNum + " has " + divisors + " divisors");
			if(divisors >= 500){
				System.out.println("The first tri-number to have over 500 divisors is: ");
				System.out.println(formatter.format(triNum));
				System.out.println("with " + divisors + " divisors.");
				break;
			}
			i++;
		}
		final long endTime = System.currentTimeMillis();

System.out.println("Total execution time: " + (endTime - startTime) );
	}

	public static double generateTriangleNum(int n){
		double num = (double)n;
		return ((num/2)*(n+1));
	}

	//generate all primes < max
	private static int[] generatePrimes(int max){
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
		return primes;
	}

	public static int numOfDivisors(double n, int[] primes, int numOfPrimes){
		int numOfDivisors = 1;
		double target = n;
		int timesDivided = 0;
		//loop through each prime
			//divide as many times as possible (evenly divisible)
		int i = 0;
		while(target != 1){
			while(target % primes[i] == 0){
				//System.out.println("Target = " + target + " about to divide by " + primes[i]);
				target = target / primes[i];
				timesDivided++;
				//System.out.println("times divided = " + timesDivided);
			}
			i++;
			numOfDivisors *= (timesDivided+1);
			timesDivided = 0;
		}
		return numOfDivisors;
	}
}