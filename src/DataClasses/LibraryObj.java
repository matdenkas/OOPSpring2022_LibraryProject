package DataClasses;

import java.time.LocalDateTime;

public class LibraryObj {
    protected int id;
    private final LocalDateTime dateCreated;

    LibraryObj() {
        this.id = Integer.parseInt(null);
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
