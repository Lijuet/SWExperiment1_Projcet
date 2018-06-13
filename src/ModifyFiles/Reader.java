package ModifyFiles;

import Components.Professor;
import Components.Student;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    FileInputStream StudentInfo;
    BufferedReader br1 = null;
    String FileName;

    FileInputStream Lecture;
    BufferedReader br2 = null;

    FileInputStream Lecture2;
    BufferedReader br3 = null;

    public Reader (String Filename)
    {
        this.FileName = Filename;
    }
    // public Reader() { this.FileName = "System_StudentInfo.csv"; }

    public ArrayList<String> attendanceTemp = new ArrayList<>();

    public String[] getStudentList() {
        String[] temp = new String[attendanceTemp.size()];
        temp = attendanceTemp.toArray(temp);
        return temp;
    }

    public Professor professorReader(String lecture)
    {
        Professor professorTemp = new Professor(null, null, null);
        String[] field = null;
        try {
            Lecture2 = new FileInputStream(FileName);
            br3 = new BufferedReader(new InputStreamReader(Lecture2));
            String line;
            while ((line = br3.readLine()) != null)
            {
                field = line.split(",");

                if (field[0].trim().equals(lecture))
                {
                    Professor professorInfo = new Professor(field[1].trim(), field[2].trim(), field[3].trim());
                    professorTemp = professorInfo;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br3 != null) {
                try {
                    br3.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Lecture2 != null) try {
                Lecture2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return professorTemp;
    }


    public ArrayList<Student> studentReader() {
        String[] field = null;
        ArrayList<Student> Students = new ArrayList<>();
        try {
            FileName.trim();
            StudentInfo = new FileInputStream(FileName);
            br1 = new BufferedReader(new InputStreamReader(StudentInfo));
            String line;
            line = br1.readLine();
            while ((line = br1.readLine()) != null)
            {
                field = line.split(",");
                Student temp = new Student(field[0], field[2], field[3], Integer.parseInt(field[1]));
                Students.add(temp);
                attendanceTemp.add(field[0] + "/" + field[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br1 != null) {
                try {
                    br1.close();
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

        return Students;
    }

    public String[] getLecture() {
        List<String> lectureResult = new ArrayList<String>();
        String[] field = null;
        try {
            Lecture = new FileInputStream("Lecture.csv");
            br2 = new BufferedReader(new InputStreamReader(Lecture));
            String line;
            while ((line = br2.readLine()) != null)
            {
                field = line.split(",");
                lectureResult.add(field[0].trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br2 != null) {
                try {
                    br2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Lecture != null) try {
                Lecture.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        String[] resultArray = new String[lectureResult.size()];
        lectureResult.toArray(resultArray);
        return resultArray;
    }

}
