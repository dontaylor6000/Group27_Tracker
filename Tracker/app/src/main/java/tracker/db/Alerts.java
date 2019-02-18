package tracker.db;

import java.util.Date;

public class Alerts {
    private int trackerId;
    private Date datetime;

    public Alerts() {
    }

    public Alerts(int trackerId, Date datetime) {
        this.trackerId = trackerId;
        this.datetime = datetime;
    }

    public int getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(int trackerId) {
        this.trackerId = trackerId;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
