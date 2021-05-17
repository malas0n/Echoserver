import java.net.*;
import java.io.*;

public class EchoServer {

	public static void main(String[] args) {
	
		System.out.println("Client Status: Operation");
		try(ServerSocket sock = new ServerSocket(6013)){
			while(true) {
				Socket client = sock.accept();
				System.out.println("cLient is now connected");
				BufferedReader bin = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter spout = new PrintWriter(client.getOutputStream(),true);
				String line;
				while ((line=bin.readLine()) !=null) {
					System.out.println("Client says:"+line);
					spout.println(line);
					
				}
				sock.close();
			}
		}catch (IOException e) {
			System.err.println(e);
		}

	}

}
