import java.lang.Math;
import java.util.*;

public class eulerProblem29{
	public static void main(String[] argv){
		int a, b;
		a = 100;
		b = 100;
		
		SortedSet values = new TreeSet();
		
		for(int i = 2; i <= a; i++){
			for(int j = 2; j <= b; j++){
				values.add(Math.pow(i, j));
			}
		}
		System.out.println(values);
		System.out.println("size = "  + values.size());
	}
}
