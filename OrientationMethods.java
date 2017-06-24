/* Name: Ryan McGregor
 * Thesis Project
 * Program Name: ThreeByThreeCube
 * Class: OrientationMethods
 * Purpose of this Program: The purpose of this program is to systematically
 * go through every possible case a 3x3x3 Rubik's cube can exist in,
 * in order to be able to say the following:
 *  		"when there are x moves performed on a 3x3x3 Rubik's Cube, 
 *  		there are ____ cases that take y moves to solve."
 *  A chart that will display the results is set up with incrementing x values
 *  in each column, incrementing y values for each row, and the blank will be
 *  filled in with the correct value to appropriately complete the statement.
 *  Purpose of this Class: This class exists to provide the main method with
 *  every possible movement the 3x3x3 Rubik's Cube can make, as well as x, y, 
 *  z entire-cube rotations, and lastly a re-orient method.
 *  
 * */
package cube;

public class OrientationMethods {
	
	/*performs a left slice clock-wise quarter turn.*/
	public static void left(int[] array){
		int temp = array[0];
		array[0] = array[45];
		array[45] = array[36];
		array[36] = array[12];
		array[12] = temp;
		
		temp = array[3];
		array[3] = array[48];
		array[48] = array[39];
		array[39] = array[21];
		array[21] = temp;
		
		temp = array[6];
		array[6] = array[51];
		array[51] = array[42];
		array[42] = array[30];
		array[30] = temp;
		
		temp = array[9];
		array[9] = array[27];
		array[27] = array[29];
		array[29] = array[11];
		array[11] = temp;
		
		temp = array[10];
		array[10] = array[18];
		array[18] = array[28];
		array[28] = array[20];
		array[20] = temp;	
	}
	
	/*performs a left slice counter-clock-wise quarter turn.*/
	public static void leftPrime(int[] array){
		int temp = array[0];
		array[0] = array[12];
		array[12] = array[36];
		array[36] = array[45];
		array[45] = temp;
		
		temp = array[3];
		array[3] = array[21];
		array[21] = array[39];
		array[39] = array[48];
		array[48] = temp;
		
		temp = array[6];
		array[6] = array[30];
		array[30] = array[42];
		array[42] = array[51];
		array[51] = temp;
		
		temp = array[9];
		array[9] = array[11];
		array[11] = array[29];
		array[29] = array[27];
		array[27] = temp;
		
		temp = array[10];
		array[10] = array[20];
		array[20] = array[28];
		array[28] = array[18];
		array[18] = temp;	
	}
	
	/*performs a right slice clock-wise quarter turn.*/
	public static void right(int[] array){
		int temp = array[53];
		array[53] = array[8];
		array[8] = array[32];
		array[32] = array[44];
		array[44] = temp;
		
		temp = array[50];
		array[50] = array[5];
		array[5] = array[23];
		array[23] = array[41];
		array[41] = temp;
		
		temp = array[47];
		array[47] = array[2];
		array[2] = array[14];
		array[14] = array[38];
		array[38] = temp;
		
		temp = array[33];
		array[33] = array[35];
		array[35] = array[17];
		array[17] = array[15];
		array[15] = temp;
		
		temp = array[24];
		array[24] = array[34];
		array[34] = array[26];
		array[26] = array[16];
		array[16] = temp;	
	}
	
	/*performs a right slice counter-clock-wise quarter turn.*/
	public static void rightPrime(int[] array){
		int temp = array[53];
		array[53] = array[44];
		array[44] = array[32];
		array[32] = array[8];
		array[8] = temp;
		
		temp = array[50];
		array[50] = array[41];
		array[41] = array[23];
		array[23] = array[5];
		array[5] = temp;
		
		temp = array[47];
		array[47] = array[38];
		array[38] = array[14];
		array[14] = array[2];
		array[2] = temp;
		
		temp = array[33];
		array[33] = array[15];
		array[15] = array[17];
		array[17] = array[35];
		array[35] = temp;
		
		temp = array[24];
		array[24] = array[16];
		array[16] = array[26];
		array[26] = array[34];
		array[34] = temp;	
	}
	
	/*performs an up slice clock-wise quarter turn.*/
	public static void up(int[] array){
		int temp = array[6];
		array[6] = array[29];
		array[29] = array[38];
		array[38] = array[15];
		array[15] = temp;
		
		temp = array[7];
		array[7] = array[20];
		array[20] = array[37];
		array[37] = array[24];
		array[24] = temp;
		
		temp = array[8];
		array[8] = array[11];
		array[11] = array[36];
		array[36] = array[33];
		array[33] = temp;
		
		temp = array[12];
		array[12] = array[30];
		array[30] = array[32];
		array[32] = array[14];
		array[14] = temp;
		
		temp = array[13];
		array[13] = array[21];
		array[21] = array[31];
		array[31] = array[23];
		array[23] = temp;	
	}
	
