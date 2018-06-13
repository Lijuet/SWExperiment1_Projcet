package MessageFunction;

import javax.swing.*;
import java.awt.event.*;

public class EmailRecept extends JDialog{
    public JPanel panel;
    private JTextField nameInfo;
    private JTextField IdInfo;
    private JTextArea message;
    private JButton btnCancel;

    EmailRecept(Email email){
        setContentPane(panel);
        setModal(true);
        getRootPane().setDefaultButton(btnCancel);

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
        message.setText(email.getMessage());
        IdInfo.setText(String.valueOf(email.getId()));
        nameInfo.setText(email.getName());

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
