package config.master.config.master.model;

public enum Status {
    NEED,
    IN_PROGRESS,
    DONE;

    public static Status fromString(String status) {
        try {
            return Status.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            return NEED;
        }
    }

    public static boolean isValid(String status) {
        try {
            Status.valueOf(status.toUpperCase());
            return true;
        } catch (IllegalArgumentException | NullPointerException e) {
            return false;
        }
    }
}