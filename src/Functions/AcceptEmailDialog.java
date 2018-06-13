package Functions;

import javax.swing.*;
import java.awt.event.*;

public class AcceptEmailDialog extends JFrame{
    private JPanel panel;
    private JButton btnOK;
    private JButton btnCancel;
    private Email email;
    private JTextField jtextAlarm;

    public AcceptEmailDialog(Email email){
        setContentPane(panel);
        getRootPane().setDefaultButton(btnCancel);

        this.email = email;
        jtextAlarm.setText("from " + email.getName());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // call onCancel() on ESCAPE
        panel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) { dispose(); }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }//TODO dispose 제대로 작동하는가?
        });

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmailRecept dialog = new EmailRecept(email);
                dialog.pack();
                dialog.setVisible(true);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }
}
