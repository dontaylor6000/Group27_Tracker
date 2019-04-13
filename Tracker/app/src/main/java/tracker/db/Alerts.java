package tracker.db;

import java.util.Date;

public class Alerts {
    private String trackerId;
    private Date datetime;

    public Alerts() {
    }

    public Alerts(String trackerId, Date datetime) {
        this.trackerId = trackerId;
        this.datetime = datetime;
    }

    public String getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(String trackerId) {
        this.trackerId = trackerId;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