	/*performs an up slice counter-clock-wise quarter turn.*/
	public static void upPrime(int[] array){
		int temp = array[6];
		array[6] = array[15];
		array[15] = array[38];
		array[38] = array[29];
		array[29] = temp;
		
		temp = array[7];
		array[7] = array[24];
		array[24] = array[37];
		array[37] = array[20];
		array[20] = temp;
		
		temp = array[8];
		array[8] = array[33];
		array[33] = array[36];
		array[36] = array[11];
		array[11] = temp;
		
		temp = array[12];
		array[12] = array[14];
		array[14] = array[32];
		array[32] = array[30];
		array[30] = temp;
		
		temp = array[13];
		array[13] = array[23];
		array[23] = array[31];
		array[31] = array[21];
		array[21] = temp;	
	}
	
	/*performs a down slice clock-wise quarter turn.*/
	public static void down(int[] array){
		int temp = array[0];
		array[0] = array[17];
		array[17] = array[44];
		array[44] = array[27];
		array[27] = temp;
		
		temp = array[1];
		array[1] = array[26];
		array[26] = array[43];
		array[43] = array[18];
		array[18] = temp;
		
		temp = array[2];
		array[2] = array[35];
		array[35] = array[42];
		array[42] = array[9];
		array[9] = temp;
		
		temp = array[45];
		array[45] = array[51];
		array[51] = array[53];
		array[53] = array[47];
		array[47] = temp;
		
		temp = array[46];
		array[46] = array[48];
		array[48] = array[52];
		array[52] = array[50];
		array[50] = temp;	
	}
	
	/*performs a down slice counter-clock-wise quarter turn.*/
	public static void downPrime(int[] array){
		int temp = array[0];
		array[0] = array[27];
		array[27] = array[44];
		array[44] = array[17];
		array[17] = temp;
		
		temp = array[1];
		array[1] = array[18];
		array[18] = array[43];
		array[43] = array[26];
		array[26] = temp;
		
		temp = array[2];
		array[2] = array[9];
		array[9] = array[42];
		array[42] = array[35];
		array[35] = temp;
		
		temp = array[45];
		array[45] = array[47];
		array[47] = array[53];
		array[53] = array[51];
		array[51] = temp;
		
		temp = array[46];
		array[46] = array[50];
		array[50] = array[52];
		array[52] = array[48];
		array[48] = temp;	
	}
	
	/*performs a front slice clock-wise quarter turn.*/
	public static void front(int[] array){
		int temp = array[27];
		array[27] = array[47];
		array[47] = array[33];
		array[33] = array[30];
		array[30] = temp;
		
		temp = array[28];
		array[28] = array[46];
		array[46] = array[34];
		array[34] = array[31];
		array[31] = temp;
		
		temp = array[29];
		array[29] = array[45];
		array[45] = array[35];
		array[35] = array[32];
		array[32] = temp;
		
		temp = array[36];
		array[36] = array[42];
		array[42] = array[44];
		array[44] = array[38];
		array[38] = temp;
		
		temp = array[37];
		array[37] = array[39];
		array[39] = array[43];
		array[43] = array[41];
		array[41] = temp;	
	}
	
	/*performs a front slice counter-clock-wise quarter turn.*/
	public static void frontPrime(int[] array){
		int temp = array[27];
		array[27] = array[30];
		array[30] = array[33];
		array[33] = array[47];
		array[47] = temp;
		
		temp = array[28];
		array[28] = array[31];
		array[31] = array[34];
		array[34] = array[46];
		array[46] = temp;
		
		temp = array[29];
		array[29] = array[32];
		array[32] = array[35];
		array[35] = array[45];
		array[45] = temp;
		
		temp = array[36];
		array[36] = array[38];
		array[38] = array[44];
		array[44] = array[42];
		array[42] = temp;
		
		temp = array[37];
		array[37] = array[41];
		array[41] = array[43];
		array[43] = array[39];
		array[39] = temp;	
	}
	
	/*performs a back slice clock-wise quarter turn.*/
	public static void back(int[] array){
		int temp = array[9];
		array[9] = array[12];
		array[12] = array[15];
		array[15] = array[53];
		array[53] = temp;
		
		temp = array[10];
		array[10] = array[13];
		array[13] = array[16];
		array[16] = array[52];
		array[52] = temp;
		
		temp = array[11];
		array[11] = array[14];
		array[14] = array[17];
		array[17] = array[51];
		array[51] = temp;
		
		temp = array[0];
		array[0] = array[6];
		array[6] = array[8];
		array[8] = array[2];
		array[2] = temp;
		
		temp = array[1];
		array[1] = array[3];
		array[3] = array[7];
		array[7] = array[5];
		array[5] = temp;	
	}
	
