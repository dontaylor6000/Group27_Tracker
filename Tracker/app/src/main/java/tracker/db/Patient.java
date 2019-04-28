package tracker.db;

public class Patient {
    private String first;
    private String last;
    private String locationId;

    public Patient() {
    }

    public Patient(String first, String last, String locationId) {
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

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String toString(){
        String retVal = "First: " + first + " Last: " + last + " LocationId: " + locationId;
        return retVal;
    }
}

