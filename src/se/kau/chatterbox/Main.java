package se.kau.chatterbox;

public class Main {

	public static void main(String[] args) {
		// Test for User
		User sara = new User(1, "Sara", "password");
		System.out.println(sara.getUsername() + " " + sara.getPassword());

	}

}
