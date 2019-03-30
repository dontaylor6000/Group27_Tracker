package tracker.backgroundsvc;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class Connection {

    public Connection(int port, int backlog, InetAddress addr) {
        try {
            ServerSocket sock = new ServerSocket(port, backlog, addr);
            sock.accept();
        } catch (IOException e) {

        }
    }
}