	/*performs a back slice counter-clock-wise quarter turn.*/
	public static void backPrime(int[] array){
		int temp = array[9];
		array[9] = array[53];
		array[53] = array[15];
		array[15] = array[12];
		array[12] = temp;
		
		temp = array[10];
		array[10] = array[52];
		array[52] = array[16];
		array[16] = array[13];
		array[13] = temp;
		
		temp = array[11];
		array[11] = array[51];
		array[51] = array[17];
		array[17] = array[14];
		array[14] = temp;
		
		temp = array[0];
		array[0] = array[2];
		array[2] = array[8];
		array[8] = array[6];
		array[6] = temp;
		
		temp = array[1];
		array[1] = array[5];
		array[5] = array[7];
		array[7] = array[3];
		array[3] = temp;	
	}
	
	/*performs a middle layer (between L and R) clock-wise(as L) quarter turn.*/
	public static void m(int[] array){
		int temp = array[1];
		array[1] = array[46];
		array[46] = array[37];
		array[37] = array[13];
		array[13] = temp;
		
		temp = array[4];
		array[4] = array[49];
		array[49] = array[40];
		array[40] = array[22];
		array[22] = temp;
		
		temp = array[7];
		array[7] = array[52];
		array[52] = array[43];
		array[43] = array[31];
		array[31] = temp;
	}
	
	/*performs a middle layer(between L and R) counter-clock-wise(as L) quarter turn.*/
	public static void mPrime(int[] array){
		int temp = array[1];
		array[1] = array[13];
		array[13] = array[37];
		array[37] = array[46];
		array[46] = temp;
		
		temp = array[4];
		array[4] = array[22];
		array[22] = array[40];
		array[40] = array[49];
		array[49] = temp;
		
		temp = array[7];
		array[7] = array[31];
		array[31] = array[43];
		array[43] = array[52];
		array[52] = temp;
	}
	
	/*performs a middle layer(between F and B) clock-wise(as F) quarter turn.*/
	public static void s(int[] array){
		int temp = array[18];
		array[18] = array[50];
		array[50] = array[24];
		array[24] = array[21];
		array[21] = temp;
		
		temp = array[19];
		array[19] = array[49];
		array[49] = array[25];
		array[25] = array[22];
		array[22] = temp;
		
		temp = array[20];
		array[20] = array[48];
		array[48] = array[26];
		array[26] = array[23];
		array[23] = temp;
	}
	
	/*performs a middle layer(between F and B) counter-clock-wise(as F) quarter turn.*/
	public static void sPrime(int[] array){
		int temp = array[18];
		array[18] = array[21];
		array[21] = array[24];
		array[24] = array[50];
		array[50] = temp;
		
		temp = array[19];
		array[19] = array[22];
		array[22] = array[25];
		array[25] = array[49];
		array[49] = temp;
		
		temp = array[20];
		array[20] = array[23];
		array[23] = array[26];
		array[26] = array[48];
		array[48] = temp;
	}
	
	/*performs a middle layer(between U and D) clock-wise(as D) quarter turn.*/
	public static void e(int[] array){
		int temp = array[10];
		array[10] = array[5];
		array[5] = array[34];
		array[34] = array[39];
		array[39] = temp;
		
		temp = array[19];
		array[19] = array[4];
		array[4] = array[25];
		array[25] = array[40];
		array[40] = temp;
		
		temp = array[28];
		array[28] = array[3];
		array[3] = array[16];
		array[16] = array[41];
		array[41] = temp;
	}
	
	/*performs a middle layer(between U and D) counter-clock-wise(as D) quarter turn.*/
	public static void ePrime(int[] array){
		int temp = array[10];
		array[10] = array[39];
		array[39] = array[34];
		array[34] = array[5];
		array[5] = temp;
		
		temp = array[19];
		array[19] = array[40];
		array[40] = array[25];
		array[25] = array[4];
		array[4] = temp;
		
		temp = array[28];
		array[28] = array[41];
		array[41] = array[16];
		array[16] = array[3];
		array[3] = temp;
	}
	
	/*rotate the entire cube clockwise on R.*/
	public static void x(int[] array){
		leftPrime(array);
		mPrime(array);
		right(array);
	}
	
	/*rotate the entire cube counter-clockwise on R.*/
	public static void xPrime(int[] array){
		left(array);
		m(array);
		rightPrime(array);
	}
	
	/*rotate the entire cube clockwise on U.*/
	public static void y(int[] array){
		up(array);
		ePrime(array);
		downPrime(array);
	}
	
	/*rotate the entire cube counter-clockwise on U.*/
	public static void yPrime(int[] array){
		upPrime(array);
		e(array);
		down(array);
	}
	
	/*rotate the entire cube clockwise on F.*/
	public static void z(int[] array){
		front(array);
		s(array);
		backPrime(array);
	}
	
	/*rotate the entire cube counter-clockwise on F.*/
	public static void zPrime(int[] array){
		frontPrime(array);
		sPrime(array);
		back(array);
	}
	
	/*orient the cube to standard form.*/
	public static void reorient(int[] array){
		while(array[4] != 1 || array[19] != 2){
			while(array[4] != 1){
				if(array[19] != 1 && array[25] != 1){
					x(array);
				}
				else{
					y(array);
				}
			}
			while(array[19] != 2){
				z(array);
			}
		}
	}
}
