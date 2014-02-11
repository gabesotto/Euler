public class eulerProblem14{
	public static void main(String[] args){
		final long startTime = System.currentTimeMillis();
		int lengthMax = 0;
		int iMax = 0;
		for(int i = 1; i <= 1000000; i++){
			int length = lengthOfSequence(i);
			if(length > lengthMax){
				lengthMax = length;
				iMax = i;
				System.out.println("New max length of " + lengthMax + " with starting number of " + iMax);
			}
		}
		//System.out.println("final Max length of " + lengthMax + " with starting number of " + iMax);
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) );

	}

	public static int lengthOfSequence(int n){
		long number = new Long(n);
		int length = 1;
		//System.out.println(number);
		while(number > 1){ 
			if(number % 2 != 0){
				number = 3*number + 1;	
				length++;
				//System.out.println(number);
			}else{
				number /= 2;
				length++;
				//System.out.println(number);
			}
		}
		return length;
	}	
}