package se.kau.chatterbox;

public class TestAppController {

	public static void main(String[] args) {
		AppController controller = new AppController();
		
		// Test for login
		System.out.println("Fel lösenord(false) " + controller.login("sara123", "fellösenord"));
		System.out.println("Rätt lösenord (true) " + controller.login("sara123", "losenord1"));
		
	}

}
