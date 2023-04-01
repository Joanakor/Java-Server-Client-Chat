import java.io.*;
import java.net.Socket;

public class ClientSide {
    public static void main(String[] args) {
        System.out.println("Client started!");
        try {
            Socket client = new Socket("localhost", 3947);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader messageReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            System.out.println("Send messages to the server: ");

            while (true)
            {
                String input = userInput.readLine();
                if (input.compareTo("EXIT") == 0)
                {
                    break;
                }
                out.println(input);
                String answer = messageReader.readLine();
                System.out.println(answer);
            }
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
