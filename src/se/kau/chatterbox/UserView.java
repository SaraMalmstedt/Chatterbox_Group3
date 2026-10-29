package se.kau.chatterbox;

import java.util.ArrayList;
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
	        running = false; 
	        break;

	    default:
	        System.out.println("Invalid option. Try again.");
	   
	    	}
	    }
	}

	public void displayOwnMessages() {
		
		// hämtar meddelanden från Appcontroller
	    ArrayList<Message> messages = controller.getOwnMessages();
	    
	    System.out.println("\n--- My Messages ---");
	    
	    
	    if (messages.isEmpty()) {
	        System.out.println("You have not posted any messages");
	        return;
	    }
	    
	    // visar varje message
	    for (Message message : messages) {
	            System.out.println("Message ID: " + message.getMessageId());
	            System.out.println("Author: " + message.getAuthor().getUsername());
	            System.out.println("Date: " + message.getCreatedAt());
	            System.out.println("Message: " + message.getContent());
	            System.out.println("----------------------------");
	    }
	    
	}

	public void displayAllMessages() {
		// Hämtar alla meddelanden från AppController
	    ArrayList<Message> messages = controller.getAllMessages();

	    System.out.println("\n--- All Messages ---");

	    // Kontrollerar om listan är tom
	    if (messages.isEmpty()) {
	        System.out.println("No messages available.");
	        return;
	    }

	    // Visar alla meddelanden
	    for (Message message : messages) {

	        System.out.println("Message ID: " + message.getMessageId());
	        System.out.println("Author: " + message.getAuthor().getUsername());
	        System.out.println("Date: " + message.getCreatedAt());
	        System.out.println("Message: " + message.getContent());
	        System.out.println("----------------------------");
	    }
	}

	public void displaypostMessage() {
		   // Visar rubrik
	    System.out.println("\n--- Post Message ---");

	    // Ber användaren skriva ett meddelande
	    System.out.print("Write your message: ");
	    String content = scanner.nextLine();

	    // Skickar meddelandet till AppController
	    boolean success = controller.postMessage(content);

	    // Visar om meddelandet postades eller inte
	    if (success) {
	        System.out.println("Message posted successfully!");
	    } else {
	        System.out.println("Could not post message.");
	    }

	}

	public void displayDeleteMessage() {
		// Visar rubrik
	    System.out.println("\n--- Delete Message ---");

	    // Visar användarens egna meddelanden
	    displayOwnMessages();

	    // Ber användaren välja meddelande
	    System.out.print("Enter message ID to delete: ");
	    String input = scanner.nextLine();

	    try {

	        // Omvandlar text till heltal
	        int messageId = Integer.parseInt(input);

	        // Skickar ID till AppController
	        boolean success = controller.deleteMessage(messageId);

	        // Visar resultatet
	        if (success) {
	            System.out.println("Message deleted successfully!");
	        } else {
	            System.out.println("Could not delete message.");
	        }

	    } catch (NumberFormatException e) {

	        System.out.println("Invalid message ID. Please enter a number.");

	    }

	}

}
