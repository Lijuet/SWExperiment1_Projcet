package Functions;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

class mailSending extends Thread {
    Email email;

    public mailSending(Email email){ this.email = email; }

    public void run () {
        try {
            Socket soc = new Socket("localhost", 5000);

            OutputStream os = soc.getOutputStream ();
            ObjectOutputStream dos = new ObjectOutputStream (os);

            dos.reset();
            dos.writeObject(email);
            System.out.println ("Message is successfully sent!");

            dos.flush();
            dos.close();
            soc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}