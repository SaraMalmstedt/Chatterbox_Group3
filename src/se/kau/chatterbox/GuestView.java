package se.kau.chatterbox;

import java.util.Scanner;
import java.util.ArrayList;

public class GuestView {

	private AppController controller;
	private Scanner scanner;
	
	public GuestView(AppController controller, Scanner scanner) {
		this.controller = controller;
	    this.scanner = scanner;
	}

	public void displayMenu() {
		
		String choice;
		
		
		do {
            System.out.println("===== GUEST MENU =====");
            System.out.println("1. View all messages");
            System.out.println("2. Back to main menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    displayAllMessages();
                    
                    System.out.println("Press Enter to return to the menu...");
                    scanner.nextLine();

                    break;

                case "2":
                    System.out.println("Returning to main menu");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }

        } while (!choice.equals("2"));
		
    }
	

	public void displayAllMessages() {

	    ArrayList<Message> messages = controller.getAllMessages();

	    if (messages.isEmpty()) {
	        System.out.println("No messages available.");
	    } else {
	        for (Message message : messages) {
	            System.out.println("Message ID: " + message.getMessageId());
	            System.out.println("Author: " + message.getAuthor().getUsername());
	            System.out.println("Date: " + message.getCreatedAt());
	            System.out.println("Message: " + message.getContent());
	            System.out.println("----------------------------");
	        }
	    }
	}
}


