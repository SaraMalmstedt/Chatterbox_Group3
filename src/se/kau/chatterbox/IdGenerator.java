package se.kau.chatterbox;

import java.util.ArrayList;

public class IdGenerator {
	int nextUserId;
	int nextMessageId;
	
	public IdGenerator() {
		nextUserId = 0;
		nextMessageId = 0;
	}
	
	private void incrementUserId() {
		nextUserId++;
	}
	private void incrementMessageId() {
		nextMessageId++;
	}
 	
 	public int getNewUserId() {
 		incrementUserId();
 		return nextUserId;
 	}
 	
 	public int getNewMessageId() {
 		incrementMessageId();
 		return nextMessageId;
 	}
}