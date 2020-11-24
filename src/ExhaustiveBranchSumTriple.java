import java.util.Vector;

public class ExhaustiveBranchSumTriple {

	public static void main(String[] args) {

		branch(new Vector<Integer>());
	}

	static int solutionCount = 0;
	private static void branch(Vector<Integer> problemRepresentation) {

		if(problemRepresentation.size() == 16) {
			
			int numberOfOnes = 0;
			for(Integer value : problemRepresentation)
				numberOfOnes += value;

			if(numberOfOnes < 5) {
				System.out.print("Solution: " + ++solutionCount + " = ");
				for(Integer value : problemRepresentation)
					System.out.print(value);
				System.out.println();
			}

		} else {
			
			Vector<Integer> representationWithZero = new Vector<Integer>();
			representationWithZero.addAll(problemRepresentation);
			representationWithZero.add(0);			
			branch(representationWithZero);

			Vector<Integer> representationWithOne = new Vector<Integer>();
			representationWithOne.addAll(problemRepresentation);
			representationWithOne.add(1);			
			branch(representationWithOne);		

			Vector<Integer> representationWithTwo = new Vector<Integer>();
			representationWithTwo.addAll(problemRepresentation);
			representationWithTwo.add(2);			
			branch(representationWithTwo);				
		}
	}
}
