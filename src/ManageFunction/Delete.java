package ManageFunction;

import java.io.*;

public class Delete {
    FileInputStream StudentDelete;
    BufferedReader br = null;
    int studentNumber;
    String FileName;

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
            br = new BufferedReader(new InputStreamReader(StudentDelete));
            String line;

            while((line = br.readLine()) != null)
            {
                String[] field = line.split(",");
                if(!field[1].equals(String.valueOf(studentNumber)))
                {
                    dummy += (line.trim() + "\r\n" );
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
}
