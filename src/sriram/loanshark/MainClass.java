package sriram.loanshark;


import java.util.ArrayList; // Array lists
import java.util.Scanner; // Scanners
import java.io.*; // File IO 



 

public class MainClass {
	
	static FileOutputStream fos;
	static DataOutputStream dos;

	
	static ArrayList<Person> personlist = new ArrayList<Person>(); // Create the array to
																   // hold the people
	/**
	 * Adds person to array
	 * @param newPerson Name of the Person object to be added to array
	 */
	public static void array(Person newPerson){ // method to add a person to the array
		
		personlist.add(newPerson);
		
	}
	
	
	
	public static void refreshtxt() throws IOException{
		    File oldFile = new File("test.txt");
			oldFile.delete();
			File newFile = new File("test.txt");
			newFile.createNewFile();
		
	int x = 0;
		while(x < personlist.size())
		{
			fos = new FileOutputStream("test.txt");
			dos = new DataOutputStream(fos);
			
	        
	     
	       
	        dos.writeUTF(personlist.get(x).getName() + "\n");
	        dos.writeUTF(personlist.get(x).getBorrowed() + "\n");
	       		
			x++;
		}
	}
	
	public static void cleartxt() throws IOException
	{
		try{
			File fullFile = new File("test.txt");
			fullFile.delete();
			File emptyFile = new File("test.txt");
			emptyFile.createNewFile();
		} catch(FileNotFoundException e){
			System.err.println("FileNotFoundException:" + e.getMessage());
		}
		  catch(IOException e){
			  System.err.println("IOException:" + e.getMessage());
		  }
	}
	
	
	
	/**
	 * Whole program runs from here
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	
	
	
	public static void main (String [] args) throws InterruptedException, IOException{
		
// Main function
		refreshtxt();
		// Opens FILE
		File inFile = new File("test.txt");
		if (inFile.exists())
		{
			System.out.println("File Exists!"); // Testing if file exists
		}
		else
			System.out.println("No File Found");
			
		
		 Scanner fileScanner = new Scanner(inFile);
		 
		 
		// Writes all file elements to array
		while(fileScanner.hasNext()) //While there is a next line, create a new person
		{
			String unparsedname, name = "";
			double borrowed = 0.00;
			
			unparsedname = fileScanner.nextLine();
			name = unparsedname.substring(2); // because UTF writing causes 2 weird chars in front of string
			borrowed = Double.parseDouble(fileScanner.nextLine()); // change the text version of the num to an int
	
			Person newPerson = new Person(name,borrowed); // creating of the new person
			array(newPerson);
		
		}
		
		
		
	
		
		int exitflag = 0;
		// Keeps printing the menu
		while (exitflag == 0) // Carries on with program until exit is called
		{
			System.out.println("Menu: \n1: Add more names\n2: View current borrowers\n3: Delete borrower\n4: Update Name Of Borrower\n5: Update borrowed amount\n6: Exit Program\nType in number to select(1,2,3,4,5, or 6)");
			Scanner choice = new Scanner(System.in);
	   int choicenextline = choice.nextInt(); // variable to store choice y/n
	  
			if (choicenextline == 1)
			{ // If yes, make new person
		
			 String name;
			    double borrowed;
				Scanner input = new Scanner(System.in);
				System.out.println("Enter First Name");
				name = input.nextLine();
				System.out.println("Enter Amount Borrowed in $");
				borrowed = input.nextDouble();
				Person newPerson = new Person(name, borrowed);
				array(newPerson);
				System.out.println("New Person Created!");
				refreshtxt();
			}
			
			
			
			
		 if (choicenextline ==  2)
			{ 
				if (personlist.isEmpty() == false ) // If the person list is not empty
				{
				
					System.out.println("Viewing Current Borrowers..."); // view all Persons
					
					Thread.sleep(2000);
		
						for(int i = 0; i < personlist.size(); i++) //cars name of arraylist
					{
							System.out.print("Person Number : " + i );
							System.out.print("\n" + personlist.get(i).getName() + " borrowed :" + "\n");
							System.out.print("$" + personlist.get(i).getBorrowed() + "\n\n");
				
					}
						
						
						
				}
						
				else 
					System.out.println("Noone has borrowed money from you"); // if list is empty
				
			}
		 
		 if (choicenextline == 3)
		 {
			 try{
				    
				    FileWriter fstream = new FileWriter(inFile,true);
				        BufferedWriter out = new BufferedWriter(fstream);
				        for(int i = 0; i < personlist.size(); i++) 
						{
								System.out.print("Person Number : " + i );
								System.out.print("\n" + personlist.get(i).getName() + " borrowed :" + "\n");
								System.out.print("$" + personlist.get(i).getBorrowed() + "\n\n");
					
						}
				        
				        System.out.println("Choose Person Number to delete e.g. 1, or 2");
				        Scanner choosenum = new Scanner(System.in);
				        int Choice = choosenum.nextInt();
				        personlist.remove(Choice);
				        refreshtxt();
				        
				        
				        
				    out.close();
				    }catch (Exception e){//Catch exception if any
				      System.err.println("Error: " + e.getMessage());
				    }
			}
		 
		 if (choicenextline == 4){
			 refreshtxt();
			 Scanner newIndex = new Scanner(System.in);
			 Scanner newUpdate = new Scanner(System.in);
			
			 for(int i = 0; i < personlist.size(); i++) 
				{
						System.out.print("Person Number : " + i );
						System.out.print("\n" + personlist.get(i).getName() + " borrowed :" + "\n");
						System.out.print("$" + personlist.get(i).getBorrowed() + "\n\n");
			
				}
			 
			 System.out.println("Choose Number of Person to Update Name");
			 int index;
			 String updateName;
			 index = newIndex.nextInt();
        	 System.out.print("Change name " + personlist.get(index).getName() + " to what name?\n" );
        	 updateName = newUpdate.nextLine();
        	 personlist.get(index).setName(updateName);
        	 refreshtxt();
			 
		 }
		 
		 if (choicenextline == 5){
			 refreshtxt();
			 Scanner newIndex = new Scanner(System.in);
			 Scanner newBorrow = new Scanner(System.in);
			
			 for(int i = 0; i < personlist.size(); i++) 
				{
						System.out.print("Person Number : " + i );
						System.out.print("\n" + personlist.get(i).getName() + " borrowed :" + "\n");
						System.out.print("$" + personlist.get(i).getBorrowed() + "\n\n");
			
				}
			 
			 System.out.println("Choose Number of Person to Update Borrowed Amount");
			 int index;
			 double newUpdate;
			 index = newIndex.nextInt();
        	 System.out.print("Change borrowed amount " + personlist.get(index).getBorrowed() + " to what amount?\n" );
        	 newUpdate = newBorrow.nextDouble();
        	 personlist.get(index).setBorrowed(newUpdate);
        	 refreshtxt();
		 }
		 
		 if (choicenextline == 6)
		 {
			 System.out.print("Exiting.");
			 Thread.sleep(600);
			 System.out.print(".");
			 Thread.sleep(600);
			 System.out.print(".");
			 Thread.sleep(600);
			 System.out.print(".");
			 Thread.sleep(600);
			 System.out.print(".");
			 Thread.sleep(600);
			 System.out.print(".");
			 Thread.sleep(600);
			 System.out.print(".");
			 refreshtxt();
			
			 System.exit(0);
		 }
		 
		
		}// End of menu repeating function
	}// End of main function
			
			
		
	   
		
		
		
		
	}// End of CLASS
	



