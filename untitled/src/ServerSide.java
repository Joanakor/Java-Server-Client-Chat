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
            ServerSocket serverSocket = new ServerSocket(3947);
            Socket server = serverSocket.accept();
            System.out.println("Connection established!");
            BufferedReader get = new BufferedReader(new InputStreamReader(server.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            System.out.println("Send a message to the client: ");
            while(true)
            {
                String input = userInput.readLine();
                if (input.compareTo("EXIT") == 0)
                {
                    break;
                }
                out.println(input);
                String answer = get.readLine();
                System.out.println(answer);
            }
            server.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
