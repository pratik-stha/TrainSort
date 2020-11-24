// kattis ID: alphabet
import java.util.Scanner;

public class Alphabet {

    static char alphabetCharacters[] = null;

    public static void main(String[] args) {
        
        Scanner inputScanner = new Scanner(System.in);

        String inputAlphabet = inputScanner.nextLine();
        
        alphabetCharacters = new char[inputAlphabet.length()];
        boolean includedCharacters[] = new boolean[inputAlphabet.length()];
        
        for(int loop = 0; loop < inputAlphabet.length(); loop++) {
        		alphabetCharacters[loop] = inputAlphabet.charAt(loop);
        		includedCharacters[loop] = true;
        }

        System.out.println(process(includedCharacters, 0));
        inputScanner.close();
    }

	private static int process(boolean[] includedCharacters, int depth) {

		if(depth >= includedCharacters.length) {
			
			return calculateMin(includedCharacters);
		}
		
		includedCharacters[depth] = true;
		int onMinimum = process(includedCharacters, depth+1);
		
		includedCharacters[depth] = false;
		int offMinimum = process(includedCharacters, depth+1);
		
		if(onMinimum < offMinimum)
			return onMinimum;
		else
			return offMinimum;
	}

	private static int calculateMin(boolean[] includedCharacters) {
		
		int count = 0;
		
		char lastChar = 'a'-1;
		for(int loop = 0; loop < includedCharacters.length; loop++) {

			if(includedCharacters[loop]) {
				if(lastChar >= alphabetCharacters[loop])
					return Integer.MAX_VALUE;
				else {
					count += (alphabetCharacters[loop] - lastChar) - 1;
					
					lastChar = alphabetCharacters[loop];
				}
			}
		}
		
		count += ('z' - lastChar);

		return count;
	}
}