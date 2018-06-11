import Components.*;
import ModifyFiles.Reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HandlingStudentsFrame extends JFrame {
    private JPanel contentPane;
    private Lecture lecture;
    private JTextField writeId;
    private JButton btnBack;
    private JPanel panel1;
    private JButton btnHome;
    private JButton btnReadStudentInfo;
    private JButton btnReviseStudentInfo;
    private JButton btnAddStudentInfo;
    private JButton btnDeleteStudentInfo;
    private JButton btnSearchStudentInfo;
    private JPanel panel;
    private JTextField STUDENTTextField;

    /**
     * Launch the application.
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                HandlingStudentsFrame frame = new HandlingStudentsFrame();
                frame.setContentPane(new HandlingStudentsFrame().panel);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     */
    public HandlingStudentsFrame() {
        //인텔리 j버전
        btnReadStudentInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //학생 정보 파일에서 읽어오기
                Reader studentReader = new Reader();
                ArrayList<Student> SystemStudent = new ArrayList<>();
                studentReader.studentReader(SystemStudent);
                //lecture 정보를 앞 화면에서 받아올 것

                lecture = new Lecture("SystemProgramming");
                lecture.addStudent(new Student("황지우",null,null,2017613254));
                lecture.addStudent(new Student("김민준",null,null,2017311264));
                lecture.addStudent(new Student("박소영",null,null,2017316745));

            }
        });
        btnAddStudentInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudentDialog dialog = new AddStudentDialog(lecture);
                dialog.pack();
                dialog.setVisible(true);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        btnDeleteStudentInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // int Id = Integer.parseInt(writeId.getText());

                DeleteStudentDialog dialog = new DeleteStudentDialog(lecture);
                dialog.pack();
                dialog.setVisible(true);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // TODO Auto-generated method stub
                // lecture.deleteStudent(Id);
            }
        });
        btnSearchStudentInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // int Id = Integer.parseInt(writeId.getText());

                SearchStudentDialog dialog = new SearchStudentDialog(lecture);
                dialog.pack();
                dialog.setVisible(true);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // TODO Auto-generated method stub
                // lecture.searchStudent(Id);
            }
        });
        btnReviseStudentInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModifyStudentDialog dialog = new ModifyStudentDialog(lecture);
                dialog.pack();
                dialog.setVisible(true);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // TODO Auto-generated method stub
                //lecture.deleteStudent(Id);
            }
        });
    }
}
