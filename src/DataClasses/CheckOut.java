package DataClasses;

import java.time.LocalDateTime;
/*
Class CheckOut
    This class is a single instance of a checked out item
 */

public class CheckOut {
    private MediaEntry item;
    private final LocalDateTime dateCreated;
    private LocalDateTime dueDate;

    /**
     * CheckOut constructor
     * @param mediaEntryId The entry being checked out
     * @param dueDate When its due
     */
    CheckOut(MediaEntry mediaEntryId, LocalDateTime dueDate){
        this.item = mediaEntryId;
        this.dateCreated = LocalDateTime.now();
        setDueDate(dueDate);
    }

    public MediaEntry getItem() {
        return item;
    }
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    /**
     * Metod setDueDate
     * Sets the dueDate for this checked out entry
     * @param dueDate
     */
    public void setDueDate(LocalDateTime dueDate) {

        //if a DueDate is before today it makes no sense
        if(dueDate.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException();
        }
        else {
            this.dueDate = dueDate;
        }
    }
}
