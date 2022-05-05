package DataClasses;

/**
 * OnlineMedia is a piece of media on the internet
 * that we don't physically have in the library
 */
public class OnlineMedia extends MediaEntry {
    private final String link;
    private final MediaTypes type;

    /**
     * Constructor
     * @param id system id
     * @param isbn isbn id
     * @param link web link of where to find it
     * @param type the type of media
     * @param name the name/title of the media
     */
    public OnlineMedia(int id, String isbn, String link, MediaTypes type, String name) {
        super.id = id;
        super.isbn = isbn;
        super.name = name;
        this.link = link;
        this.type = type;
    }

    //getters and setters
    public String getLink() {
        return link;
    }

    public MediaTypes getType() {
        return type;
    }
}
