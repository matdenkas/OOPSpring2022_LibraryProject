package DataClasses;

public class OnlineMedia extends MediaEntry {
    private final String link;
    private final MediaTypes type;

    public OnlineMedia(int id, String isbn, String link, MediaTypes type, String name) {
        super.id = id;
        super.isbn = isbn;
        super.name = name;
        this.link = link;
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public MediaTypes getType() {
        return type;
    }
}
