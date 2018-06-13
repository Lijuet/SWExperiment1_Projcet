package EmailFunction;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

class Server {
    private static ArrayList<Thread> arr = new ArrayList<Thread>();

    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("server is ready");

        while (true) {
            try {
                Socket soc = ss.accept();
                System.out.println("new connection arrived");
                Thread t = new CommThread(soc);
                t.start();
                arr.add(t);
                Iterator<Thread> iter = arr.iterator();
                while (iter.hasNext()) {
                    t = iter.next();
                    if (!t.isAlive()) {
                        iter.remove();
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println("error");
            }
        }
    }
}
