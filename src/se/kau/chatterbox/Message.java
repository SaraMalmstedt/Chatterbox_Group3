package se.kau.chatterbox;

import java.time.LocalDate;

public class Message {
	int id;
	String content;
	String author;
	LocalDate createdAt;
	
	public Message(String content, String author) {
		this.content = content;
		this.author = author;
		createdAt = LocalDate.now();
	}
	
	public String getContent() {
		return content;
	}
	
	public String getAuthor() {
		return author;
	}
}
