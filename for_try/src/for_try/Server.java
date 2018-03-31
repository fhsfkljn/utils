package for_try;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9999);
		System.out.println("µÈ´ýÁ¬½Ó.........");
		Socket client = serverSocket.accept();
		Scanner scanner = new Scanner(client.getInputStream());
		PrintStream out = new PrintStream(client.getOutputStream());
		scanner.useDelimiter("\n");
		boolean flag = true;
		while (flag) {
			if (scanner.hasNext()) {
				String string = scanner.next().trim();
				if (string.equalsIgnoreCase("quit")) {
					out.println("byebye!");
					flag = false;
				} else {
					out.println("echo:" + string);
				}
			}
		}
		scanner.close();
		out.close();
		client.close();
		serverSocket.close();
	}
}
