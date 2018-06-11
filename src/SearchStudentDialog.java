import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchStudentDialog extends JFrame {
    private JTextArea searchStudentTextArea;
    private JTextArea 학번을입력해주세요TextArea;
    private JTextField getStudentNumber;
    private JButton searchButton;
    private JButton cancelButton;
    private JTextPane textPane1;
    private JPanel content;

    public SearchStudentDialog()
    {
        setContentPane(content);
        //setModal(true);
        getRootPane().setDefaultButton(cancelButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int studentNumber = Integer.parseInt(getStudentNumber.getText());
            } // 학번까지 받아옴. 학생정보를 창에 띄워주면 됨
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        ModifyStudentDialog dialog = new ModifyStudentDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
