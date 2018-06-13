package ManageFunction;

import java.io.*;

public class Modify {
    FileInputStream StudentModify;
    BufferedReader br = null;
    int studentNumber = -1;
    String name = null;
    String FileName;

    public Modify(int studentNumber, String FileName) { this.studentNumber = studentNumber; this.FileName = FileName; }
    // public Modify(int studentNumber) { this.studentNumber = studentNumber; this.FileName = "System_StudentInfo.csv"; }
    public Modify(String name, String FileName) { this.name = name; this.FileName = FileName; }
    // public Modify(String name) { this.name = name; this.FileName = "System_StudentInfo.csv"; }

    public void modifyName(String afterName) // modify name
    {
        String dummy = "";
        try
        {
            StudentModify = new FileInputStream(FileName);
            br = new BufferedReader(new InputStreamReader(StudentModify));
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] field = line.split(",");
                if (!field[1].equals(String.valueOf(studentNumber)))
                {
                    dummy += (line + "\r\n");
                }
                else
                {
                    dummy += afterName + ",";
                    dummy = dummy + field[1] + "," + field[2] + "," + field[3] + "\r\n";
                }
            }

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileName)));
            writer.write(dummy);

            writer.close();
            br.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void modifyMail(String afterMail) // �����ּҸ� ����
    {
        String dummy = "";
        try
        {
            StudentModify = new FileInputStream(FileName);
            br = new BufferedReader(new InputStreamReader(StudentModify));
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] field = line.split(",");
                if (!field[1].equals(String.valueOf(studentNumber)))
                {
                    dummy += (line + "\r\n");
                }
                else { dummy = dummy + field[0] + "," + field[1] + ",";
                    dummy += afterMail + ",";
                    dummy = dummy + field[3] + "\r\n";
                }
            }
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileName)));
            writer.write(dummy);

            writer.close();
            br.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void modifyPhoneNumber(String afterPhoneNumber) // �ڵ�����ȣ ����
    {
        String dummy = "";
        try
        {
            StudentModify = new FileInputStream(FileName);
            br = new BufferedReader(new InputStreamReader(StudentModify));
            String line;

            while ((line = br.readLine()) != null)
            {
                String[] field = line.split(",");
                if (!field[1].equals(String.valueOf(studentNumber)))
                {
                    dummy += (line + "\r\n"); } else {
                    dummy = dummy + field[0] + "," + field[1] + "," + field[2] + ",";
                    dummy = dummy + afterPhoneNumber + "\r\n"; } }

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileName)));
            writer.write(dummy);

            writer.close();
            br.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void modifyStudentNumber(String afterStudentNumber) // �й��� ����
    {
        String dummy = "";
        try
        {
            StudentModify = new FileInputStream(FileName);
            br = new BufferedReader(new InputStreamReader(StudentModify));
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] field = line.split(",");
                if (!field[1].equals(String.valueOf(studentNumber)))
                {
                    dummy += (line + "\r\n"); } else {
                    dummy = dummy + field[0] + ",";
                    dummy = dummy + afterStudentNumber + ",";
                    dummy = dummy + field[2] + "," + field[3] + "\r\n"; } }

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileName)));
            writer.write(dummy);

            writer.close();
            br.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
