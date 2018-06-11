package ModifyFiles;

import Components.Student;
import java.io.*;
import java.util.ArrayList;

public class Reader {
    FileInputStream StudentInfo;
    BufferedReader br = null;
    String FileName;

    public Reader (String Filename)
    {
        this.FileName = Filename;
    }

    public Reader ()
    {
        this.FileName = "System_StudentInfo.csv";
    }


    public String[] studentReader(ArrayList<Student> Students) {
        String[] field = null;
        try {
            StudentInfo = new FileInputStream(FileName);
            br = new BufferedReader(new InputStreamReader(StudentInfo, "MS949"));
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null)
            {
                field = line.split(",");
                Student temp = new Student(field[0], field[2], field[3], Integer.parseInt(field[1]));
                Students.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (StudentInfo != null) try {
                StudentInfo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return field;
    }

}
