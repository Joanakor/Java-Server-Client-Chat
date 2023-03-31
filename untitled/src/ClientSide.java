import java.io.*;
import java.net.Socket;

public class ClientSide {
    public static void main(String[] args) {
        System.out.println("Client started!");
        try {
            Socket client = new Socket("localhost", 3947);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Send a message to the server: ");
            String input = userInput.readLine();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println(input);

            BufferedReader get = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String answer = get.readLine();
            System.out.println(answer);
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
