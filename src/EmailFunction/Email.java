package EmailFunction;

import java.io.Serializable;
import java.util.ArrayList;

public class Email implements Serializable {
    private String name;
    private int id;
    private String message;

    public void setName(String name) { this.name = name; }
    public void setId(int id) { this.id = id; }
    public void setMessage(ArrayList<String> contents) {//make multiple lines one line message
        message = "";
        for(String str : contents) { message += str + "\n"; }
    }

    public String getName() { return name; }
    public int getId(){ return id; }
    public String getMessage() { return message; }
}
