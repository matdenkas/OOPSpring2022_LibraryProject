package DataClasses;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LibraryEmployee extends LibraryActor {
    private double hourlyPay;

    LibraryEmployee(int id, String name, String username, String password, String address, LocalDate dob, double hourlyPay) {
        super.id = id;
        super.name = name;
        super.username = username;
        super.password = password;
        super.address = address;
        super.dob = dob;
        this.hourlyPay = hourlyPay;
    }

    public void checkOut(MediaEntry item, LocalDateTime dueDate) {
       super.addCheckOut(item, dueDate);
    }

    public void returnItem(MediaEntry item) {
        super.removeCheckOut(item);
    }
}
