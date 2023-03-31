import java.io.IOException;
import java.net.Socket;

public class ClientSide {
    public static void main(String[] args) {
        System.out.println("Client started!");
        try {
            Socket client = new Socket("localhost", 3947);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
