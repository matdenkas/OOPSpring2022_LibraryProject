package DataClasses;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Library Client class is a none employee client
 */
public class LibraryClient extends LibraryActor {
    private int checkOutLimit;
    private double fineAmnt;

    /**
     * Library client constructor
     * @param id system id
     * @param name clients first and last name
     * @param username username
     * @param password password
     * @param address physical adress of client
     * @param checkOutLimit amnt of items they can checkout
     */
    public LibraryClient(int id, String name, String username, String password, String address, int checkOutLimit){
        super.id = id;
        super.name = name;
        super.username = username;
        super.password = password;
        super.address = address;
        this.checkOutLimit = checkOutLimit;
    }

    //getters and setters
    public int getCheckOutLimit() {
        return checkOutLimit;
    }

    public void setCheckOutLimit(int checkOutLimit) {
        this.checkOutLimit = checkOutLimit;
    }

    public double getFineAmnt() {
        return fineAmnt;
    }

    public void setFineAmnt(double fineAmnt) {
        this.fineAmnt = fineAmnt;
    }

    /**
     * method checkout
     * checks out and item for a given duedate
     * @param item item to check out
     * @param dueDate day its due
     * @throws RuntimeException if they can't check out another item
     */
    public void checkOut(MediaEntry item, LocalDateTime dueDate) throws RuntimeException {
        if(super.amntCheckedOut() >= checkOutLimit) {
            throw new RuntimeException("CheckOutLimitReached");
        }

        super.addCheckOut(item, dueDate);
    }

    public void returnItem(MediaEntry item) {

        super.removeCheckOut(item);
    }
}
