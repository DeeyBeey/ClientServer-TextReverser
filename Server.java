import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server class that receives a String from the client and reverses it, along with the case
 * and sends it back to the client.
 */
public class Server {
    /**
     * Main method to start the server
     * @param args command-line arguments, expects one argument: port number.
     */
    public static void main(String[] args) {
        // validate arguments
        if (args.length != 1) {
            System.out.println("Sample usage: java Server <portNumber>");
            return;
        }

        int port = Integer.parseInt(args[0]);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Waiting for client on port " + port);

            // receive meessage from client
            try (Socket server = serverSocket.accept()) {
                System.out.println("Connection established with " + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                String fromClient = in.readUTF();
                System.out.println("Received from client: " + fromClient);

                // reverse the string and case of string from client
                String reversedString = reverseString(fromClient);

                // send the processed string back to client
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF(reversedString);
                System.out.println("Dispatched to client: " + reversedString);
            }
        } catch (Exception e) {
            // handle Exceptions
            e.printStackTrace();
        }
    }

    /**
     * Helper function to reverse the string and toggle the case of each character.
     * @param input the input string to be processed.
     * @return the processed string with reversed characters and toggled case.
     */
    private static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder(input).reverse();
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            if (Character.isUpperCase(c)) {
                reversed.setCharAt(i, Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                reversed.setCharAt(i, Character.toUpperCase(c));
            }
        }

        return reversed.toString();
    }
}
