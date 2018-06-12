package Functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class EmailRecept extends JDialog{
    public JPanel panel;
    private JTextField textName;
    private JTextField nameInfo;
    private JTextField IdInfo;
    private JTextField textId;
    private JTextField content;
    private JButton cancelButton;
    private String message;

    EmailRecept(String message){
        setContentPane(panel);
        setModal(true);
        getRootPane().setDefaultButton(cancelButton);
        this.message = message;


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // call onCancel() on ESCAPE
        panel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        content.setText(message);
    }
}
