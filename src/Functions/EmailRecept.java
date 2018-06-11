package Functions;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class EmailRecept extends JFrame{
    public JPanel panel;
    public JTextField state;
    private JButton btnRead;
    private JTextField content;
    private ArrayList<String> message;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                EmailRecept frame = new EmailRecept();
                frame.setContentPane(new EmailRecept().panel);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
    }

    public void addMessage(String message){
        this.message.add(message);
        revalidate();
    }

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
                content.setText(message);
                repaint();

                dis.close();
                soc.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
