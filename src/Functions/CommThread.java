package Functions;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class CommThread extends Thread {

    private Socket soc;
    Email email = null;

    public CommThread (Socket soc) {
        this.soc = soc;
    }

    public void run () {
        try {
            ObjectInputStream dis = new ObjectInputStream (soc.getInputStream());
            try {
                System.out.println("You got a message!");
                email = (Email)dis.readObject();
                System.out.println(email.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            //Pop up the frame to check whether user will check it or not
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    AcceptEmailDialog frame = new AcceptEmailDialog(email);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                }
            });

            dis.close();
            soc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
