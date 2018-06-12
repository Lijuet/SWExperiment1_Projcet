package Functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class EmailSent extends JFrame {
    private String message;
    private JTextField jtext_message;
    private JTextField jtext_id;
    private JTextField jtext_name;
    private JButton btnSent;
    private JPanel panel;
    private JButton btnCancel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                EmailSent frame = new EmailSent();
                frame.setContentPane(new EmailSent().panel);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public EmailSent(){
        message = null;

        btnSent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Email email = new Email();
                email.setName(jtext_name.getText());
                email.setId(Integer.parseInt(jtext_id.getText()));
                //TODO textfield에서 가능한 string array로 넘기기
                new mailSending(email).start();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
    }
}

class mailSending extends Thread {
    int id;
    String name;
    String message;

    public mailSending(Email email){
        id = email.getId();
        name = email.getName();
        message = email.getMessage();
    }

    public void run () {
        try {
            Socket soc = new Socket("localhost", 5000);

            OutputStream os = soc.getOutputStream ();
            DataOutputStream dos = new DataOutputStream (os);

            dos.writeUTF ("[ " + name + "( " + id + " ) ] : " + message);
            System.out.println ("Message is successfully sent!");

            dos.close();
            soc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}