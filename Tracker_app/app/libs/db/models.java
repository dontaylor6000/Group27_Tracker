package tracker.db;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Date;
import javax.crypto.Cipher;

/// Cipher crypto = Cipher.getInstance("AES/GCM/NoPadding");
class Users{
    public int id;
    public String userName;
    public String password;
    public String email;
}

class Trackers{
    public int id;
    public String serialNum;
    public String patient;
    public String location;
    public String customName;
    public String batteryFlag;
}

class Alerts{
    public int id;
    public int trackerId;
    public Date datetime;
}

class Network{
    public int id;
    public String userName;
    public String password;
}

class MappingToAllowed{
    public int trackerId;
    public int restrictedId;
}

class AllowedLocation{
    public int id;
    public String locationCode;
}

class Patient{
    public int id;
    public String first;
    public String last;
    public int locationId;
}