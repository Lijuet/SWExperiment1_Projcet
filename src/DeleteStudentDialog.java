import Components.Lecture;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;

public class DeleteStudentDialog extends JFrame {
    private JTextField getStudentNumber;
    private JButton cancelButton;
    private JButton deleteButton1;
    private JButton searchButton;
    private JTextPane textPane1;
    private JPanel content;
    int studentNumber = -1;


    public DeleteStudentDialog(Lecture lecture)
    {
        setContentPane(content);
        //setModal(true);
        getRootPane().setDefaultButton(cancelButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String temp = getStudentNumber.getText();
                if (temp.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "학번을 입력해 주세요");
                }
                else
                {
                    try {
                        studentNumber = Integer.parseInt(temp);
                        textPane1.setText(lecture.searchStudent(studentNumber));
                    } catch (NumberFormatException a) {
                        JOptionPane.showMessageDialog(null, "학번에 숫자를 입력해 주세요");
                    }
                }
            } // 학번까지 받아옴. 학생정보를 창에 띄워주면 됨
        });

        deleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String temp = getStudentNumber.getText();
                if (temp.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "학번을 입력해 주세요");
                }
                else
                {
                    if (lecture.existStudent(studentNumber) == 1)
                    {
                        int result = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?", "Delete", 0);
                        if (result == JOptionPane.OK_OPTION) {
                            lecture.deleteStudent(studentNumber);
                            JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다"); // "삭제가 완료되었습니다" 창 출력
                        }
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
        DeleteStudentDialog dialog = new DeleteStudentDialog(null);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
