import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;


/*
 * Authour: Hamza Khan
 * Group: Hamza, Aiden, Sanat 
 * Date: September 26, 2023
 * Description: GUI to which will allow the user to enter live or file text which will have the ability to be able to be 
 *              encrypted as well as decrypted. The program will also allow the User to save thier encrypted and decrypted files 
 *              while being user friendly 
 * 
 * 
 * METHODS:
 * 
 * public class UI extends JFrame implements ActionListener { - GUI which uses JFrame and has actionslistner within it making a user friendly 
 *                                                              Graphical User Interface
 * 
 * 
 * public static boolean checkKey(int encryptKey) { - checks the entered key if it is within range (true if yes) (false if not)
 * 
 * 
 * public static int putKeyInRange(int encryptKey) {  - uses modulus function by 26 to determine range and movement of the encryption 
 * 
 * 
 * public UI() { - GUI buttons, textAreas and more 
 * 
 * 
 * public void actionPerformed(ActionEvent event) { - void method which detemines what happens when a action (or button) is activated/clicked
 * 
 * 
 * public static int getKey(String key) { - gets the key and makes it a integer value 
 * 
 * 
 * public static void main(String[] args) { - main
 * 
 */

public class UI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	
	
	//Declaring all the J variables 
	JLabel lblInputKey, lblInput, lblOutput, lblFileInput, lblFileName;
	JTextArea txtInput;
	JTextField txtInputKey, txtInputFile;
	JTextArea txtOutput, txtFileOutput;
	JButton btnEncryptLive, btnDecryptLive, btnEncryptFile, btnDecryptFile, btnSave, btnExit, btnClear;

	
	
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

	public UI() {  // Method for the UI
		super("Encryption Application"); // UI Name

		// create labels
		lblInputKey = new JLabel("Enter Key Below:"); 
		lblInput = new JLabel("Input Text below & Select Encrypt or Decrypt LIVE");
		lblFileInput = new JLabel("Text from File:");
		lblFileName = new JLabel("Enter Filename Below");
		lblOutput = new JLabel("Output Text below Represents Encrypted/Decrypted Text");

		// create text fields and text area
		txtInput = new JTextArea(5, 30);
		txtInput.setWrapStyleWord(true);
		txtInput.setLineWrap(true);

		txtOutput = new JTextArea(5, 30);
		txtOutput.setWrapStyleWord(true);
		txtOutput.setLineWrap(true);
		txtOutput.setEditable(false);

		txtFileOutput = new JTextArea(5, 30);
		txtFileOutput.setWrapStyleWord(true);
		txtFileOutput.setLineWrap(true);
		txtFileOutput.setEditable(false);

		//Implement Scroll Function in txt area for more user friendly experience
		JScrollPane inputScrollPane = new JScrollPane(txtInput);
		JScrollPane outputScrollPane = new JScrollPane(txtOutput);
		JScrollPane outputFileScrollPane = new JScrollPane(txtFileOutput);

		//file and key input
		txtInputFile = new JTextField();
		txtInputKey = new JTextField();

		// create buttons
		btnEncryptLive = new JButton("Encrypt (Live)");
		btnDecryptLive = new JButton("Decrypt (Live)");
		btnEncryptFile = new JButton("Encrypt (File)");
		btnDecryptFile = new JButton("Decrypt (File)");
		btnSave = new JButton("Save Live -> File");
		btnExit = new JButton("Exit");
		btnClear = new JButton("Clear All");

		// Set layout and size for the window/GUI
		setLayout(null);
		setSize(800, 520);
		setLocationRelativeTo(null);

		// Set size and location of labels
		lblInputKey.setBounds(10, 0, 350, 20);
		lblFileName.setBounds(190, 0, 350, 20);
		lblInput.setBounds(10, 45, 350, 20);
		lblFileInput.setBounds(10, 190, 350, 20);
		lblOutput.setBounds(10, 330, 350, 20);

		// Set location and size for text fields and scroll pane
		inputScrollPane.setBounds(10, 65, 480, 120);
		outputScrollPane.setBounds(10, 350, 480, 120);
		outputFileScrollPane.setBounds(10, 210, 480, 120);
		txtInputKey.setBounds(10, 20, 150, 25);
		txtInputFile.setBounds(190, 20, 150, 25);

		// Set location and size of buttons
		btnEncryptLive.setBounds(500, 160, 300, 80);
		btnDecryptLive.setBounds(500, 240, 300, 80);
		btnEncryptFile.setBounds(500, 0, 300, 80);
		btnDecryptFile.setBounds(500, 80, 300, 80);
		btnSave.setBounds(500, 320, 300, 80);
		btnExit.setBounds(500, 400, 300, 80);
		btnClear.setBounds(375, 10, 100, 40);

		
		//add all the buttons and scroll functions 
		add(lblInput);
		add(lblFileInput);
		add(lblFileName);
		add(lblInputKey);
		add(lblOutput);
		add(inputScrollPane);
		add(outputScrollPane);
		add(outputFileScrollPane);
		add(txtInputKey);
		add(txtInputFile);
		add(btnEncryptLive);
		add(btnDecryptLive);
		add(btnEncryptFile);
		add(btnDecryptFile);
		add(btnSave);
		add(btnExit);
		add(btnClear);

		//action listener added to help program determine what to do when
		//the buttons or any action has been clicked or performed 
		btnEncryptLive.addActionListener(this);
		btnDecryptLive.addActionListener(this);
		btnEncryptFile.addActionListener(this);
		btnDecryptFile.addActionListener(this);
		btnSave.addActionListener(this);
		btnExit.addActionListener(this);
		btnClear.addActionListener(this);

		setVisible(true); 
	}

	//method to determine the action after functions or click
	public void actionPerformed(ActionEvent event) {

		// if Encrypt Live Clicked 
		if (event.getSource() == btnEncryptLive) {

			String inputText = txtInput.getText();  //turn txtInput into string
			int encryptKey = getKey(txtInputKey.getText()); //get key from input and set as int
			if (checkKey(encryptKey)) { // check if inputed key is between the mandatory range 
				encryptKey = putKeyInRange(encryptKey); //use the putKeyInRange method to determine the movement using % 26
				char[] inputChars = inputText.toCharArray(); // set the char variable and check character in input 
				String encryptedText = "";
				for (int i = 0; i < inputChars.length; i++) { //for loop to determine the amount of times program runs through phrase
					char letter = inputChars[i];
					//Call Method from encryption class and encrypt the letters/characters in the phrase and save variable as encryptedText
					encryptedText += Encryption.encrypt(letter, encryptKey); 
				}
				txtOutput.setText(encryptedText); // Display the Encrypted text 
			}
			else {
				//invalid Key Entered
				JOptionPane.showMessageDialog(this, "Invalid encryption key (Enter Value: -32768 to 32768)"); 
			}
		} 
		
		// if Decrypt Live Clicked 
		else if (event.getSource() == btnDecryptLive) {
			
			//Method Calling and Function to Decrypt Live Text Entered 
			String inputText = txtInput.getText(); //turn txtInput into string
			int decryptKey = getKey(txtInputKey.getText()); //get key from input and set as int
			if (checkKey(decryptKey)) { // check if inputed key is between the mandatory range 
				decryptKey = putKeyInRange(decryptKey); //use the putKeyInRange method to determine the movement using % 26
				char[] inputChars = inputText.toCharArray(); // set the char variable and check character in input
				String decryptedText = "";
				for (int i = 0; i < inputChars.length; i++) { //for loop to determine the amount of times program runs through phrase
					char letter = inputChars[i];
					//Call Method from encryption class and decrypt the letters/characters in the phrase and save variable as decryptedText
					decryptedText += Encryption.decrypt(letter, decryptKey);
				}
				txtOutput.setText(decryptedText); //Display the Decrypted Text
			}
			else {
				//invalid Key Entered
				JOptionPane.showMessageDialog(this, "Invalid decryption key (Enter Value: -32768 to 32768)"); 
			}
		} 
		
		// if Encrypt File Clicked 
		else if (event.getSource() == btnEncryptFile) {
			
			String filePath = txtInputFile.getText(); //set txtInputFile as string called filePath
			if (!filePath.isEmpty()) {  //if the file is not empty then the program reads file and sets to encrypts 
				String[] fileContent = null; // Initialize new variable fileContent to null
				try { //Try and Catch Added To Catch any Error occurring when File is being read 
					fileContent = TheFileAccess.readFile(filePath); // reads the file using readFile class in TheFileAccess Class
				} catch (IOException e) { // NOT SURE WHAT TO WRITE HERE 
					// TODO Auto-generated catch block
					e.printStackTrace(); 
				}
				
				if (fileContent.length > 0) { //if the content in the file is greater than 0 the program runs 
					int encryptKey = getKey(fileContent[0]); // gets the encrypt key from top of file 
					if (checkKey(encryptKey)) { // checks if the key from the file fits the mandatory range 
						encryptKey = putKeyInRange(encryptKey); //runs through the putKeyInRange method to go through % 26 and determine movement/range
						String encryptedFileContent = ""; // sets string called encryptedFileContent
						for (int i = 1; i < fileContent.length; i++) { //for loop and runs through the entire file phrases
							String line = fileContent[i]; // sets string called line and has the fileContent at i 
							char[] lineChars = line.toCharArray(); // set the char variable and check characters in string line 
							for (int j = 0; j < lineChars.length; j++) { // goes through the line and its characters 
								char letter = lineChars[j]; // letters at the lineChars[j]
								encryptedFileContent += Encryption.encrypt(letter, encryptKey); //encrypts the letter at that location calling encryption class
							}
							encryptedFileContent += "\n"; // adds new/next line after the encryptedFileContent
						}
						txtOutput.setText(encryptKey + "\n" + encryptedFileContent); //display the encrypted data plus the key at the top
						
						//display the data in the file output box using String.join which returns a new String composed of 
						//copies of the CharSequence elements joined together with a specified delimiter
						//which in this case was the \n which was learned in a lab 
						txtFileOutput.setText(String.join("\n", fileContent)); 
					} else {
						JOptionPane.showMessageDialog(this, "Invalid encryption key (Enter Value: -32768 to 32768)"); 

					}
				}
			}
		} 
		
		// if Decrypt File Clicked 
		else if (event.getSource() == btnDecryptFile) {
			String filePath = txtInputFile.getText(); //set txtInputFile as string called filePath
			if (!filePath.isEmpty()) { //if the file is not empty then the program reads file and decrypts 
				String[] fileContent = null; // Initialize new variable fileContent to nul
				try { //Try and Catch Added To Catch any Error occuring when File is being read 
					fileContent = TheFileAccess.readFile(filePath); // reads the file using readFile class in TheFileAccess Class
				} catch (IOException e) {  // NOT SURE WHAT TO WRITE HERE
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (fileContent.length > 0) { //if the content in the file is greater than 0 the program runs 
					int decryptKey = getKey(fileContent[0]); // gets the encrypt key from top of file 
					if (checkKey(decryptKey)) { // checks if the key from the file fits the mandatory range 
						decryptKey = putKeyInRange(decryptKey);  //runs through the putKeyInRange method to go through % 26 and determine movement/range
						String decryptedFileContent = ""; // sets string called decryptedFileContent
						for (int i = 1; i < fileContent.length; i++) { //for loop and runs through the entire file phrases
							String line = fileContent[i];  // sets string called line and has the fileContent at i 
							char[] lineChars = line.toCharArray(); // set the char variable and check characters in string
							for (int j = 0; j < lineChars.length; j++) { // goes through the line and its characters 
								char letter = lineChars[j]; // letters at the lineChars[j]
								decryptedFileContent += Encryption.decrypt(letter, decryptKey); //encrypts the letter at that location calling encryption class
							}
							decryptedFileContent += "\n"; // adds new/next line after the decryptedFileContent
						}
						txtOutput.setText(decryptKey + "\n" + decryptedFileContent); //display the decrypted data plus the key
						
						//display the data in the file output box using String.join which returns a new String composed of 
						//copies of the CharSequence elements joined together with a specified delimiter
						//which in this case was the \n which was learned in a lab 
						txtFileOutput.setText(String.join("\n", fileContent)); //display the data in the file output box
					} else {
						JOptionPane.showMessageDialog(this, "Invalid decryption key (Enter Value: -32768 to 32768)"); 
					}
				}
			}
		} 
		//if save button is clicked 
		else if (event.getSource() == btnSave) {
			//enter the file name you want to be saved 
			String enteredFile = JOptionPane.showInputDialog(this, "Please Enter the Name of The File You Would Like to Save (ex. AfterEncrypt.txt)");
			if (enteredFile != null && !enteredFile.isEmpty()) { //if the file name is not empty or null the program saves the data to file 
				try {
					String fileData = txtOutput.getText(); //turns txt.Output to string called fileData
					
					//write to file and splits the code where \n occurs which means after the \n delimiter 
					//the following string as not included in the resulting array and final saved file 
					TheFileAccess.writeToFile(enteredFile, fileData.split("\n"));  
					JOptionPane.showMessageDialog(this, "The File You Entered Has Now Been Saved!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "Error saving the file"); //error message when saving file
				}
			}   
		} 
		else if (event.getSource() == btnClear) { // clears all input and output boxes 
			txtInput.setText("");
			txtOutput.setText("");
			txtInputFile.setText("");
			txtInputKey.setText("");
			txtFileOutput.setText("");
		}
		else if (event.getSource() == btnExit) { // Completely exits the program 
			System.exit(0); //Initially terminates the running program 
		}

	}

	// method to get the get key 
	public static int getKey(String key) {
		if (key.isEmpty()) { // if nothing is entered in key input the value returned is 0
			return 0;
		}
		try {
			return Integer.parseInt(key); //return the key as a integer  
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	//SELF TESTING MAIN METHOD 
	public static void main(String[] args) {
		// call the UI
		new UI();

	}
}
