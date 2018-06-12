package Functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class EmailSent extends JFrame {
    private ArrayList<String> recipients;
    private String contents;
    private JTextField contentTextField;
    private JTextField content;
    private JTextField nameTextField;
    private JTextField idTextField;
    private JTextField id;
    private JTextField name;
    private JButton btnSent;
    private JPanel panel;
    private JTextField sendEMailTextField;
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
        recipients = new ArrayList<>();
        contents = null;
        btnSent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new mailSending(content.getText(), Integer.parseInt(id.getText())).start();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
    }

    //set recipents
    public void setRecipients(String recipient){ this.recipients.add(recipient); }
    public void setRecipients(ArrayList<String> recipients){ this.recipients = (ArrayList<String>)recipients.clone(); }


    public ArrayList<String> getRecipients() { return recipients; }
    public String getContents() { return contents; }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

class mailSending extends Thread {
    int id;
    String content;

    public mailSending(String content, int id){ this.content = content; this.id = id; }

    public void run () {

        try {
            Socket soc = new Socket("localhost", 5000);

            OutputStream os = soc.getOutputStream ();
            DataOutputStream dos = new DataOutputStream (os);

            dos.writeUTF ("[ " + id + " ] : " + content );
            System.out.println ("Message is successfully sent!");

            dos.close();
            soc.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}