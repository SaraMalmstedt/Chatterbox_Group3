package se.kau.chatterbox;

import java.util.ArrayList;

public class AppController {

	private ArrayList<User> users;
	private ArrayList<Message> messages;
	private User currentUser;
	private FileHandler fileHandler;

	// Constructor
	public AppController() {
		// Creates an empty list and fills it with users
		users = new ArrayList<>();
		users.add(new User(1, "sara123", "losenord1"));
		users.add(new User(2, "martin123", "losenord2"));
		users.add(new User(3, "linnea123", "losenord3"));
		users.add(new User(4, "pontus123", "losenord4"));

		// Creates an instance of FileHandler and stores it in fileHandler
		fileHandler = new FileHandler();
		// Loads messages from the file. Each Message needs a User as author,
		// but the file only has the username, so users is used to find the right User.
		messages = fileHandler.loadMessages(users);
	}

	// Method that checks whether username and password are correct, and if so, sets
	// currentUser
	public boolean login(String username, String password) {
		// Loops through all users and checks the entered username and password against
		// each one
		for (int i = 0; i < users.size(); i++) {
			// Saves username and password for position i in vairables
			String thisUsername = users.get(i).getUsername();
			String thisPassword = users.get(i).getPassword();

			// if incoming username and password is correct..
			if (thisUsername.equals(username) && thisPassword.equals(password)) {

				// .. set currentUser as the user in position i
				currentUser = users.get(i);
				return true;

			}

		}
		// No user matched and login failed
		return false;
	}

	// Method that returns the list of all messages
	public ArrayList<Message> getAllMessages() {
		return messages;

	}

	// Method that returns the messages written by the logged-in user
	public ArrayList<Message> getOwnMessages() {
		// Creates an empty list to put the user's own messages in
		ArrayList<Message> ownMessage = new ArrayList<>();
		// If no one is logged in, the empty list is returned, so the program doesnt
		// crasch
		if (currentUser == null) {
			return ownMessage;
		}
		// Gets the name of the logged in user
		String currentUsername = currentUser.getUsername();
		// Loops through all messages
		for (int i = 0; i < messages.size(); i++) {
			// Gets the name of the user who wrote the message at position i
			String authorUsername = messages.get(i).getAuthor().getUsername();
			// If the logged in user is the one who wrote the message..
			if (authorUsername.equals(currentUsername)) {
				// The whole message is added to the list
				ownMessage.add(messages.get(i));
			}

		}
		// When all messages have been looped through, we return the list
		return ownMessage;

	}

	public boolean postMessage(String content) {
		return false;
	}

	public boolean deleteMessage(int messageId) {
		return false;
	}

}
