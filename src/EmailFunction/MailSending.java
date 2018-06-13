package EmailFunction;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

class MailSending extends Thread {
    Email email;

    public MailSending(Email email){ this.email = email; }

    public void run () {
        try {
            Socket soc = new Socket("192.168.79.1", 5000);

            OutputStream os = soc.getOutputStream ();
            ObjectOutputStream dos = new ObjectOutputStream (os);

            dos.reset();
            dos.writeObject(email);//send an email object
            System.out.println ("Message is successfully sent!");

            dos.flush();
            dos.close();
            soc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}