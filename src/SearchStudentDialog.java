import Components.HandlingStudents;
import Components.Lecture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchStudentDialog extends JFrame {
    private JTextField getStudentNumber;
    private JButton searchButton;
    private JButton cancelButton;
    private JTextPane textPane1;
    private JPanel content;
    int studentNumber = -1;

    public SearchStudentDialog(Lecture lecture)
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

        content.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                studentNumber = Integer.parseInt(getStudentNumber.getText());
                textPane1.setText(lecture.searchStudent(studentNumber));
            } // 학번까지 받아옴. 학생정보를 창에 띄워주면 됨

        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        ModifyStudentDialog dialog = new ModifyStudentDialog(null);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
