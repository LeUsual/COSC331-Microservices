import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class service {
	
	private static String readCSS() {
		// TODO: Read the CSS template file, and return the contents
		// Implement the minification here as well
	}
	
	private static String substituteCSS(String css, String accentC, String mainC, String font) {
		// TODO: Take a CSS template plus three parameters in
		// It should replace the placeholders in the templace with the passed in parameter values
	}
	
	private static String verifyHex(String rawInput, String defaultValue) {
		// TODO: Verify the input value rawInput is actually a hex value with an appropriate length
	}
	
	private static String verifyFont(String fontInput, String defaultValue) {
		// TODO: Implement a verification function that checks if fontInput is equal to either:
		// "serif", "sans-serif", or "monospace", or returns a default value if not
		// Don't forget about capitalization!
	}
	
	public static void webServe(int port) throws IOException {
		// TODO: You'll need most of your functions to run in the server loop here
		// To get you started, this code will fetch input, print it to the console
		// and then return a message to the user
		ServerSocket server = new ServerSocket(port);
		while(true) {
			// server.accept() is blocking, so your code will stop here until a connection is made
			Socket userConn = server.accept();
			// Buffered Reader for handling the input stream from the user/client
			BufferedReader br = new BufferedReader(new InputStreamReader(userConn.getInputStream()), 1);
			String output = "";
			String line;
			// Read from the buffer until the buffer is empty or the connection closes
			while ((line = br.readLine()) != null) {
	            output = output + line;
	            if (line.isEmpty()) {
	                break;
	            }
	        }
			// Print out the input from the user/client
			System.out.println(output);
			// Writing our response message - note that the headers must end in \r\n\r\n
			// The message itself should come after the headers, and should end in \r\n
			String helloWorld = "Hello World, This is my response message!\r\n";
			String response = "HTTP/1.1 200 OK\r\n\r\n" + helloWorld;
			// Write the HTTP message out to the output stream, back to the client/user
			userConn.getOutputStream().write(response.getBytes("UTF-8"));
			userConn.getOutputStream().flush();
			// Flush to make sure the data is sent, and then close the connection and the buffered reader
			userConn.close();
			br.close();
		}
	}
	
	public static String parseHeader(String variable, String rawInput) {
		// TODO: Write the basic parser needed to fetch our a parameter (variable)
		// from the client/user rawInput, and then return it
	}
	
	public static void main(String[] args) throws IOException {
		// Begins the webserver on the specified port (Port 80 by default)
		webServe(80);
	}
	
}