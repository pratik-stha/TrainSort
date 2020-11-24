// kattis ID: busnumbers2
import java.util.Scanner;
public class BusNumber {

   
	public static void main(String[] args) {
        
        Scanner inputScanner = new Scanner(System.in);
        int limit = inputScanner.nextInt();
        inputScanner.close();
        for(int attempt = limit; attempt > 0; attempt--) {
        		
        		if(busNumber(attempt)) {
        			System.out.println(attempt);
        			return;
        		} 
        }
        
        System.out.println("none");
    }

	private static boolean busNumber(int attempt) {

		int count = 0;
		for(int firstCube = 1; cubed(firstCube) < attempt; firstCube++)
			for(int secondCube = 1; cubed(secondCube) < cubed(firstCube); secondCube++) {
				if(cubed(firstCube) + cubed(secondCube) == attempt)
					count++;
			}
		
		return count > 1;
	}

	private static int cubed(int toCube) {
		return toCube * toCube * toCube;
	}
}