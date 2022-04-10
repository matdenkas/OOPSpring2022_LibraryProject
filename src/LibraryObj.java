import java.time.*;

public class LibraryObj {
    protected int id;
    private LocalDateTime dateCreated;

    LibraryObj() {
        this.id = -1;
        this.dateCreated = LocalDateTime.now();
    }

    LibraryObj(int id) {
        this.id = id;
        this.dateCreated = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
}
