import Components.Lecture;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AttendanceDialog extends JFrame{
    private JTextField date;
    private JButton OKbutton;
    private JButton cancelButton;
    private JPanel content;


    AttendanceDialog(Lecture lecture)
    {
        setContentPane(content);
        //setModal(true);
        getRootPane().setDefaultButton(cancelButton);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { dispose(); }
        });

        OKbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String input = date.getText();
                if (input.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "날짜를 입력해 주세요");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "출석을 시작합니다");
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
