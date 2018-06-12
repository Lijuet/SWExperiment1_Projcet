package Functions;

import javax.swing.*;
import java.awt.event.*;

public class AcceptEmailDialog extends JDialog{
    private JPanel panel1;
    private JButton okButton;
    private JButton noButton;
    private JTextField youGotMessageDoTextField;
    private String message;

    public AcceptEmailDialog(String message){
        setContentPane(panel1);
        setModal(true);
        getRootPane().setDefaultButton(noButton);

        this.message = message;


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // call onCancel() on ESCAPE
        panel1.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmailRecept dialog = new EmailRecept(message);
                dialog.pack();
                dialog.setVisible(true);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }
}
