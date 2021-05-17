import java.net.*;
import java.io.*;

public class EchoClient {

	public static void main(String[] args) {
		String line;
		
		System.out.println("Client Status: Operation");
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		try {
			Socket sock = new Socket("127.0.0.1",6013);
			PrintWriter cpout = new PrintWriter(sock.getOutputStream(),true);
			BufferedReader bin = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
			System.out.println("connected to server");
			while(true) {
				System.out.println("enter text");
				line = scan.readLine();
				if("exit".equalsIgnoreCase(line))
					break;
				cpout.println(line);
				String echo = bin.readLine();
				System.out.println("You sent: "+echo);
				
			}
			sock.close();
			
			
		}catch (IOException e) {
			System.err.println(e);
		}
	}

}
