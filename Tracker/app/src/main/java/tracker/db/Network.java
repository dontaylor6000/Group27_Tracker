package tracker.db;


public class Network {

    private String userName;
    private String password;

    public Network() {
    }

    public Network(String userName, String password) {
        this.userName = userName;
        this.password = API.encrypt(password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = API.encrypt(password);
    }
}
