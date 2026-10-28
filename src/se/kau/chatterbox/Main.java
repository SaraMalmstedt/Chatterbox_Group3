package se.kau.chatterbox;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

	public static void displayStartMenu() {

	}

	public static void main(String[] args) {

		// Creates an AppController and saves it in the variable controller 
		AppController controller = new AppController();
		// Creates a UserView and hands controller over to its constuctir 
		UserView userView = new UserView(controller);
		// Creates a GuestView and hands controller over to its constructur
		GuestView guestView = new GuestView(controller);

		// Test for User
		User sara = new User(1, "Sara", "password");
		controller.addUser(sara);
		System.out.println(sara.getUsername() + " " + sara.getPassword());

		// Test for message
		Message test = new Message(1, "This is a test", sara, LocalDate.now());
		System.out.println(test.getAuthor().getUsername() + ": " + test.getContent() + " " + test.getCreatedAt());
		
		//Test for FileHandler
		FileHandler fileHandler = new FileHandler();
		//fileHandler.createNewDefaultFile();
	}
}
