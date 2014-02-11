import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class eulerProblem8{
	public static void main(String[] args){
		//has 50 numbers per line, and 20 ines
	// Location of file to read
        File file = new File("eulerProblem8.txt");
        int[] digits = new int[1000]; //array to hold 1000 digits from file
        char[] charLine = new char[50];
        int index = 0;
        int max = 0;
        try {
 
            Scanner scanner = new Scanner(file);
 
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); //get line as string
                charLine = line.toCharArray(); //convert string to char array
                for(int i = 0; i < 50; i++){ //loop through the char array and put into int array
                    digits[index] = Character.digit(charLine[i], 10);
                    index++;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //loop through digits in sections of 5, multiply and find max.
        for(int i = 0; i < 996; i++){
            int temp = digits[i] * digits[i+1] * digits[i+2] * digits[i+3] * digits[i+4];
            if(temp > max){
                max = temp;
            }
        }

            System.out.println("The greatest product of five consecutive digits in the 1000 digit number is " + max);
		}
	}