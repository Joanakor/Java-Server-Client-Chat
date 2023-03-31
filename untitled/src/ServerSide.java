import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {
    public static void main(String[] args) {
        System.out.println("Starting server...");
        try {
            ServerSocket serverSocket = new ServerSocket(3947);
            Socket server = serverSocket.accept();
            System.out.println("Connection established!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
