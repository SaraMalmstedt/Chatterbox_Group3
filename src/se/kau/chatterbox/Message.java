package se.kau.chatterbox;

import java.time.LocalDate;

public class Message {
	// Satte attributen som private
	private int messageId;
	private String content;
	/*
	 * Association, vem som skapar meddelandet refererar till objektet User som
	 * skrev meddelandet
	 */
	private User author;
	private LocalDate createdAt;

	public Message(int messageId, String content, User author, LocalDate createdAt) {
		this.messageId = messageId;
		this.content = content;
		this.author = author;

		/*
		 * Ändrat från LocalDate.now() För då hade alla meddelandet fått dagens datum
		 * varje gång filen läses in
		 */
		this.createdAt = createdAt;
	}

	public int getMessageId() {
		return messageId;
	}

	public String getContent() {
		return content;
	}

	public User getAuthor() {
		return author;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}
}
