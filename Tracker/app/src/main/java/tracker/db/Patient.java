package tracker.db;

public class Patient {
    private String first;
    private String last;
    private int locationId;

    public Patient() {
    }

    public Patient(String first, String last, int locationId) {
        this.first = first;
        this.last = last;
        this.locationId = locationId;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}

