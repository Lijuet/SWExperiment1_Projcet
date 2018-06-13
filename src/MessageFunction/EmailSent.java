package MessageFunction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EmailSent extends JFrame {
    private JTextArea message;
    private JTextField jtext_id;
    private JTextField jtext_name;
    private JButton btnSent;
    private JPanel panel;
    private JButton btnCancel;

    public static void main(String[] args) {//frame which sends a message
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
                try {
                    Email email = new Email();
                    email.setName(jtext_name.getText());
                    email.setId(Integer.parseInt(jtext_id.getText()));

                    ArrayList<String> contents = new ArrayList<>();
                    for (String line : message.getText().split("\\n")) contents.add(line);
                    email.setMessage(contents);

                    if (email.getName().equals("") || email.getMessage().equals("")) {
                        JOptionPane.showMessageDialog(null, "모든 정보를 입력하십시오.");
                    } else {
                        new MailSending(email).start();
                    }
                }catch (NumberFormatException a) {
                    JOptionPane.showMessageDialog(null, "학번을 올바른 형식으로 입력하십시오");
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { System.exit(1); }
        });
    }
}
