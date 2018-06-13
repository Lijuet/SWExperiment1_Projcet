package ManageFunction;

import Components.Lecture;

import javax.swing.*;
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
                String input = getStudentNumber.getText();
                if (input.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "학번을 입력해 주세요");
                }
                else
                {
                    try {
                        studentNumber = Integer.parseInt(input);
                        textPane1.setText(lecture.searchStudent(studentNumber));
                    } catch (NumberFormatException a) {
                        JOptionPane.showMessageDialog(null, "학번에 숫자를 입력해 주세요");
                    }
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SearchStudentDialog dialog = new SearchStudentDialog(null);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
