package DataClasses;

public class OnSiteMedia extends MediaEntry {

    private final String location;
    private final MediaTypes type;
    private final String name;

    OnSiteMedia(int id, String isbn, String location, MediaTypes type, String name) {
        super.id = id;
        super.isbn = isbn;
        this.location = location;
        this.type = type;
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public MediaTypes getType() {
        return type;
    }

    public String getName() {
        return name;
    }

}
