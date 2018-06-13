package ManageFunction;
import Components.Student;
import java.io.*;

public class Writer {
    String FileName;
    FileInputStream attendanceWrite;
    BufferedReader br = null;

    public Writer (String Filename)
    {
        this.FileName = Filename;
    }

    // public Writer () { this.FileName = "System_StudentInfo.csv"; }


    public void studentWriter(Student Student)
    {
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FileName, true))))
        {
            out.println(Student.getName() + "," + Student.getStudentId() + "," + Student.getEmailAddress() + "," + Student.getPhoneNumber());
            //more code
        }
        catch (IOException e)
        {
            //exception handling left as an exercise for the reader
        }
    }

    public void writeAttendance(String[] attendanceInfo) // �迭�� [6/15,1,1,1,0,...] �̷������� ����� ��
    {
        String dummy = "";
        int i = 0;
        try
        {
            attendanceWrite = new FileInputStream(FileName);
            br = new BufferedReader(new InputStreamReader(attendanceWrite));
            String line;
            while ((line = br.readLine()) != null)
            {
                dummy += line + "," +attendanceInfo[i++] + "\r\n"; // �⼮ ��Ȳ�� ����
            }

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileName)));
            writer.write(dummy);

            writer.close();
            br.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
