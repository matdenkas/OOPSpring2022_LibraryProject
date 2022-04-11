import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class LibraryActor extends LibraryObj {
    protected String name; //First Last
    protected String username;
    protected String password;
    protected String address;
    protected LocalDate dob;
    private final ArrayList<CheckOut> checkOutEntries;

    LibraryActor(){
        this.name = null;
        this.username = null;
        this.password = null;
        this.address = null;
        this.dob = null;
        this.checkOutEntries = new ArrayList<CheckOut>();
    }

    LibraryActor(String name) {
        this.name = name;
        this.checkOutEntries = new ArrayList<CheckOut>();
    }

    public String getName() {
        return name;
    }

    //TODO handle IllegalArgumentException when duedate is before now in GUI
    protected void addCheckOut(MediaEntry item, LocalDateTime dueDate) throws IllegalArgumentException {
        this.checkOutEntries.add(new CheckOut(item, dueDate)); //add the item to the list of checked out items
        item.setAvailable(false); //mark it as unavailable
    }

    //TODO handle RuntimeException("NoObjectFound") in GUI
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
