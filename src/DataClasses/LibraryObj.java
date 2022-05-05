package DataClasses;

import java.time.LocalDateTime;

/**
 * Library Obj is the root parent of all objects in this system
 */
public class LibraryObj {
    protected int id;
    private final LocalDateTime dateCreated;

    /**
     * default construtor
     */
    LibraryObj() {
        this.id = -1;
        this.dateCreated = LocalDateTime.now();
    }

    /**
     * Takes an id
     * @param id system id
     */
    LibraryObj(int id) {
        this.id = id;
        this.dateCreated = LocalDateTime.now();
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
}
