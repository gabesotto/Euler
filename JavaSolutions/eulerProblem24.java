
public class eulerProblem24{
	public static int counter = 1;
	public static void main(String[] args){
		//generate array of all permuatations of 0,1,2,3,4,5,6,7,8,9 no repeats
		//int[] permuatations = new int[3628800];
		generatePermutations("0123456789");
	}

	public static void generatePermutations(String s){
		boolean[] used = new boolean[s.length()];
		for(int i = 0; i < used.length; i++){
			used[i] = false;
		}

		permute(0, "", used, s);
		

	}

	//helper function to recurse
	public static void permute(int level, String permuted, boolean used[], String original){
		int length = original.length();

		//Base Case, if level = length we are done.
		if(length == level){ 
			System.out.println(counter + " " + permuted);
			if(counter == 1000000){
				System.out.println(permuted);
				System.exit(0);
			}
			counter++;
		//else recurse
		}else{
			for (int i = 0; i < length; i++) {
               	if (!used[i]) {
                   	used[i] = true;
                   	permute(level + 1, permuted + original.charAt(i), used, original);
                   	used[i] = false;
               	}
           	}
		}
	}
}