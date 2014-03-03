public class eulerProblem17{
	public static void main(String[] args){
		int sum = 0;
		for(int i = 0; i < 1001; i++){
			sum += countLetters(numToString(i));
		}
		System.out.println("There are "+sum+" letters in the numbers 1-1000");
		//System.out.println(countLetters(numToString(342)));
		//System.out.println(countLetters(numToString(115)));
	}

	//count all characters except spaces and hyphens.
	public static int countLetters(String s){
		int sum = 0;
		//take out spaces and hyphens
		s = s.replaceAll(" +", "");
		s = s.replaceAll("\\-", "");
		for(int i = 0; i < s.length(); i++){
			sum++;
		}

		return sum;
	}

	//Convert a number into an english string. Works from 1 to 1000.
	public static String numToString(int n){
		String result = new String();
		//one thousand is highest supported number.
		if(n == 1000){
			return "One Thousand";
		}

		//convert int to char array
		char[] charDigits = Integer.toString(n).toCharArray();

		//convert char array to int array where there are always 3 spots for 3 digits.
		int[] intDigits = new int[3];

		if(charDigits.length == 3){
			intDigits[0] = Character.digit(charDigits[0], 10);
			intDigits[1] = Character.digit(charDigits[1], 10);
			intDigits[2] = Character.digit(charDigits[2], 10);
		}
		if(charDigits.length == 2){
			intDigits[0] = 0;
			intDigits[1] = Character.digit(charDigits[0], 10);
			intDigits[2] = Character.digit(charDigits[1], 10);
		}	
		if(charDigits.length == 1){
			intDigits[0] = 0;
			intDigits[1] = 0;
			intDigits[2] = Character.digit(charDigits[0], 10);
		}

		//Add to result string according to digits
		
		//Hundreds digit
		switch(intDigits[0]){
			case 0:
				break;
			case 1:
				result += "One Hundred";
				break;
			case 2:
				result += "Two Hundred";
				break;
			case 3:
				result += "Three Hundred";
				break;
			case 4:
				result += "Four Hundred";
				break;
			case 5:
				result += "Five Hundred";
				break;
			case 6:
				result += "Six Hundred";
				break;
			case 7:
				result += "Seven Hundred";
				break;
			case 8:
				result += "Eight Hundred";
				break;
			case 9:
				result += "Nine Hundred";
				break;
		}
		//work on this
		if(intDigits[0]!=0 &&(intDigits[1]!=0 || intDigits[2]!=0)){
			result += " And ";
		}


		//Tens digit
		switch(intDigits[1]){
			case 0:
				break;
			case 1:
			if(intDigits[2] ==  0){
				result += "Ten ";
				break;
			}
			if(intDigits[2] ==  1){
				result += "Eleven ";
				break;
			}
			if(intDigits[2] ==  2){
				result += "Twelve ";
				break;
			}
			if(intDigits[2] ==  3){
				result += "Thirteen ";
				break;
			}
			if(intDigits[2] ==  4){
				result += "Fourteen ";
				break;
			}
			if(intDigits[2] ==  5){
				result += "Fifteen ";
				break;
			}
			if(intDigits[2] ==  6){
				result += "Sixteen ";
				break;
			}
			if(intDigits[2] ==  7){
				result += "Seventeen ";
				break;
			}
			if(intDigits[2] ==  8){
				result += "Eighteen ";
				break;
			}
			if(intDigits[2] ==  9){
				result += "Nineteen ";
				break;
			}
			case 2:
				result += "Twenty ";
				break;
			case 3:
				result += "Thirty ";
				break;
			case 4:
				result += "Forty ";
				break;
			case 5:
				result += "Fifty ";
				break;
			case 6:
				result += "Sixty ";
				break;
			case 7:
				result += "Seventy ";
				break;
			case 8:
				result += "Eighty ";
				break;
			case 9:
				result += "Ninety ";
				break;
		}

		//Units digit
		if(intDigits[1] != 1){
		switch(intDigits[2]){
			case 0:
				break;
			case 1:
				result += "One";
				break;
			case 2:
				result += "Two";
				break;
			case 3:
				result += "Three";
				break;
			case 4:
				result += "Four";
				break;
			case 5:
				result += "Five";
				break;
			case 6:
				result += "Six";
				break;
			case 7:
				result += "Seven";
				break;
			case 8:
				result += "Eight";
				break;
			case 9:
				result += "Nine";
				break;
		}
	}

		return result;
	}
}