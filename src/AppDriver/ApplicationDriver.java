package AppDriver;
//TODO::Create data handler class for all LibraryActors
    //TODO::search method

//TODO::Build normal page
    //TODO::Window to see MediaEntries and check out/
    //TODO::Window to add mediaEntries/remove (if employee)/
    //TODO::Window to manage clients


import DataControlers.CatalogRefrence;
import DataControlers.MediaCatalogHandler;
import DataControlers.UserAuthHandler;
import GUI.*;
import DataClasses.*;

public class ApplicationDriver {

    private static UserAuthHandler userAuthHandler;
    private static LoginPage loginPage;
    private static CatalogRefrence catalogRefrence;
    private static int idRoot;

    public static void main(String[] args) {
        idRoot = 0;
        userAuthHandler = new UserAuthHandler();
        LibraryEmployee le = new LibraryEmployee(idRoot++, "Mark", "abc", "123", "1234 address town", 12.99);
        LibraryClient lc = new LibraryClient(idRoot++, "John", "qwe", "rty", "4312 address", 6);
        userAuthHandler.addUser(le);
        userAuthHandler.addUser(lc);

        catalogRefrence = new MediaCatalogHandler();
        OnlineMedia om = new OnlineMedia(idRoot++, "12345", "HTTPS://realTrustworthySite.com", MediaTypes.ARTICLE, "Why this group should get an A");
        OnSiteMedia osm = new OnSiteMedia(idRoot++, "A10304", "AB12.1", MediaTypes.BOOK, "500 Reasons How This Group Did an Awesome Job");
        catalogRefrence.addMedia(om);
        catalogRefrence.addMedia(osm);

        loginPage = new LoginPage();
        loginPage.setVisible(true);
    }

    public static void authTest(String user, String pass) {
        LibraryActor testUser = userAuthHandler.testUser(user, pass);
        if(testUser != null) {
            loginPage.setVisible(false);
            loginPage.dispose();

            new MainPage(catalogRefrence, testUser);
        }
    }

    public static CatalogRefrence getCatalogRefrence() {
        return catalogRefrence;
    }

    public static int getIdNum() { return idRoot++; }

    public static UserAuthHandler getUserAuthHandler() { return userAuthHandler; }
}




