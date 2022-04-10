public class OnlineMedia extends MediaEntry {
    private final String link;
    private final MediaTypes type;
    private final String name;

    OnlineMedia(int id, String isbn, String link, MediaTypes type, String name) {
        super.id = id;
        super.isbn = isbn;
        this.link = link;
        this.type = type;
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public MediaTypes getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
