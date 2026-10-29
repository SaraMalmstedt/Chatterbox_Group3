package se.kau.chatterbox;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void displayStartMenu(Scanner scanner, UserView userView, GuestView guestView, AppController controller) {
		
		String choice;
		
		while (true) {
			System.out.println("===== MAIN MENU =====");
			System.out.println("1. Log in");
			System.out.println("2. Continue as guest");
			System.out.print("Enter your choice: ");
			
			
			choice = scanner.nextLine();
			
			switch (choice) {
			
			case "1":
				System.out.print("Enter username: ");
			    String username = scanner.nextLine();
	
			    System.out.print("Enter password: ");
			    String password = scanner.nextLine();
	
			    boolean success = controller.login(username, password);
	
			    if (success) {
			        System.out.println("Login successful!");
			        userView.displayMenu();
			    } else {
			        System.out.println("Invalid username or password!");
			    }
			    break;
				
				
			case "2":
				guestView.displayMenu();
				break;
				
			default:
				System.out.println("Invalid choice. Try again!");
				
			}
		}
	}

	public static void main(String[] args) {

		// Creates an AppController and saves it in the variable controller 
		AppController controller = new AppController();
		Scanner scanner = new Scanner(System.in);
		// Creates a UserView and hands controller over to its constuctir 
		UserView userView = new UserView(controller);
		// Creates a GuestView and hands controller over to its constructur
		GuestView guestView = new GuestView(controller, scanner);
		
		// Test for User
		User sara = new User(1, "Sara", "password");

		System.out.println(sara.getUsername() + " " + sara.getPassword());

		// Test for message
		Message test = new Message(1, "This is a test", sara, LocalDate.now());
		System.out.println(test.getAuthor().getUsername() + ": " + test.getContent() + " " + test.getCreatedAt());
		
		//Test for FileHandler
		FileHandler fileHandler = new FileHandler();
		//fileHandler.createNewDefaultFile();
		displayStartMenu(scanner, userView, guestView, controller);
	}
}
