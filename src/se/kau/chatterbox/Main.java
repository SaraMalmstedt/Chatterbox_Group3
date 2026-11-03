package se.kau.chatterbox;

import java.util.Scanner;

public class Main {

	public static void displayStartMenu(Scanner scanner, UserView userView, GuestView guestView) {

		String choice;

		while (true) {
			System.out.println("===== MAIN MENU =====");
			System.out.println("1. Log in");
			System.out.println("2. Continue as guest");
			System.out.print("Enter your choice: ");

			choice = scanner.nextLine();

			switch (choice) {

			case "1":
				if (userView.displayLogin()) {
					userView.displayMenu();
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
		UserView userView = new UserView(controller, scanner);
		// Creates a GuestView and hands controller over to its constructur
		GuestView guestView = new GuestView(controller, scanner);

		displayStartMenu(scanner, userView, guestView, controller);
	}
}
