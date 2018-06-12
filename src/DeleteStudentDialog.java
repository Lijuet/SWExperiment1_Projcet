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
                    JOptionPane.showMessageDialog(null, "�й��� �Է��� �ּ���");
                }
                else
                {
                    try {
                        studentNumber = Integer.parseInt(temp);
                        textPane1.setText(lecture.searchStudent(studentNumber));
                    } catch (NumberFormatException a) {
                        JOptionPane.showMessageDialog(null, "�й��� ���ڸ� �Է��� �ּ���");
                    }
                }
            } // �й����� �޾ƿ�. �л������� â�� ����ָ� ��
        });

        deleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String temp = getStudentNumber.getText();
                if (temp.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "�й��� �Է��� �ּ���");
                }
                else
                {
                    if (lecture.existStudent(studentNumber) == 1)
                    {
                        int result = JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?", "Delete", 0);
                        if (result == JOptionPane.OK_OPTION) {
                            lecture.deleteStudent(studentNumber);
                            JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�"); // "������ �Ϸ�Ǿ����ϴ�" â ���
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
