package DataClasses;

/**
 * a media entry is an item that the library has
 */
public class MediaEntry extends LibraryObj {
    private boolean available;
    protected String isbn;
    protected String name;

    /**
     * default constructors
     */
    MediaEntry() {
        this.available = true;
        this.isbn = null;
        this.name = null;
    }

    /**
     * Constructor
     * @param id system id
     * @param isbn isbn of the item
     */
    MediaEntry(int id, String isbn){
        super.id = id;
        this.available = true;
        this.isbn = isbn;
    }


    //getters and setters
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable(){
        return this.available;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() { return name; }
}
