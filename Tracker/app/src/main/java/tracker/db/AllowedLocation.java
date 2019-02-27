package tracker.db;

public class AllowedLocation {
    private String locationCode;

    public AllowedLocation() {
    }

    public AllowedLocation(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }
}
