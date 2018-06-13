import Components.Professor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class professorDialog extends JFrame {
    private JTextPane textPane1;
    private JPanel panel1;
    private JButton OK;

    public professorDialog(Professor professor)
    {
        setContentPane(panel1);
        //setModal(true);
        getRootPane().setDefaultButton(OK);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        String professorInfo;
        professorInfo = "Name: " + professor.getName() + "\n" + "Email: " + professor.getEmailAddress() + "\n"
                + "Phone number: " + professor.getPhoneNumber();
        textPane1.setText(professorInfo);

        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
    }
}
