package DataClasses;

public class MediaEntry extends LibraryObj {
    private boolean available;
    protected String isbn;

    MediaEntry() {
        this.available = true;
        this.isbn = null;
    }

    MediaEntry(int id, String isbn){
        super.id = id;
        this.available = true;
        this.isbn = isbn;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable(){
        return this.available;
    }

    public String getIsbn() {
        return isbn;
    }
}
