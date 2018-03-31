package for_try;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket client = new Socket("localhost", 9999);
		Scanner input = new Scanner(System.in);
		PrintStream out = new PrintStream(client.getOutputStream());
		Scanner scanner = new Scanner(client.getInputStream());
		scanner.useDelimiter("\n");
		input.useDelimiter("\n");
		boolean flag = true;
		while (flag) {
			String string = input.nextLine();
			out.println(string);
			if ("byebye".equalsIgnoreCase(string)) {
				flag = false;
			}
			if (scanner.hasNext()) {
				System.out.println(scanner.next());
			}

		}
		input.close();
		out.close();
		scanner.close();
		client.close();
	}
}
