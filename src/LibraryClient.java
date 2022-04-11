import java.time.LocalDate;
import java.time.LocalDateTime;

public class LibraryClient extends LibraryActor {
    private int checkOutLimit;
    private double fineAmnt;

    LibraryClient(int id, String name, String username, String password, String address, LocalDate dob, int checkOutLimit){
        super.id = id;
        super.name = name;
        super.username = username;
        super.password = password;
        super.address = address;
        super.dob = dob;
        this.checkOutLimit = checkOutLimit;
    }

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
