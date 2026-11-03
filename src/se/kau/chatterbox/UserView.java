package se.kau.chatterbox;

import java.util.ArrayList;
import java.util.Scanner;

public class UserView {
	private AppController controller;
	private Scanner scanner;

	// Constructur
	public UserView(AppController controller, Scanner scanner) {
		this.controller = controller;
		this.scanner = scanner;
	}

	public boolean displayLogin() {
		System.out.println("--- Login ---");

		System.out.print("Username: ");
		String username = scanner.nextLine();

		System.out.print("Password: ");
		String password = scanner.nextLine();

		boolean success = controller.login(username, password);

		if (success) {
			System.out.println("Login successful!");
		} else {
			System.out.println("Invalid username or password.");
		}

		return success;

	}

	public void displayMenu() {

		boolean running = true;
		while (running) {
			System.out.println("\n--- ChatterBox User Menu ---");

			System.out.println("1. View all messages");
			System.out.println("2. View my messages");
			System.out.println("3. Post message");
			System.out.println("4. Delete message");
			System.out.println("5. Back to start menu");

			System.out.print("Choose an option: ");
			String choice = scanner.nextLine();

			switch (choice) {

			case "1":
				displayAllMessages();
				break;

			case "2":
				displayOwnMessages();
				break;

			case "3":
				displayPostMessage();
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

		ArrayList<Message> messages = controller.getOwnMessages();

		System.out.println("\n--- My Messages ---");

		if (messages.isEmpty()) {
			System.out.println("You have not posted any messages");
			return;
		}

		for (Message message : messages) {
			System.out.println("Message ID: " + message.getMessageId());
			System.out.println("Author: " + message.getAuthor().getUsername());
			System.out.println("Date: " + message.getCreatedAt());
			System.out.println("Message: " + message.getContent());
			System.out.println("----------------------------");
		}

	}

	public void displayAllMessages() {

		ArrayList<Message> messages = controller.getAllMessages();

		System.out.println("\n--- All Messages ---");

		if (messages.isEmpty()) {
			System.out.println("No messages available.");
			return;
		}

		for (Message message : messages) {

			System.out.println("Message ID: " + message.getMessageId());
			System.out.println("Author: " + message.getAuthor().getUsername());
			System.out.println("Date: " + message.getCreatedAt());
			System.out.println("Message: " + message.getContent());
			System.out.println("----------------------------");
		}
	}

	public void displayPostMessage() {

		System.out.println("\n--- Post Message ---");

		System.out.print("Write your message: ");
		String content = scanner.nextLine();

		boolean success = controller.postMessage(content);

		if (success) {
			System.out.println("Message posted successfully!");
		} else {
			System.out.println("Could not post message.");
		}

	}

	public void displayDeleteMessage() {

		System.out.println("\n--- Delete Message ---");

		displayOwnMessages();

		System.out.print("Enter message ID to delete: ");
		String input = scanner.nextLine();

		try {

			int messageId = Integer.parseInt(input);

			boolean success = controller.deleteMessage(messageId);

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
