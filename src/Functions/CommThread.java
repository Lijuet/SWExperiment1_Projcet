package Functions;

import javax.swing.*;
import java.awt.*;
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
            String message = dis.readUTF();//TODO 소켓으로 클래스 못넘기나?
            System.out.println(message);

            //Pop up the frame to check whether user will check it or not
            EventQueue.invokeLater(new Runnable() {
                public void run() { new AcceptEmailDialog(message); }
            });

            dis.close();
            soc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
