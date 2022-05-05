
package DataControlers;
import DataClasses.MediaEntry;

import javax.swing.*;

/**
 * This interface is the interface between the GUI and
 *
 */
public interface CatalogRefrence {

    JPanel[] getAllMediaItems(); //gets panels for every media itme in the catalog
    JPanel medeaItemSearch(String title); //returns a panel for a searched item
    void addMedia(MediaEntry entry); //adds a piece of media
    void deleteItemByTitle(String title); //deletes an item from the catalog given its title
}

