package se.kau.chatterbox;

import java.util.ArrayList;

public class AppController {

	private ArrayList<User> users;
	private ArrayList<Message> messages;
	private User currentUser;
	private FileHandler fileHandler;
	
	public AppController() {
		
	}
	public boolean login(String username, String password) {
		return false;
	}
	
	public boolean postMessage(String content) {
		return false;
	}
	
	public boolean deleteMessage( int messageId) {
		return false;
	}
	
	public ArrayList<Message> getOwnMessages() {
		return new ArrayList<>();
	}
	
 	public ArrayList<Message> getAllMessages() {
 		return new ArrayList<>();
 	}
	
}
