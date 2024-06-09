import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client class to send a string to a server, receive a processed response, and 
 * display the response.
 */

public class Client {
    /**
     * Main method to start the client.
     * @param args command-line arguments, expects two arguments: server IP and port number.
     */
    public static void main(String[] args) {
        // validate arguments
        if (args.length != 2) {
            System.out.println("Sample usage: java Client <serverIP> <portNumber>");
            return;
        }

        String serverName = args[0];
        int port = Integer.parseInt(args[1]);

        try (Socket client = new Socket(serverName, port)) {
            System.out.println("Connected to " + client.getRemoteSocketAddress());

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter text: (under 80 characters): ");
            String inputMessage = scanner.nextLine();

            // check if input exceeds 80 character length
            if (inputMessage.length() > 80) {
                scanner.close();
                System.out.println("Error: Input message exceeds 80 characters.");
                return;
            }

            // send input message to the server
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF(inputMessage);

            //receive processed response from the server
            DataInputStream in = new DataInputStream(client.getInputStream());
            String result = in.readUTF();
            System.out.println("Server response: " + result);
            scanner.close();
        } catch (Exception e) {
            // handle Exceptions
            e.printStackTrace();
        }
    }
}
