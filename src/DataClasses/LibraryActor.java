package DataClasses;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Class Library Actor
 * A single person that can log in into the system
 */
public class LibraryActor extends LibraryObj {
    protected String name; //First Last
    protected String username;
    protected String password;
    protected String address;
    private final ArrayList<CheckOut> checkOutEntries;

    /**
     * Default constructor
     */
    public LibraryActor(){
        this.name = null;
        this.username = null;
        this.password = null;
        this.address = null;
        this.checkOutEntries = new ArrayList<CheckOut>();
    }

    public String getName() {
        return name;
    }
    public String getUsername() { return username; }
    public String getPassword() {return password; }

    //TODO handle IllegalArgumentException when duedate is before now in GUI
    protected void addCheckOut(MediaEntry item, LocalDateTime dueDate) throws IllegalArgumentException {
        this.checkOutEntries.add(new CheckOut(item, dueDate)); //add the item to the list of checked out items
        item.setAvailable(false); //mark it as unavailable
    }

    /**
     * method removeCheckOut
     * takes a returned item and removes it from the checked out items
     * @param returnItem
     * @throws RuntimeException when the object isn't found
     */
    protected void removeCheckOut(MediaEntry returnItem) throws RuntimeException {
        boolean objFound = false;
        for(CheckOut item : this.checkOutEntries){
            if(Objects.equals(item.getItem().getId(), returnItem.getId())){
                checkOutEntries.remove(item);
                returnItem.setAvailable(true);
                objFound = true;
            }
        }

        if(!objFound){
            throw new RuntimeException("NoObjectFound");
        }
    }

    protected int amntCheckedOut(){
        return checkOutEntries.size();
    }
}
