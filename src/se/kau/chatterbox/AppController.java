package se.kau.chatterbox;

import java.util.ArrayList;

public class AppController {

	private ArrayList<User> users;
	private ArrayList<Message> messages;
	private User currentUser;
	private FileHandler fileHandler;

	// Constructur
	public AppController() {
		//Creates an empty list and fills it with users
		users = new ArrayList<>();
		users.add(new User(1, "sara123", "losenord1"));
		users.add(new User(2, "martin123", "losenord2"));
		users.add(new User(3, "linnea123", "losenord3"));
		users.add(new User(4, "pontus123", "losenord4"));

		fileHandler = new FileHandler();
		messages = fileHandler.loadMessages(users);
	}

	public boolean login(String username, String password) {
		return false;
	}

	public boolean postMessage(String content) {
		return false;
	}

	public boolean deleteMessage(int messageId) {
		return false;
	}

	public ArrayList<Message> getOwnMessages() {
		return new ArrayList<>();
	}

	public ArrayList<Message> getAllMessages() {
		return new ArrayList<>();
	}

}
