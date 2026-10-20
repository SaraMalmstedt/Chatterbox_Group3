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
	// Tänkte också göra så här först, men frågan är ifall ett Message behöver veta allt om en User eller bara User.username?
	// Nu är jag lite petig men det kan bli trubbel ifall ett Message kan få tag i en User.Id tex
	private User author;
	/* Datumet då meddelanadet skrevs. */
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
