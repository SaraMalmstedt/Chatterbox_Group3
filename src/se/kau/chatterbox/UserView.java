package se.kau.chatterbox;

import java.util.Scanner;

public class UserView {
	private AppController controller;
	private Scanner scanner;
	
	//Constructur
	public UserView(AppController controller) {
		this.controller = controller;
		this.scanner = new Scanner(System.in);
	}

	public boolean displayLogin() {
		return false;
	}

	public void displayMenu() {

	}

	public void displayOwnMessages() {
	}

	public void displayAllMessages() {

	}

	public void displaypostMessage() {

	}

	public void displayDeleteMessage() {

	}

}
