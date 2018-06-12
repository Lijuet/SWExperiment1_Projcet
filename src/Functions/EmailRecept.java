package Functions;

import javax.swing.*;
import java.awt.event.*;

public class EmailRecept extends JDialog{
    public JPanel panel;
    private JTextField textName;
    private JTextField nameInfo;
    private JTextField IdInfo;
    private JTextField textId;
    private JTextField jtext_message;
    private JButton btnCancel;
    private String message;

    EmailRecept(String message){
        setContentPane(panel);
        setModal(true);
        getRootPane().setDefaultButton(btnCancel);
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

        //initialize the dialog
        jtext_message.setText(message);
    }
}
