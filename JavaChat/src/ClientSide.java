import java.io.*;
import java.net.Socket;

public class ClientSide {
    public static void main(String[] args) {
        System.out.println("Client started!");
        try {
            // Open client socket in the same port as the server
            Socket client = new Socket("localhost", 3947);

            // Reader for typing messages from the keyboard
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Reader for getting messages from the socket stream
            BufferedReader messageReader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            // Writer to print messages to the server
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            System.out.println("Send messages to the server: ");

            // TODO Make the separate thread which will listen for the messages

            MessageListener listener = new MessageListener(messageReader);
            Thread listenThread = new Thread(listener);
            listenThread.setDaemon(true);
            listenThread.start();

            while(true)
            {
                String input = userInput.readLine();
                if (input.compareTo("EXIT") == 0)
                {
                    break;
                }
                out.println(input);
            }

            // Close the socket after the end of the work
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
