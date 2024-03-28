/**
 * 
 */

/**
 *
 * Author: Hamza Khan 
 * Date: September 30, 2023
 * Description; SELF TESTING MAIN from GUI program, this program will detemine if the key enetered is a valid key and 
 *              if the range or movement of the encryption based on the remainder left from the modulus 26
 * 
 * 
 */


public class UISelfTestingMain {


	public static boolean checkKey(int encryptKey) {
		// method which will output true or false if inputted key is between the range
		return (encryptKey >= -32767 && encryptKey <= 32768);
	}


	public static int putKeyInRange(int encryptKey) {  
		//method which will determine the range moved by the remainder left when dividing by 26 
		// Modulus used because when dividing by the number 26 the remainder will alwasy be between
		// 0-26
		return encryptKey % 26;
	}

	//Self Testing Main Method 
	public static void main(String[] args) {

		int key = 0;
		System.out.println(key + " is a Valid Key which means true: " + UI.checkKey(key));
		key = -50000;
		System.out.println(key + " is a Invalid Key which means false: " + UI.checkKey(key));
		key = 70000;
		System.out.println(key + " is a Invalid Key which means false: " + UI.checkKey(key));

		key = 26;
		System.out.println("The Key is " + key + ", Range Should be 0: " + UI.putKeyInRange(key));
		key = 27;
		System.out.println("The Key is " + key + ", Range Should be 1: " + UI.putKeyInRange(key));
		key = 30;
		System.out.println("The Key is " + key + ", Range Should be 4: " + UI.putKeyInRange(key));
		key = -30;
		System.out.println("The Key is " + key + ", Range Should be -4: " + UI.putKeyInRange(key));
		
		
	}

}
