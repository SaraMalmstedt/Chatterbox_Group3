package se.kau.chatterbox;

import java.util.Scanner;

public class UserView {
	private AppController controller;
	private Scanner scanner;
	
	//Constructur
	public UserView(AppController controller) {
		this.controller = controller;
		this.scanner = new Scanner(System.in);
	}

	public boolean displayLogin() {
	    System.out.println("--- Login ---");
	   
	    //användarnamn
	    System.out.print("Username: ");
	    String username = scanner.nextLine();
	    
	    //lösenord
	    System.out.print("Password: ");
	    String password = scanner.nextLine();
	    
	    
	    boolean success = controller.login(username, password);
	    
	    if (success) {
	        System.out.println("Login successful!"); //om det är rätt inlogg
	    } else {
	        System.out.println("Invalid username or password."); //om det är fel inlogg
	    }

	    return success;

	   	    
	}
	
	

	public void displayMenu() {
	    
		boolean running = true;
	    while (running) {
	    System.out.println("\n--- ChatterBox User Menu ---");
	    
	    //olika alternativen  
	    System.out.println("1. View all messages");
	    System.out.println("2. View my messages");
	    System.out.println("3. Post message");
	    System.out.println("4. Delete message");
	    System.out.println("5. Back to start menu");
	    
	    System.out.print("Choose an option: ");
	    String choice = scanner.nextLine();

	    
	    //switch sats för de olika alternativen
	    switch (choice) {

	    case "1":
	        displayAllMessages();
	        break;

	    case "2":
	        displayOwnMessages();
	        break;

	    case "3":
	        displaypostMessage();
	        break;

	    case "4":
	        displayDeleteMessage();
	        break;

	    case "5":
	        System.out.println("Returning to start menu.");
	        break;

	    default:
	        System.out.println("Invalid option. Try again.");
	   
	    	}
	    }
	}

	public void displayOwnMessages() {
	}

	public void displayAllMessages() {

	}

	public void displaypostMessage() {

	}

	public void displayDeleteMessage() {

	}

}
