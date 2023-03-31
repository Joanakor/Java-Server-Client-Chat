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
            String answer = get.readLine();
            System.out.println(answer);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Send a message to the client: ");
            String input = userInput.readLine();
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            out.println(input);
            server.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
