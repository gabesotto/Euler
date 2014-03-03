import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;


public class eulerProblem22{
	public static void main(String[] args){
	
	//read in names from file and put into string array.
	String[] names = readFromFile();
	BigInteger sum = BigInteger.ZERO;

    //Remove quotes from each name.
    for(int i = 0; i < names.length; i++){
    	names[i] = names[i].replaceAll("\"","");
    }

    //sort the array. LOL
    java.util.Arrays.sort(names);

  	for(int i = 0; i < names.length; i++){
  		sum = sum.add(new BigInteger(Integer.toString(generateNameScore(names[i], i))));
  	}
  	System.out.println(sum);

	}
	
	public static int generateNameScore(String name, int index){
		int sum = generateAlphValueSum(name);
		int place = index + 1; 
		return sum * place;
	}


	//Sum the value of all the letters. Where a = 1; b = 2; c = 3... ect.
	//String will be all upper case.
	public static int generateAlphValueSum(String name){
		char[] charArray = name.toCharArray();
		int sum = 0;

		//convert each char to ascii
		for(int i = 0; i < charArray.length; i++){
			sum += ((int)charArray[i] - 64);
		}	

		return sum;
	}

	public static String[] readFromFile(){
	File file = new File("eulerProblem22.txt");
	String[] names = null;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); //get line as string
                names = line.split(",");//split by delimiter ,
			 }
            scanner.close();
            return names;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return names;
	}
}