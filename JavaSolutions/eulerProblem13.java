import java.math.BigInteger;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class eulerProblem13{
	public static void main(String[] args){
		//Take 50 digits ints from file and put into BigInt array.
		BigInteger numbers[] = new BigInteger[100];
		try{
			File file = new File("eulerProblem13.txt");
			Scanner scanner = new Scanner(file);
			int i = 0;

			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				numbers[i] = new BigInteger(line);
				i++;
			}
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Loop through and sum all the massive numbers
        BigInteger sum = new BigInteger("0");
        for(int i = 0; i < 100; i++){
        	sum = sum.add(numbers[i]);
        	System.out.println(sum);
        }
        System.out.println(sum);

	}
}