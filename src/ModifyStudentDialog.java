import Components.Lecture;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ModifyStudentDialog extends JDialog{
    private JButton searchButton;
    private JTextField textField1;
    private JComboBox whatToChange;
    private JTextField textField2;
    private JButton changeButton;
    private JButton cancelButton;
    private JPanel content;
    private JTextPane textPane1;
    int studentNumber = -1;

    public ModifyStudentDialog(Lecture lecture)
    {
        setContentPane(content);
        setModal(true);
        getRootPane().setDefaultButton(cancelButton);


        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // call onCancel() on ESCAPE
        content.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String input = textField1.getText();
                if (input.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "�й��� �Է��� �ּ���");
                }
                else
                {
                    try {
                        studentNumber = Integer.parseInt(input);
                        textPane1.setText(lecture.searchStudent(studentNumber));
                    } catch (NumberFormatException a) {
                        JOptionPane.showMessageDialog(null, "�й��� ���ڸ� �Է��� �ּ���");
                    }
                }
            } // �й����� �޾ƿ�. �л������� â�� ����ָ� ��
        });

        changeButton.addActionListener(new ActionListener() { // lecture���� student number�� �л��� �����Ҷ�
            @Override
            public void actionPerformed(ActionEvent e) {
                String text2 = textField2.getText();
                /**if else�� student�� �����ҋ� ���Ҷ� ������**/
                if (lecture.existStudent(studentNumber) == 1 && !text2.equals("")) {
                    int temp = whatToChange.getSelectedIndex();

                    int result = JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?", "Modify", 0);
                    if (result == JOptionPane.OK_OPTION) {
                        /*****************decide what to change****************/
                        if (temp == 0) // Name
                        {
                            lecture.modifyStudentName(studentNumber, text2);
                            JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�"); // "������ �Ϸ�Ǿ����ϴ�" â ���
                        } else if (temp == 1) // Student number
                        {
                            try {
                                Integer.parseInt(text2);
                                lecture.modifyStudentID(studentNumber, text2);
                                JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�"); // "������ �Ϸ�Ǿ����ϴ�" â ���
                            } catch (NumberFormatException a) {
                                JOptionPane.showMessageDialog(null, "�й��� ���ڸ� �Է��� �ּ���");
                            }

                        } else if (temp == 2) // Email
                        {
                            lecture.modifyStudentEmail(studentNumber, text2);
                            JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�"); // "������ �Ϸ�Ǿ����ϴ�" â ���
                        } else if (temp == 3) // Phone number
                        {
                            lecture.modifyStudentNumber(studentNumber, text2);
                            JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�"); // "������ �Ϸ�Ǿ����ϴ�" â ���
                        }
                        /******************************************************/
                    }

                }
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
