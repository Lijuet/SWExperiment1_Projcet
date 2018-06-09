package ModifyFiles;

import Components.Student;
import java.io.*;

public class Delete {
    FileInputStream StudentDelete;
    BufferedReader br = null;
    int studentNumber;
    String FileName;
    public Delete()
    {
        FileName = "System_StudentInfo.csv";
    }
    public Delete(String fileName)
    {
        this.FileName = fileName;
    }

    public void studentDelete(int studentNumber)
    {
        this.studentNumber = studentNumber;
        String dummy = "";

        try
        {
            StudentDelete = new FileInputStream(FileName);
            br = new BufferedReader(new InputStreamReader(StudentDelete, "MS949"));
            String line;

            while((line = br.readLine()) != null)
            {
                String[] field = line.split(",");
                if(Integer.parseInt(field[1]) != studentNumber)
                {
                    dummy += (line + "\r\n" );
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
