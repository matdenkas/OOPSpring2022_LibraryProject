package DataClasses;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LibraryEmployee extends LibraryActor {
    private double hourlyPay;

    /**
     * Library Employee is a employee of the library c
     * and can do more because of that
     * @param id system id
     * @param name name of the employee
     * @param username username
     * @param password password
     * @param address physical adress
     * @param hourlyPay how much they are paid
     */
    public LibraryEmployee(int id, String name, String username, String password, String address, double hourlyPay) {
        super.id = id;
        super.name = name;
        super.username = username;
        super.password = password;
        super.address = address;
        this.hourlyPay = hourlyPay;
    }

    /**
     * checks out an item for a due date
     * @param item
     * @param dueDate
     */
    public void checkOut(MediaEntry item, LocalDateTime dueDate) {
       super.addCheckOut(item, dueDate);
    }

    /**
     * removes the item from the check out list
     * @param item
     */
    public void returnItem(MediaEntry item) {
        super.removeCheckOut(item);
    }
}
