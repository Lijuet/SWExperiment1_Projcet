import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ModifyStudentDialog extends JDialog{
    private JComboBox findStudent;
    private JTextField textField1;
    private JButton searchButton;
    private JTextPane textPane1;
    private JComboBox whatToChange;
    private JButton cancelButton;
    private JButton changeButton;
    private JTextField textField2;
    private JTextArea 학번이나이름을입력해주세요TextArea;
    private JTextArea 수정할내용을입력해주세요TextArea;
    private JPanel modifyPlane;
    private JPanel inputPlane;
    private JPanel content;
    private JTextArea editStudentTextArea;

    public ModifyStudentDialog()
    {
        setContentPane(content);
        setModal(true);
        getRootPane().setDefaultButton(cancelButton);

        changeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        content.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String text = textField1.getText();
                //Student Number
                if(findStudent.getSelectedIndex() == 1)
                {
                    // 화면 띄우기
                }
                //Name
                else
                {
                    int studentNumber = Integer.parseInt(text);
                    // 학생 정보 띄우기
                }
            }
        });
    }

    private void onOK()
    {
        // add your code here
        dispose();
    }

    private void onCancel()
    {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ModifyStudentDialog dialog = new ModifyStudentDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
