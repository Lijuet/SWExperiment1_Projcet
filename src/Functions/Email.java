package Functions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Email implements Serializable {
    private String name;
    private int id;
    private String message;

    public void setName(String name) { this.name = name; }
    public void setId(int id) { this.id = id; }
    public void setMessage(ArrayList<String> contents) {
        message = "";
        for(String str : contents) { message += str + "\n"; }
    }

    public String getName() { return name; }
    public int getId(){ return id; }
    public String getMessage() { return message; }
}
