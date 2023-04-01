import java.io.BufferedReader;
import java.io.IOException;

public class MessageListener implements Runnable{
    BufferedReader messageReader;
    public MessageListener(BufferedReader messageReader)
    {
        this.messageReader = messageReader;
    }

    @Override
    public void run() {
        try {
            while(true)
            {
                String answer = messageReader.readLine();
                if (!answer.isEmpty())
                {
                    System.out.println("Friend: " + answer);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
