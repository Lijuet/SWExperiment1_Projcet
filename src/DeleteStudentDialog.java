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
                String temp = getStudentNumber.getText();
                studentNumber = Integer.parseInt(temp);
                textPane1.setText(lecture.searchStudent(studentNumber));
            } // �й����� �޾ƿ�. �л������� â�� ����ָ� ��
        });

        deleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                lecture.deleteStudent(studentNumber);
                // "������ �Ϸ�Ǿ����ϴ�" â ���
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
