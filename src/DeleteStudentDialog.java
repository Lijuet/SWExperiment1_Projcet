import Components.Lecture;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                studentNumber = Integer.parseInt(getStudentNumber.getText());
                textPane1.setText(lecture.searchStudent(studentNumber));
            } // 학번까지 받아옴. 학생정보를 창에 띄워주면 됨
        });

        deleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (studentNumber != -1)
                {
                    lecture.deleteStudent(studentNumber);
                    // "삭제가 완료되었습니다" 창 출력
                }
                else
                {
                    // "학번을 입력해 주세요" 창 출력
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
        ModifyStudentDialog dialog = new ModifyStudentDialog(null);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
