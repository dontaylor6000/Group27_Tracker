package tracker.db;


class MappingToAllowed {

    private int trackerId;
    private int restrictedId;

    public MappingToAllowed() {
    }

    public MappingToAllowed(int trackerId, int restrictedId) {
        this.trackerId = trackerId;
        this.restrictedId = restrictedId;
    }

    public int getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(int trackerId) {
        this.trackerId = trackerId;
    }

    public int getRestrictedId() {
        return restrictedId;
    }

    public void setRestrictedId(int restrictedId) {
        this.restrictedId = restrictedId;
    }
}
