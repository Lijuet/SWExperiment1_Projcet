package Functions;

import java.util.ArrayList;
import java.util.Arrays;

public class Email {
    private String name;
    private int id;
    private String message;

    public void setName(String name) { this.name = name; }
    public void setId(int id) { this.id = id; }
    public void setMessage(ArrayList<String> contents) {
        String[] listingArray = contents.toArray(new String[contents.size()]);
        String listingString = Arrays.toString(listingArray);
    }

    public String getName() { return name; }
    public int getId(){ return id; }
    public String getMessage() { return message; }
}
