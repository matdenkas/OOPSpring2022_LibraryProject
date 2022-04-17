package AppDriver;
//TODO::Create data handler class for all Media Entries
    //TODO::search method

//TODO::Create data handler class for all LibraryActors
    //TODO::search method

//TODO::Build normal page
    //TODO::Window to see MediaEntries and check out
    //TODO::Window to add mediaEntries/remove (if employee)
    //TODO::Window to manage clients

//TODO::Build the application Driver
    //TODO::hard coded data
import DataControlers.UserAuthHandler;
import GUI.*;
import DataClasses.*;

import javax.swing.*;

public class ApplicationDriver {

    private static UserAuthHandler userAuthHandler;
    private static LoginPage loginPage;
    public static void main(String[] args) {
        int idRoot = 0;
        userAuthHandler = new UserAuthHandler();
        LibraryEmployee le = new LibraryEmployee(idRoot++, "Mark", "abc", "123", "1234 address town", 12.99);
        LibraryClient lc = new LibraryClient(idRoot++, "John", "qwe", "rty", "4312 address", 6);
        userAuthHandler.addUser(le);
        userAuthHandler.addUser(lc);

        loginPage = new LoginPage();
        loginPage.setVisible(true);
    }

    public static void authTest(String user, String pass) {
        LibraryActor testUser = userAuthHandler.testUser(user, pass);
        if(testUser != null) {
            loginPage.setVisible(false);
            loginPage.dispose();

            MainPage.createAndShowGUI(testUser);
        }
    }
}




