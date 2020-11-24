import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyVersion {
	public static int numOfCars = 0;
	public static int temp = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arrli  = new ArrayList<Integer>(n); 

		for(int i=0;i<n;i++) {
				
			arrli.add(sc.nextInt());
			
		}
		
		
	
		sort(arrli);
		System.out.print("Longest Train: "+temp);
	}

	
	public static void sort(ArrayList<Integer> arr) {
		ArrayList<Integer> newArrLi  = new ArrayList<Integer>(arr.size()); 
		if(Check(arr)>temp) {
			temp=Check(arr);
		}
		for(int i=0;i<arr.size();i++) {
			newArrLi.addAll(arr);
			newArrLi.remove(i);

		
	    	if(newArrLi.size()>0) {
				
				System.out.println(newArrLi);
				sort(newArrLi);
		    }
			newArrLi.clear();
		}
		
		
	}
	
	public static int Check(ArrayList<Integer> arr) {
		
		ArrayList<Integer> newArrLi  = new ArrayList<Integer>(arr.size()); 
		int LeftMost, RightMost;
		newArrLi.add(arr.get(0));
		LeftMost = arr.get(0);
		RightMost = arr.get(0);
		for (int i=1;i<arr.size();i++) {
			
			if(arr.get(i)>LeftMost){
				newArrLi.add(0,arr.get(i));
				LeftMost = arr.get(i);
			}
			else if (arr.get(i)<RightMost){
				newArrLi.add(arr.get(i));
				RightMost = arr.get(i);
			}
			else{
					
			}
		} 
	//	System.out.print(newArrLi);
		return newArrLi.size();
	}
	
}
