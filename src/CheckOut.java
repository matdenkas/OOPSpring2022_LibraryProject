import java.time.LocalDateTime;

public class CheckOut {
    private MediaEntry item;
    private final LocalDateTime dateCreated;
    private LocalDateTime dueDate;

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
