package DataClasses;

public class OnSiteMedia extends MediaEntry {

    private final String location;
    private final MediaTypes type;

    public OnSiteMedia(int id, String isbn, String location, MediaTypes type, String name) {
        super.id = id;
        super.isbn = isbn;
        super.name = name;
        this.location = location;
        this.type = type;;
    }

    public String getLocation() {
        return location;
    }

    public MediaTypes getType() {
        return type;
    }

}
