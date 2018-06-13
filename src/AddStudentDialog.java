import Components.Lecture;
import Components.Student;

import javax.swing.*;
import java.awt.event.*;

public class AddStudentDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public AddStudentDialog(Lecture lecture) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        /*********************************************/
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int studentID = -1;
                String temp;
                temp = textField2.getText();
                String name = textField1.getText();
                String Email = textField3.getText();
                String phoneNumber = textField4.getText();
                try {
                    studentID = Integer.parseInt(temp);
                    if (name.equals("") || studentID == -1 || Email.equals("") || phoneNumber.equals("")) {
                        JOptionPane.showMessageDialog(null, "??? ?????? ????? ?????");
                    } else {
                        int result = JOptionPane.showConfirmDialog(null, "?????©£??????", "Add", 0);
                        if (result == JOptionPane.OK_OPTION) {
                            JOptionPane.showMessageDialog(null, "????? ??????????"); // "????? ??????????" ? ???
                            Student newStudent = new Student(name, Email, phoneNumber, studentID);
                            lecture.addStudent(newStudent);
                        }
                    }
                }
                catch (NumberFormatException a){
                    JOptionPane.showMessageDialog(null, "?¬Û??? ????? ????? ?????");
                }
            }
        });

    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AddStudentDialog dialog = new AddStudentDialog(null);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
