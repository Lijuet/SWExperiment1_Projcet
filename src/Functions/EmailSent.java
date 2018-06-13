package Functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class EmailSent extends JFrame {
    private JTextArea message;
    private JTextField contentTextField;
    private JTextField jtextAlarm;
    private JTextField nameTextField;
    private JTextField idTextField;
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

                ArrayList<String> contents = new ArrayList<>();
                for (String line : message.getText().split("\\n")) contents.add(line);
                email.setMessage(contents);

                new mailSending(email).start();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { System.exit(1); }
        });
    }
}
