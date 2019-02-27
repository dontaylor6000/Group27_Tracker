package tracker.backgroundsvc;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class Connection {
    private ServerSocket sock;

    public Connection(int port, int backlog, InetAddress addr) {
        try {
            this.sock = new ServerSocket(port, backlog, addr);
            this.sock.accept();
        } catch (IOException e) {

        }
    }
}
