package Frame;

import Components.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandlingStudentsFrame extends JFrame {
    private JPanel contentPane;
    private Lecture lecture;
    private JTextField writeId;
    /**
     * Launch the application.
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    HandlingStudentsFrame frame = new HandlingStudentsFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    /**
     * Create the frame.
     */
    public HandlingStudentsFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 455, 467);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //Id 쓰는 텍스트 필드
        writeId = new JTextField();
        writeId.setBounds(163, 294, 96, 21);
        contentPane.add(writeId);
        writeId.setColumns(10);

        //Back Btn
        JButton btnBack = new JButton("BACK");
        btnBack.setBounds(12, 396, 90, 23);
        contentPane.add(btnBack);

        //Home Btn
        JButton btnHome = new JButton("HOME");
        btnHome.setBounds(337, 396, 91, 23);
        contentPane.add(btnHome);

        JButton btnReadStudentInfo = new JButton("\uD559\uC0DD \uC815\uBCF4 \uBD88\uB7EC\uC624\uAE30");
        btnReadStudentInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				/*
				//학생 정보 파일에서 읽어오기
				Reader studentReader = new Reader();
				ArrayList<Student> SystemStudent = new ArrayList<>();
				studentReader.studentReader(SystemStudent);
				//읽는 과정이 이해가 안감
				*/
                //lecture 정보를 앞 화면에서 받아올 것
                lecture = new Lecture("SystemProgramming");
                lecture.addStudent(new Student("황지우",null,null,2017613254));
                lecture.addStudent(new Student("김민준",null,null,2017311264));
                lecture.addStudent(new Student("박소영",null,null,2017316745));
            }
        });
        btnReadStudentInfo.setBounds(121, 42, 186, 30);
        contentPane.add(btnReadStudentInfo);

        JButton btnAddStudentInfo = new JButton("\uD559\uC0DD \uC815\uBCF4 \uCD94\uAC00\uD558\uAE30");
        btnAddStudentInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				/* 더하기 다이얼로그 띄우기
				 *
				Scanner s = new Scanner(System.in);
				String name = s.next();
				int Id = s.nextInt();
				s.close();

				//학생 추가 가능 여부 테스트2
				lecture.addStudent(new Student(name,null,null,Id));
				*/
            }
        });
        btnAddStudentInfo.setBounds(121, 84, 186, 30);
        contentPane.add(btnAddStudentInfo);

        JButton btnDeleteStudentInfo = new JButton("\uD559\uC0DD \uC815\uBCF4 \uC0AD\uC81C\uD558\uAE30");
        btnDeleteStudentInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int Id = Integer.parseInt(writeId.getText());

                // TODO Auto-generated method stub
                lecture.deleteStudent(Id);
            }
        });
        btnDeleteStudentInfo.setBounds(121, 124, 186, 30);
        contentPane.add(btnDeleteStudentInfo);

        JButton btnSearchStudentInfo = new JButton("\uD559\uC0DD \uC815\uBCF4 \uC870\uD68C\uD558\uAE30");
        btnSearchStudentInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int Id = Integer.parseInt(writeId.getText());

                // TODO Auto-generated method stub
                lecture.searchStudent(Id);
            }
        });
        btnSearchStudentInfo.setBounds(121, 164, 186, 30);
        contentPane.add(btnSearchStudentInfo);

        JButton btnReviseStudentInfo = new JButton("\uD559\uC0DD \uC815\uBCF4 \uC218\uC815\uD558\uAE30");
        btnReviseStudentInfo.addActionListener(new ActionListener() {//수정 전
            public void actionPerformed(ActionEvent arg0) {
                //바꾸는 콘솔창 띄우기

                // TODO Auto-generated method stub
                //lecture.deleteStudent(Id);
            }
        });
        btnReviseStudentInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnReviseStudentInfo.setBounds(121, 206, 186, 30);
        contentPane.add(btnReviseStudentInfo);
    }
}
