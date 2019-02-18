package tracker.db;


public class Trackers {
    private String serialNum;
    private String patient;
    private String location;
    private String customName;
    private String batteryFlag;

    public Trackers() {
    }

    public Trackers(String serialNum, String patient, String location, String customName, String batteryFlag) {
        this.serialNum = serialNum;
        this.patient = patient;
        this.location = location;
        this.customName = customName;
        this.batteryFlag = batteryFlag;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getBatteryFlag() {
        return batteryFlag;
    }

    public void setBatteryFlag(String batteryFlag) {
        this.batteryFlag = batteryFlag;
    }


}
