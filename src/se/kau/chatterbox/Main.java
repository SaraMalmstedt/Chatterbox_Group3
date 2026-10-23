package se.kau.chatterbox;

import java.time.LocalDate;

public class Main {
	
	AppController controller = new AppController();
	UserView userView = new UserView();
	GuestView guestView = new GuestView();

	public static void displayStartMenu() {

	}

	public static void main(String[] args) {
		// Test for User
		User sara = new User(1, "Sara", "password");
		System.out.println(sara.getUsername() + " " + sara.getPassword());

		// Test for message
		Message test = new Message(1, "This is a test", sara, LocalDate.now());
		System.out.println(test.getAuthor().getUsername() + ": " + test.getContent() + " " + test.getCreatedAt());

	}

}
