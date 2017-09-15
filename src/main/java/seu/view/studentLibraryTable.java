package seu.view;

/**
 * Created by Q on 2017/9/13.
 */
public class studentLibraryTable {
    private String bookName;
    private int bookID;
    private String startDate;

    public studentLibraryTable(String bookName, int bookID, String startDate) {
        this.bookName = bookName;
        this.bookID = bookID;
        this.startDate = startDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
