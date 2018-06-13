import Components.Lecture;
import ModifyFiles.Reader;
import ModifyFiles.Writer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

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
                    String[] attendance = new String[lecture.numOfStudent + 1];
                    Arrays.fill(attendance, "O"); // 모두가 출석 했다고 초기화
                    attendance[0] = input; // 맨 위에 날짜 입력
                    Reader a = new Reader(lecture.getName()+"_StudentInfo.csv");
                    a.studentReader();
                    String[] studentList = a.getStudentList();

                    // 출석을 시작함
                    for (int i = 1; i <= lecture.numOfStudent; i++)
                    {
                        int result = JOptionPane.showConfirmDialog(null, studentList[i - 1], "Attendance", 0);
                        if (result == JOptionPane.CLOSED_OPTION)
                        {
                            JOptionPane.showMessageDialog(null, "출석을 종료합니다");
                            break;
                        }
                        if (result == JOptionPane.OK_OPTION)
                            attendance[i] = "O";
                        else
                            attendance[i] = "X";

                        addWindowListener(new WindowAdapter() {
                            public void windowClosing(WindowEvent e) { dispose();
                            }
                        });
                    }
                    // attendance에 출석 현황 저장
                    JOptionPane.showMessageDialog(null, "출석을 마쳤습니다");

                    Writer b = new Writer(lecture.getName() + "_StudentInfo.csv");
                    b.writeAttendance(attendance);
                }
            }
        });
    }
}
