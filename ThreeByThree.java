/* Name: Ryan McGregor
 * Thesis Project
 * Program Name: ThreeByThreeCube
 * Class: ThreeByThree
 * Purpose of this Program: The purpose of this program is to systematically
 * 		go through every possible case a 3x3x3 Rubik's cube can exist in,
 * 		in order to be able to say the following:
 *  		"When there are x moves performed on a 3x3x3 Rubik's Cube, 
 *  		there are ____ cases that take y moves to solve."
 * 		A chart that will display the results is set up with incrementing x values
 * 		 in each column, incrementing y values for each row, and the blank will be
 *  		filled in with the correct value to appropriately complete the statement.
 *  Purpose of this Class: This class runs the main program which works like this:
 *  		Starting with x = 0, all the way up to x = 20, the program will perform all
 *  		possible sequences of x moves, then try to find matches amongst all states that
 *  		have already been stored, and if so, will count it accordingly.
 *  		For example, When x = 3, the program will compute every outcome that results
 *  		from performing 3 moves on the 3x3x3 Rubik's Cube. Each outcome will go through
 *  		the following: 
 *  		1) It will be traverse the binary search tree that stores the 1 state that
 *  			takes 0 moves to solve, and if a match is found, it will increment the 
 *  			zeroCounter.
 * 			2) It will traverse the binary search tree that stores all 18 states that 
 *  			take 1 move to solve, and if a match is found, it will increment the oneCounter.
 *  		3) It will traverse the binary search tree that stores all 243 states that take 2
 * 	 		   moves to solve, and if a match is found, it will increment the twoCounter.
 *  		4) It will traverse the binary search tree that stores the states that take 3
 *  			moves to solve, and if a match is found, it will increment the repeatCounter.
 *  		5) If it doesn't find a match in any of these trees, finally it will be
 *  			entered into the tree designated for storing all the states that take 3 moves to solve.
 *  		When the program is done doing this for every possible outcome while x = 3, 
 *  		it will move on to x = 4 and perform the same task for all possible outcomes of 4 moves.
 *  		It will do this until all possible outcomes are covered, or when x = 20.
 *  
 * */
package cube;

/*Import the BigInteger library*/
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*ThreeByThree class*/
public class ThreeByThree {	
	
	/*Set the number of cores*/
	static int cores = Runtime.getRuntime().availableProcessors();
	
	/*Set the number of threads to the number of cores*/
	ExecutorService executor = Executors.newFixedThreadPool(cores);
	
	/*Timers*/
	static long startTime;
	static long intermediateTime;
	static long endTime;
	
	/*Counters*/
	static BigInteger[] counterArray = new BigInteger[20];
	static BigInteger count = new BigInteger("1");
	static BigInteger zero = new BigInteger("0");
	static BigInteger one = new BigInteger("1");
	static BigInteger ten = new BigInteger("10");
	static BigInteger tenthousand = new BigInteger("10000");
	static BigInteger eightteen = new BigInteger("18");
	static BigInteger uniqueCounter = new BigInteger("0");
	static BigInteger repeatCounter = new BigInteger("0");
		
	/*Array List of storage trees*/
	static ArrayList<BinarySearchTree<BigInteger>> trees = new ArrayList<BinarySearchTree<BigInteger>>();
	
	/*Reset all counters*/
	public static void resetCount(){
		count = one;
		uniqueCounter = zero;
		repeatCounter = zero;
		for(int i = 0; i < counterArray.length; i++)
			counterArray[i] = new BigInteger("0");
	}
	
	/*Returns a particular counter result*/
	public static BigInteger counterReturn(int i){
		return counterArray[i];
	}
	
	/*Increments the proper counter*/
	public static void counterIncrementer(int i){
		counterArray[i] = counterArray[i].add(one);
	}
	
