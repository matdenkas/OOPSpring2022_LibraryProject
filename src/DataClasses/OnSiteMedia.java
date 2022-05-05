package DataClasses;

/**
 * On sitem media is a piece of media we actually in the library
 */
public class OnSiteMedia extends MediaEntry {

    private final String location;
    private final MediaTypes type;

    /**
     * OnSite Media constructor
     * @param id system id
     * @param isbn isbn id
     * @param location the place in the library where it is
     * @param type the type of media
     * @param name name/title
     */
    public OnSiteMedia(int id, String isbn, String location, MediaTypes type, String name) {
        super.id = id;
        super.isbn = isbn;
        super.name = name;
        this.location = location;
        this.type = type;;
    }

    //getters and setters
    public String getLocation() {
        return location;
    }

    public MediaTypes getType() {
        return type;
    }

}
