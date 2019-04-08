package ie.gmit.sw;

import java.io.Console;
import java.io.File;
import java.util.Scanner;

public class UserInputMenu {

		static Scanner console = new Scanner(System.in);
	
		private static String dictionaryFileName;
		private static String ignoreWordsFileName;
		
		public UserInputMenu(String dictionaryName, String ignoreWords) {
			setDictionaryFileName(dictionaryName);
			setIgnoreWordsFileName(ignoreWords);
		}
		
		public UserInputMenu() {
			super();
		}
		public static String getDictionaryFile()
		{
			if(dictionaryFileName.isEmpty())
			{
				System.out.println("Please Enter Dictionary File Name: ");
			}
			else {
				return dictionaryFileName;
			}
			return dictionaryFileName;
		}


		private static void setDictionaryFileName(String dictionaryFilesName) {
			// TODO Auto-generated method stub
			UserInputMenu.dictionaryFileName = dictionaryFilesName;
			
		}
		public static String getIgnoreWordsFileName() {
			if(ignoreWordsFileName.isEmpty()) {
				System.out.println("Please Enter the Ignore Words File: ");
			}
			else
			{
				return ignoreWordsFileName;
			}
			return ignoreWordsFileName;
		}
		private static void setIgnoreWordsFileName(String ignoreName) {
			// TODO Auto-generated method stub
			UserInputMenu.ignoreWordsFileName = ignoreName;
			
		}
		
		public static void userScannerInputs() {
		String workingDirectory = System.getProperty("user.dir");
		File workingDirectoryFile = new File(workingDirectory);
		
		int i =0;
		while (i==0) {
			System.out.println("Please Enter Your Dictionary File Name: ");
			dictionaryFileName = console.nextLine();
			
			File testFile1 = new File(workingDirectoryFile, dictionaryFileName);

			
			System.out.println("Please Enter Your Ignore Words File Name: ");
			ignoreWordsFileName = console.nextLine();
			
			File testFile2 = new File(workingDirectoryFile, ignoreWordsFileName);

			
			if( !(dictionaryFileName.isEmpty()|| ignoreWordsFileName.isEmpty())){
				
				if (testFile1.exists() && testFile2.exists()) {
					
					new UserInputMenu(dictionaryFileName, ignoreWordsFileName);
			
					i = 1;
				} 
				else
				{
					System.out.println("You have entered the wrong File Names... \nPlease try again...");
				}
				
			}
			else
			{
				System.out.println("Please type file names");
			}
		}
	}
	
	public static void main(String[] args) throws Throwable {
		
		userScannerInputs();
		
		RareWords words =new RareWords();
		words.createSpecialWords();
	}
		
	

}
