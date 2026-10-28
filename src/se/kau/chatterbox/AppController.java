package se.kau.chatterbox;

import java.time.LocalDate;
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
		users = new ArrayList<User>();
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

	// Method that creates a new message from the logged-in user and saves it
	// Returns true if it was saved, or false if the message is empty or saving
	// failed
	public boolean postMessage(String content) {
		// Return false if no one is logged in or content is empty
		if (currentUser == null || content.isEmpty()) {
			return false;
		}

		// Creates a variable to save the highest id so far
		int highestId = 0;

		// Loops through all messages and and finds the higest IDs
		for (int i = 0; i < messages.size(); i++) {
			int currentMessageId = messages.get(i).getMessageId();
			if (currentMessageId > highestId) {
				highestId = currentMessageId;
			}

		}
		// Creates a new Id that is 1 higher than the highest Id in in list
		int newId = highestId + 1;

		// Creates the new message with all parameters
		Message newMessage = new Message(newId, content, currentUser, LocalDate.now());

		// Adds the new message to the ArrayList of messages
		messages.add(newMessage);

		// Create a variable named "saved" that stores the answer from FileHandler (true
		// or
		// false)
		boolean saved = fileHandler.saveMessages(messages);
		return saved;

	}

	// Method that deletes a messsage if it belongs t the logged- in user. Returns
	// true if it was deleted and saved.
	public boolean deleteMessage(int messageId) {
		// Returns false if no one is logged in
		if (currentUser == null) {
			return false;
		}
		// Loops through all messages to find the one with the given id
		for (int i = 0; i < messages.size(); i++) {
			int currentMessageId = messages.get(i).getMessageId();

			if (currentMessageId == messageId) {
				// Saves the name of the user who wrote the message in position i
				String authorUsername = messages.get(i).getAuthor().getUsername();
				// Saves the name of the user currently logged in
				String currentUsername = currentUser.getUsername();
				// If they are not the same, return false (deletion cannot happen)
				if (!authorUsername.equals(currentUsername)) {
					return false;
				} else {
					// Delete message at position i
					messages.remove(i);
					// Create a variable named "saved" that stores the answer from FileHandler (true
					// or false)
					boolean saved = fileHandler.saveMessages(messages);
					return saved;
				}
			}

		}
		// No message with that id was found
		return false;
	}

}
