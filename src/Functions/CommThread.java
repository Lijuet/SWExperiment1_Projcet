package Functions;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class CommThread extends Thread {

    private Socket soc;

    public CommThread (Socket soc) {
        this.soc = soc;
    }

    public void run () {
        try {
            DataInputStream dis = new DataInputStream (soc.getInputStream());

            System.out.println("You got a message!");
            String message = dis.readUTF();
            System.out.println(message);

            dis.close();
            soc.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
