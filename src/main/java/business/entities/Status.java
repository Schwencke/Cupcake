package business.entities;

public class Status {
    int statusId;
    String name;

    public Status(int statusId, String name) {
        this.statusId = statusId;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
