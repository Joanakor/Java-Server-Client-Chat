import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {
    public static void main(String[] args) {
        System.out.println("Starting server...");
        try {
            // Open ServerSocket on the port 3947
            ServerSocket serverSocket = new ServerSocket(3947);

            // Waiting fot the client to koin
            Socket server = serverSocket.accept();
            System.out.println("Connection established!");

            // Reader for getting messages from the socket stream
            BufferedReader messageReader = new BufferedReader(new InputStreamReader(server.getInputStream()));

            // Reader for typing messages from the keyboard
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Writer to print messages to the connected client
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            System.out.println("Send messages to the client: ");

            // The thread which listens for the messages

            MessageListener listener = new MessageListener(messageReader);
            Thread listenThread = new Thread(listener);
            listenThread.setDaemon(true);
            listenThread.start();

            // Constant user input
            while(true)
            {
                String input = userInput.readLine();
                if (input.compareTo("EXIT") == 0)
                {
                    break;
                }
                out.println(input);
            }

            // Close the sockets after the end of the work
            server.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
