package basetest.console;

import java.io.Console;

public class ConsoleTest {
	
	public static void main(String...args) {
		Console console = System.console();
		for(int x = 0; x < 5; x++) {
			console.printf("%d", x);
		}
	}

}
