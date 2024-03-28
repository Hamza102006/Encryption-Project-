import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * Name: Aiden Le
 *
 * Date: Sept 26 2023
 *
 * Description: Reads several phrases from a file 
 * 
 * Method List: public static int getKey(String fileName) throws IOException - Reads the first line to find the key in
 *																			   the file
 *				public static String[] readFile (String fileName) throws IOException - Reads the file
 *				public static void writeToFile(String fileName, String info[]) throws IOException - Rewrites the file
 *																									in a new file
 */
public class TheFileAccess {
	/**
	 * Method to read the first line of the file and finding the encryption/decryption code
	 */
	public static int getKey(String fileName) throws IOException {
		// Declare and initialize variables
		int code = 0;

		// Open a file to read
		BufferedReader input = new BufferedReader(new FileReader(fileName));

		code = Integer.parseInt(input.readLine());

		input.close(); // closes the file

		return code;
	}

	/**
	 * Method to open the file
	 */
	public static String[] readFile (String fileName) throws IOException {
		// Declare and initialize variables
		String line;

		int lineCount = 0;

		// open a file to read
		BufferedReader input = new BufferedReader(new FileReader(fileName));

		line = input.readLine();

		while(!line.equals("EOF")) {

			lineCount++;

			line = input.readLine();

		}
		// Closes file
		input.close();

		// Re opens the file to read it
		input = new BufferedReader(new FileReader(fileName));

		String phrases [] = new String [lineCount]; //create an array of the right size

		for (int i = 0; i < lineCount; i++){

			phrases [i] = input.readLine();

		}

		input.close(); // Close file

		return phrases;

	}

	/**
	 * Method to write into a new file
	 */
	public static void writeToFile(String fileName, String info[]) throws IOException {

		// Load file

		PrintWriter output = null;

		output = new PrintWriter(new FileWriter(fileName));

		for (int i = 0; i < info.length; i++) {

			output.println(info[i]); // Write all the lines of code

		}
		output.println("EOF"); // Adds "EOF" to re-read the file

		output.close();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// Declare and initialize variables
		String fileName, newFile;
		String fileInfo[] = null;
		String newFileInfo[] = null;
		int key = 0;

		// Initialize variables
		fileName = "Encrypted.dat";
		newFile =  "newFile.dat";

		fileInfo = readFile(fileName); // Load File
		key = getKey(fileName); // Get key from file

		// Display the contents of the output array
		for(int i = 1; i < fileInfo.length; i++) {
			System.out.println(fileInfo[i]);
		}
		System.out.println("\nThe encode/decode is: " + key);

		// Call method to write into a new file
		writeToFile(newFile, fileInfo);
		newFileInfo = readFile(newFile); // Read the new file info
		System.out.println("\nNew File: " + newFile);
		
		// Display the new contents from the new file
		for(int i = 1; i < newFileInfo.length; i++) {
			System.out.println(newFileInfo[i]);
		}
		System.out.println("\nThe encode/decode is: " + getKey(newFile));



	}
}


