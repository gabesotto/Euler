import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;

public class eulerProblem18{
	public static void main(String[] args){
		final long startTime = System.currentTimeMillis();
		int[][] triangle = readFile();
		//return the last row of leaves with maxpathes, the greatest of these is the answer
		int[] max = maxPath(triangle);
		int maxSum = 0;
		for(int i = 0; i < max.length; i++){
			if(max[i] > maxSum){
				maxSum = max[i];
			}
		}
		System.out.println("The Max Path Sum is " + maxSum);
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) );
		
	}

	

	//returns a binary tree from file.
	public static int[][] readFile(){
	File file = new File("eulerProblem18.txt");
	int row = 0;
	String[] rows = new String[1000]; //array to hold rows as string
	
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); //get line as string
                rows[row++] = line; //put line into rows array
			 }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int[][] triangle = new int[row][];
        //loop through rows creating triangle structure
        for(int i = 0; i < row; i++){
        	triangle[i] = new int[i+1];
       		String[] temp = rows[i].split("\\s+");
        	for(int j = 0; j < triangle[i].length; j++){
        		triangle[i][j] = Integer.parseInt(temp[j]);
        	}
        }
        return triangle;
	}

	public static int[] maxPath(int[][] triangle){
		//do the first 3 numbers manually since they are edge cases.
		triangle[1][0] += triangle[0][0];
		triangle[1][1] += triangle[0][0];

		for(int i = 2; i < triangle.length; i++){
			for(int j = 0; j < triangle[i].length; j++){
				//edge cases
				//left edge
				if(j == 0){
					triangle[i][j] += triangle[i-1][j];
				//right edge
				}else if(j == (triangle[i].length - 1)){
					triangle[i][j] += triangle[i-1][j-1];
				}else{ //middle piece
					int a = triangle[i][j];
					int b = triangle[i-1][j];
					int c = triangle[i-1][j-1];
					/*System.out.println("a"+a);
					System.out.println("b"+b);
					System.out.println("c"+c);
					System.out.println("max"+Math.max((a+b),(a+c)));*/
					triangle[i][j] = Math.max((a+b),(a+c));
				}
			}
		}
		return triangle[triangle.length-1];
	}
}