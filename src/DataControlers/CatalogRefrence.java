
package DataControlers;
import DataClasses.MediaEntry;

import javax.swing.*;

public interface CatalogRefrence {

    JPanel[] getAllMediaItems();
    JPanel medeaItemSearch(String title);
    void addMedia(MediaEntry entry);
    void deleteItemByTitle(String title);
}

