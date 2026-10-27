package se.kau.chatterbox;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class FileHandler {

	private String fileName = "messages.csv";
	private PrintWriter writer = null;
	private Scanner input = null;
	
	public FileHandler() {
	}
	
	private void createNewDefaultFile() {
		try {
			writer = new PrintWriter(new FileWriter(fileName, true));
			//Header
			writer.println("Id\tUsername\tCreated at\tContent");
			//Default content
			writer.println("1\tmartin123\tIdag\tFirst!!!");
			System.out.println("FileHandler default skriven.");
			writer.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void printAllFiles() {
		try {
			input = new Scanner(new File(fileName));
			while(input.hasNextLine()) {
				String line = input.nextLine();
				System.out.println(line);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Message> loadMessages(ArrayList<User> users) {
		return new ArrayList<>();
	}
	
	public boolean saveMessages(ArrayList<Message> messages) {
		if(messages.isEmpty()) {
			return false;
		}
		
		try {
			writer = new PrintWriter(new FileWriter(fileName, true));
			for(Message message : messages) {
				writer.println(message.getMessageId() + "\t" 
								+ message.getAuthor() + "\t" 
								+ message.getCreatedAt() + "\t"
								+ message.getContent());
				
				//testutskrift, ta bort
				System.out.println("Skriver till CSV:");
				System.out.println(message.getMessageId() + "\t" 
						+ message.getAuthor() + "\t" 
						+ message.getCreatedAt() + "\t"
						+ message.getContent());
			}
			writer.close();
		} catch(IOException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
}
