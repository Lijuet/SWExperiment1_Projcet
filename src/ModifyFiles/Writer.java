package ModifyFiles;
import Components.Student;
import java.io.*;

public class Writer {
    String FileName;

    public Writer (String Filename)
    {
        this.FileName = Filename;
    }

    public Writer ()
    {
        this.FileName = "System_StudentInfo.csv";
    }


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

}
