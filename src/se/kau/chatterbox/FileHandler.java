package se.kau.chatterbox;

import java.util.ArrayList;

public class FileHandler {

	private String fileName = "messages.csv";
	
	public ArrayList<Message> loadMessages(ArrayList<User> users) {
	return new ArrayList<>();
	}
	
	public boolean saveMessages(ArrayList<Message> messages) {
		return false;
	}
	
}
