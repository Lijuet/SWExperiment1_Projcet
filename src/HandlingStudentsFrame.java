import Components.*;
import ModifyFiles.Reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HandlingStudentsFrame extends JFrame {
    private Lecture lecture;
    private JButton btnBack;
    private JButton btnReviseStudentInfo;
    private JButton btnAddStudentInfo;
    private JButton btnDeleteStudentInfo;
    private JButton btnSearchStudentInfo;
    private JPanel panel;

    /**
     * Launch the application.
     */


    /* public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                HandlingStudentsFrame frame = new HandlingStudentsFrame(null);
                frame.setContentPane(new HandlingStudentsFrame(null).panel);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    */

    public static void main(String[] args) {
        HandlingStudentsFrame dialog = new HandlingStudentsFrame(null);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    /**
     * Create the frame.
     */
    public HandlingStudentsFrame(Lecture lecture) {
        //인텔리 j버전

        setContentPane(panel);
        getRootPane().setDefaultButton(btnBack);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

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

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
    }
}