	/*Prints the results*/
	public static void printResults(int i){
		int j = 0;
		int marker = 0;
		if(i == 1)
			System.out.println("Starting from a solved cube, when there is " + i + " move (18^" + i + " = " + count + " total outcomes), ");
		else if(i == 0)
			System.out.println("Starting from a solved cube, when there are " + i + " moves (18^" + i + " = " + count + " total outcome), ");
		else
			System.out.println("Starting from a solved cube, when there are " + i + " moves (18^" + i + " = " + count + " total outcomes), ");
		if(i == 0)
			System.out.println("there was 1 unique case that took 0 moves to solve.");
		while(marker < i){
			System.out.print("there were ");
			System.out.print(counterReturn(j));
			if(j == 1)
				System.out.println(" cases that took " + j + " move to solve, ");
			else
				System.out.println(" cases that took " + j + " moves to solve, ");
			j++;
			marker++;
		}
		if(i != 0){
			if(i == 1){
				System.out.println(uniqueCounter.toString() + " were unique cases that took " + i + " move to solve,");
				System.out.println("while " + repeatCounter.toString() + " of them were repeat cases that also took " + i + " move to solve.");
			}
			else{
				System.out.println(uniqueCounter.toString() + " were unique cases that took " + i + " moves to solve,");
				System.out.println("while " + repeatCounter.toString() + " of them were repeat cases that also took " + i + " moves to solve.");
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("Execution time for this module: " + (endTime - intermediateTime) );
		System.out.println("Total execution time so far: " + (endTime - startTime));
		System.out.println("-----------------------------------------------------------------");
	}
	
	/*Intakes the i value and performs the appropriate orientation 
	  method on the cube, represented as an array*/
	public static void switcher(int moveSequence, int[] array){
		switch(moveSequence){
			case 1:  OrientationMethods.left(array);
					 break;
			case 2:  OrientationMethods.leftPrime(array);
					 break;
			case 3:  OrientationMethods.right(array);
					 break;
			case 4:  OrientationMethods.rightPrime(array);
					 break;
			case 5:  OrientationMethods.up(array);
					 break;
			case 6:  OrientationMethods.upPrime(array);
					 break;
			case 7:  OrientationMethods.down(array);
					 break;
			case 8:  OrientationMethods.downPrime(array);
					 break;
			case 9:  OrientationMethods.back(array);
					 break;
			case 10: OrientationMethods.backPrime(array);
					 break;
			case 11: OrientationMethods.front(array);
					 break;
			case 12: OrientationMethods.frontPrime(array);
					 break;
			case 13: OrientationMethods.e(array);
					 break;
			case 14: OrientationMethods.ePrime(array);
					 break;
			case 15: OrientationMethods.m(array);
					 break;
			case 16: OrientationMethods.mPrime(array);
					 break;
			case 17: OrientationMethods.s(array);
					 break;
			case 18: OrientationMethods.sPrime(array);
					 break;
			default: break;
		}
	}
	
	/*Converts the array of cube states to a unique 
	 * BigInteger key*/
	public static BigInteger convert(int[] array){
		BigInteger exponent = new BigInteger("1");
		BigInteger total = new BigInteger("0");
		for(int i = 0; i < array.length; i++){
			total = total.add((BigInteger.valueOf(array[array.length - i - 1]).multiply(exponent)));
			exponent = exponent.multiply(ten);
		}
		return total;
	}
	
	/*Takes in the current cube as a BigInteger, int i, int j, and the tree to be searched.
	 * Searches for a match in the inputed tree. If a match is found, it'll return true,
	 * otherwise false*/
	public static boolean search(BigInteger cube, int i, int j, BinarySearchTree<BigInteger> tree){
		if(i > j && tree.find(cube)){
			counterIncrementer(j);
			return true;
		}
		return false;
	}
	
/*Takes in the current cube as a BigInteger, and int i. It returns true if any search
 * method call returns true, otherwise it returns false*/
	public static boolean test(BigInteger cube, int i){
		for(int a = 0; a < 20; a++){
			if(search(cube, i, a, trees.get(a))){
				return true;
			}
		}
		return false;
	}
	
	/*Goes through every possible outcome for 'input' amount of moves, and
	 * for each outcome, either finds a match and increments the appropriate
	 * count, or inserts the outcome into 'tree'. After exhausting all outcomes,
	 * it prints the results and resets all counts.*/
	public static void execute(int input, BinarySearchTree<BigInteger> tree){
		
		/*Set the intermediateTime so each module can be timed*/
		intermediateTime = System.currentTimeMillis();
		
		/*Based on input, multiply count by 18 the current amount of
		 * times to establish the total amount of times to iterate*/
		for(int i = 0; i < input; i++)
			count = count.multiply(eightteen);
		
		/*For each possible outcome when doing 18^(input) moves..*/
		for(BigInteger i = BigInteger.ZERO; i.compareTo(count) < 0; i = i.add(one)){
			
			/*This is where I want the pool to send threads to pick up jobs.
			 * This is also where the job would begin.*/
			
			/*Declare a 'found' boolean as false (nothings been found yet)*/
			boolean found = false;
			
			/*Create a string that represents the current i value in base 18*/
			String str = i.toString(18);
			
			/*Add 0's to the front of that string until it is the right length (if
			 * necessary)*/
			while(str.length() < input)
				str = "0" + str;
			
			/*Create a solved cube*/
			int[] Cube = {1,1,1,1,1,1,1,1,1,
						  2,2,2,3,3,3,4,4,4,
						  2,2,2,3,3,3,4,4,4,
						  2,2,2,3,3,3,4,4,4,
						  5,5,5,5,5,5,5,5,5,
						  6,6,6,6,6,6,6,6,6};
			
			/*Perform the appropriate moves on the solved cube*/
			for(int j = 0; j < input; j++)
				switcher((Character.getNumericValue(str.charAt(j)) + 1), Cube);
			
			/*Reorient the cube*/
			OrientationMethods.reorient(Cube);
			
			/*Convert the cube to a BigInteger*/
			BigInteger cube = convert(Cube);
			
			System.out.println(cube);//temporary
			
			/*Search for a match of the cube in each of the trees that
			 * have already been created, and if a match is found,
			 * increment the appropriate counter and set found to true*/
			found = test(cube, input);
			
			/*This is where a single threads' job would end. After the thread
			 * is complete, if the cube in a particular thread wasn't found in 
			 * any of the trees storing states that are less than the current 
			 * 'input' value, then that cube needs to run through the rest of 
			 * this method, meaning the boolean has to be stored along with 
			 * the cube in some way, while this execute method goes through 
			 * these last 2 operations (searching for a match in the 
			 * currently-being-filled tree, for a repeat, and if a match STILL 
			 * isn't found, inserting the cube into the currently-being-filled 
			 * tree) for each cube-state that wasn't found in a smaller x-value tree.
			 * If a match was found, on the other hand, then it won't be necessary
			 * for that cube to run through these last 2 operations.*/
			
			/*If no match is found in the already created trees, search
			 * for a match in the currently-being-created tree. If a
			 * match is found, increment the repeatCounter and set
			 * found to true*/
			if(found == false && tree.find(cube)){
				repeatCounter = repeatCounter.add(one);
				found = true;
			}
			/*If no match is found, insert the cube into the
			 * currently-being-created tree, and increment the
			 * uniqueCounter*/
			if(found == false){
				tree.insert(cube);
				uniqueCounter = uniqueCounter.add(one);
			}
			/*Reset found to false*/
			found = false;
			/*Garbage collection to avoid GC Overhead issue*/
			if(i.mod(tenthousand) == zero)
				System.gc();
		}
		/*Print the results and reset the counts*/
		printResults(input);
		resetCount();
	}
	
	/*puts all the components of the program into a simple method*/
	public static void run(){
		/*Set the counter array*/
		for(int i = 0; i < counterArray.length; i++)
			counterArray[i] = new BigInteger("0");
		/*Set the tree arraylist*/
		for(int i = 0; i < 21; i++)
			trees.add(new BinarySearchTree<BigInteger>());
		/*Set the start time*/
		startTime = System.currentTimeMillis();
		System.out.println("Cores: " + cores);
		/*execute the program at each x-distance*/
		for(int i = 0; i < 2; i++)
			execute(i, trees.get(i));
	}
	
	/*Runs the program*/
	public static void main(String[] args){
		run();
	}
}