
package DataControlers;
import DataClasses.MediaEntry;

import javax.swing.*;

public interface CatalogRefrence {
    JPanel getMediaItem(String title);
    JPanel[] getAllMediaItems();
    JPanel[] medeaItemSearch(String title);
    void addMedia(MediaEntry entry);
}

