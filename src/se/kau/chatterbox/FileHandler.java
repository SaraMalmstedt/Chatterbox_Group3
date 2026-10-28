package se.kau.chatterbox;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.*;

public class FileHandler {
	private String fileName = "messages.csv";
	private PrintWriter writer = null;
	private Scanner input = null;
	
	public FileHandler() {
	}
	
	public void createNewDefaultFile() {
		try {
			writer = new PrintWriter(new FileWriter(fileName, true));
			//Header
			writer.println("Id\tUsername\tCreated at\tContent");
			//Default content
			writer.println("1\tmartin123\t" + LocalDate.now() + "\tFirst!!!");
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
	
	public ArrayList<Message> testLoadAll(AppController controller){
		ArrayList<Message> messages = new ArrayList<Message>();
		try {
			input = new Scanner(new File(fileName));
			int c = 0;
			while (input.hasNextLine()) {
				String line = input.nextLine();
				System.out.println(line);
				//Skippa header, men den printar den fortfarande
				if (c == 0) {c++; continue;}
				String[] toks = line.split("\t");
				int id = Integer.parseInt(toks[0].trim()); 
				String username = toks[1].trim();
				LocalDate createdAt = LocalDate.parse(toks[2].trim());
				String content = toks[3].trim();
				User user = null;
				if(controller.isUsernameInList(username)) {					
					user = controller.getUserByUsername(username);
				}
				Message message = new Message(id, content, user, createdAt);
				messages.add(message);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return messages;
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
				
				//testutskrift, ta bort sen
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
