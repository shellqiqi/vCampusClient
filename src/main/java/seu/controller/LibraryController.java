package seu.controller;

import com.owlike.genson.Genson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import seu.service.LibraryService;

@Controller
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    private Genson genson = new Genson();

    public String getBorrowedBooks() {
        return genson.serialize(libraryService.getAllBookList(MainController.account));
    }

    public String getAvailableBooks() {
        return genson.serialize(libraryService.getAllAvailableBook());
    }

    public String getAllBooks() {
        return genson.serialize(libraryService.getLibraryAll());
    }

    public int addBook(int bookId, String bookName) {
        return libraryService.insertBook(bookId, bookName);
    }

    public int deleteBook(int bookId) {
        return libraryService.deleteBook(bookId);
    }

    public int borrowBook(int bookId) {
        return libraryService.borrowBook(MainController.account, bookId);
    }

    public int returnBook(int bookId) {
        return libraryService.returnBook(bookId);
    }
}
