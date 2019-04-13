package tracker.db;


class MappingToAllowed {

    private String trackerId;
    private String restrictedId;

    public MappingToAllowed() {
    }

    public MappingToAllowed(String trackerId, String restrictedId) {
        this.trackerId = trackerId;
        this.restrictedId = restrictedId;
    }

    public String getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(String trackerId) {
        this.trackerId = trackerId;
    }

    public String getRestrictedId() {
        return restrictedId;
    }

    public void setRestrictedId(String restrictedId) {
        this.restrictedId = restrictedId;
    }
}
