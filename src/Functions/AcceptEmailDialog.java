package Functions;

import javax.swing.*;
import java.awt.event.*;

public class AcceptEmailDialog extends JFrame{
    private JPanel panel;
    private JButton btnOK;
    private JButton btnCancel;
    private String message;

    public AcceptEmailDialog(String message){
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();
        setVisible(true);
        setContentPane(panel);
        getRootPane().setDefaultButton(btnCancel);
        //TODO 창 크기를 message를 적당히 나눌만큼의 크기로 만들 것

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
            public void actionPerformed(ActionEvent e) { dispose(); }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }//TODO dispose 제대로 작동하는가?
        });

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmailRecept dialog = new EmailRecept(message);
                dialog.setVisible(true);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }
}
