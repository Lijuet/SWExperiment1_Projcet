import Components.Lecture;
import Components.Student;
import ModifyFiles.Reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SelectLectureDialog extends JFrame {
    private JPanel content;
    private JComboBox selectLecture;
    private JButton Student;
    private JButton Professor;
    int numOfLecture = 0;
    String[] lectureList = null;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                SelectLectureDialog frame = new SelectLectureDialog();
                frame.setContentPane(new SelectLectureDialog().content);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public SelectLectureDialog()
    {
        Reader a = new Reader("Lecture.csv");
        lectureList =  a.getLecture();
        numOfLecture = lectureList.length;

        /***************lecture를 읽어와서 lecture 목록을 띄움**************/
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(lectureList);
        selectLecture.setModel(model);
        /**************************************************************/

        Student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int userSelectLecture = selectLecture.getSelectedIndex();
                Lecture lecture = new Lecture(lectureList[userSelectLecture]);
                Reader readStudent = new Reader(lectureList[userSelectLecture] + "_StudentInfo.csv");
                ArrayList<Student> StudentList = readStudent.studentReader();
                lecture.setStudent(StudentList);
                // lecture에 학생까지 넣음. 교수 넣어주면 됨


                HandlingStudentsFrame dialog = new HandlingStudentsFrame(lecture);
                dialog.pack();
                dialog.setVisible(true);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // HandlingStudentFrame창 열기.

                // SelectLectureDialog창 닫은 다음에


                // 1. userSelectLecture가 안받아짐
                // 2. System_StudentInfo 이름 받기 오류
            }
        });

        Professor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userSelectLecture = selectLecture.getSelectedIndex();
                Lecture lecture = new Lecture(lectureList[userSelectLecture]);
                lecture.setProfessor(lectureList[userSelectLecture]);

                professorDialog dialog = new professorDialog(lecture.getProfessor());
                dialog.pack();
                dialog.setVisible(true);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
