package ModifyFiles;

import Components.Student;

import java.io.*;

public class Modify {
    FileInputStream StudentModify;
    BufferedReader br = null;
    int studentNumber = -1;
    String name = null;
    String FileName;

    public Modify(int studentNumber, String FileName) { this.studentNumber = studentNumber; this.FileName = FileName; }
    public Modify(int studentNumber) { this.studentNumber = studentNumber; this.FileName = "System_StudentInfo.csv"; }
    public Modify(String name, String FileName) { this.name = name; this.FileName = FileName; }
    public Modify(String name) { this.name = name; this.FileName = "System_StudentInfo.csv"; }

    public void modifyName(String afterName) // 이름을 수정
    {
        String dummy = "";
        try
        {
            StudentModify = new FileInputStream(FileName);
            br = new BufferedReader(new InputStreamReader(StudentModify, "MS949"));
            String line;
            if (studentNumber != -1) // 수정할 대상을 학번으로 받았을 경우
            {
                while ((line = br.readLine()) != null)
                {
                    String[] field = line.split(",");
                    if (Integer.parseInt(field[1]) != studentNumber)
                    {
                        dummy += (line + "\r\n");
                    }
                    else {
                        dummy += afterName + ",";
                        dummy = dummy + field[1] + "," + field[2] + "," + field[3] + "\r\n";
                    }
                }
            }
            else // 수정할 대상을 이름으로 받았을 경우
            {
                while ((line = br.readLine()) != null)
                {
                    String[] field = line.split(",");
                    if (!field[0].equals(name))
                    {
                        dummy += (line + "\r\n");
                    }
                    else {
                        dummy += afterName + ",";
                        dummy = dummy + field[1] + "," + field[2] + "," + field[3] + "\r\n";
                    }
                }
            }
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileName), "euc-kr"));
            writer.write(dummy);

            writer.close();
            br.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void modifyMail(String afterMail) // 메일주소를 수정
    {
        String dummy = "";
        try
        {
            StudentModify = new FileInputStream(FileName);
            br = new BufferedReader(new InputStreamReader(StudentModify, "MS949"));
            String line;
            if (studentNumber != -1) // 수정할 대상을 학번으로 받았을 경우
            {
                while ((line = br.readLine()) != null)
                {
                    String[] field = line.split(",");
                    if (Integer.parseInt(field[1]) != studentNumber)
                    {
                        dummy += (line + "\r\n");
                    }
                    else {
                        dummy = dummy + field[0] + "," + field[1] + ",";
                        dummy += afterMail + ",";
                        dummy = dummy + field[3] + "\r\n";
                    }
                }
            }
            else // 수정할 대상을 이름으로 받았을 경우
            {
                while ((line = br.readLine()) != null)
                {
                    String[] field = line.split(",");
                    if (!field[0].equals(name))
                    {
                        dummy += (line + "\r\n");
                    }
                    else {
                        dummy = dummy + field[0] + "," + field[1] + ",";
                        dummy += afterMail + ",";
                        dummy = dummy + field[3] + "\r\n";
                    }
                }
            }
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileName), "euc-kr"));
            writer.write(dummy);

            writer.close();
            br.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void modifyPhoneNumber(String afterPhoneNumber) // 핸드폰번호 수정
    {
        String dummy = "";
        try
        {
            StudentModify = new FileInputStream(FileName);
            br = new BufferedReader(new InputStreamReader(StudentModify, "MS949"));
            String line;
            if (studentNumber != -1) // 수정할 대상을 학번으로 받았을 경우
            {
                while ((line = br.readLine()) != null)
                {
                    String[] field = line.split(",");
                    if (Integer.parseInt(field[1]) != studentNumber)
                    {
                        dummy += (line + "\r\n");
                    }
                    else {
                        dummy = dummy + field[0] + "," + field[1] + "," + field[2] + ",";
                        dummy = dummy + afterPhoneNumber + "\r\n";
                    }
                }
            }
            else // 수정할 대상을 이름으로 받았을 경우
            {
                while ((line = br.readLine()) != null)
                {
                    String[] field = line.split(",");
                    if (!field[0].equals(name))
                    {
                        dummy += (line + "\r\n");
                    }
                    else {
                        dummy = dummy + field[0] + "," + field[1] + "," + field[2] + ",";
                        dummy = dummy + afterPhoneNumber + "\r\n";
                    }
                }
            }
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileName), "euc-kr"));
            writer.write(dummy);

            writer.close();
            br.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void modifyStudentNumber(String afterStudentNumber) // 학번을 수정
    {
        String dummy = "";
        try
        {
            StudentModify = new FileInputStream(FileName);
            br = new BufferedReader(new InputStreamReader(StudentModify, "MS949"));
            String line;
            if (studentNumber != -1) // 수정할 대상을 학번으로 받았을 경우
            {
                while ((line = br.readLine()) != null)
                {
                    String[] field = line.split(",");
                    if (Integer.parseInt(field[1]) != studentNumber)
                    {
                        dummy += (line + "\r\n");
                    }
                    else {
                        dummy = dummy + field[0] + ",";
                        dummy = dummy + afterStudentNumber + ",";
                        dummy = dummy + field[2] + "," + field[3] + "\r\n";
                    }
                }
            }
            else // 수정할 대상을 이름으로 받았을 경우
            {
                while ((line = br.readLine()) != null)
                {
                    String[] field = line.split(",");
                    if (!field[0].equals(name))
                    {
                        dummy += (line + "\r\n");
                    }
                    else {
                        dummy = dummy + field[0] + ",";
                        dummy = dummy + afterStudentNumber + ",";
                        dummy = dummy + field[2] + "," + field[3] + "\r\n";
                    }
                }
            }
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileName), "euc-kr"));
            writer.write(dummy);

            writer.close();
            br.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
