public class eulerProblem5{
	public static void main(String[] args){
		int i = 1;
		while (true){
			if(divisible(i)){
				System.out.println("Smallest positive number that is evenly divisible by all of the numbers from 1 to 20 is " + i);
				System.exit(0);
			}
			i++;
		}
	}

	public static boolean divisible(int n){
		for(int i = 1; i <= 20; i++){
			if(n%i != 0){
				return false;
			}
		}
	return true;
	}
}