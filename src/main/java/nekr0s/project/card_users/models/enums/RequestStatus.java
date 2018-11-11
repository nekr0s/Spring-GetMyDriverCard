package nekr0s.project.card_users.models.enums;

public enum RequestStatus {
    REQUEST_NEW,
    REQUEST_APPROVED,
    REQUEST_DISAPPROVED,
    REQUEST_WAITING;

    public String readableName() {
        switch (this) {
            case REQUEST_NEW:
                return "renewed!";
            case REQUEST_WAITING:
                return "added to waiting list!";
            case REQUEST_APPROVED:
                return "approved!";
            case REQUEST_DISAPPROVED:
                return "disapproved :(";
        }
        return null;
    }
}
