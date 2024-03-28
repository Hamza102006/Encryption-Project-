/**
 * 
 */

/**
 * Name: Sanat Kanwal
 * Group: Sanat Kanwal, Hamza, Aiden
 * Date: September 2023 
 *
 * Description: This program takes in a phrase and encrypts or decrypts it using a certain phrase.
 * 				The new phrase is displayed through the GUI.
 * 
 * Method List: public static boolean isALetter (char character) { - returns true if the character is a letter 
 * 				public static char encode(char letter , int encryptKey) { - returns an encrypted character 
 * 				public static char decode(char letter , int decryptKey) { - returns a decrypted character 
 */
public class Encryption {

	/**
	 * @param args
	 */

	public static boolean isALetter (char character) { 
		int ascii = (int)character; // convert character to an integer value and assign it to ascii
		
		// check if the ascii is a letter by checking between lowercase a and lowercase z
		// or uppercase a and lowercase z
		if(((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122))) { 
			return true; //returns true if it satisfies the condition thus making it a letter
		}
		
		else {
			return false; //returns false if it does not satisfy the condition
		}
	}

	public static char encrypt(char letter , int encryptKey) {
		// declare variables for the ascii value and the position of the encrypted character
		int ascii, position; 
		
		// call the isALetter method to check if the character is a letter
		// if it is than encrypt
		if (isALetter(letter) ==true) {
			
			// if the letter is an uppercase
			if (Character.isUpperCase(letter)) {
				ascii = (int)letter; // convert the letter to an integer (ascii value)
				position = ((ascii + encryptKey - 65) % 26 + 65); // calculates the position of where the new letter will be
				letter = (char)position; //converts the position integer ascii value to a character
			}
			
			// if the letter is not an uppercase, it must be a lowercase
			else { 
				ascii = (int)letter; // convert the letter to an integer (ascii value)
				position = ((ascii + encryptKey - 97) % 26 + 97);  // calculates the position of where the new letter will be
				letter = (char)position; //converts the position integer ascii value to a character
			}
			return letter; // return the encrypted character
		}
		
		// if it is not a letter (special character), leave it in its position
		// and iterate to the next character of the string
		else {
			return letter; // return the encrypted character
		}

	}

	public static char decrypt(char letter , int decryptKey) {
		return encrypt(letter, 26-(decryptKey%26));
	}

	public static void main(String[] args) {
		int key = 3256; 
		char encode, decode, phrase;
		//String x = "The cook worked 12 hours in the darkened kitchen!";
		//String x = "Wkh frrn zrunhg 12 krxuv lq wkh gdunhqhg nlwfkhq!";
		
		//String x = "Did Fred look well? That's it!";
		//String x = "Chc Eqdc knnj vdkk? Sgzs'r hs!";
		
		//String x = "Well, all 2567 spies liked the encrypting program.";
		String x = "Ckrr, grr 2567 yvoky roqkj znk ktixevzotm vxumxgs.";

		for (int i = 0; i < x.length(); i++) {
			phrase = x.charAt(i); 
			decode = decrypt(phrase, key);
			//encode = encrypt(phrase, key);

			System.out.print(decode);

		}

	}

}