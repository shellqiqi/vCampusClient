package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.domain.Library;
import seu.socket.Client;
import seu.socket.ClientRequest;

import java.util.List;

@Service
public class LibraryService {

    private Client client;

    @Autowired
    public void setClient(Client client) {
        this.client = client;
    }

    private String serviceName;

    public LibraryService() {
        serviceName = "libraryService";
    }

    public int borrowBook(int studentID, int bookID) {
        return (int) client.send(new ClientRequest(serviceName, "borrowBook", new Class[]{int.class, int.class}, new Object[]{studentID, bookID})).getData();
    }

    public int returnBook(int bookID) {
        return (int) client.send(new ClientRequest(serviceName, "returnBook", new Class[]{int.class}, new Object[]{bookID})).getData();
    }

    //续借
    public int reNewBook(int bookID) {
        return (int) client.send(new ClientRequest(serviceName, "reNewBook", new Class[]{int.class}, new Object[]{bookID})).getData();
    }

    //学生查询自己借的所有书
    public List<Library> getAllBookList(int studentID) {
        return (List<Library>) client.send(new ClientRequest(serviceName, "getAllBookList", new Class[]{int.class}, new Object[]{studentID})).getData();
    }

    //管理员删除借书记录，以及图书
    public int deleteBook(int bookID) {
        return (int) client.send(new ClientRequest(serviceName, "deleteBook", new Class[]{int.class}, new Object[]{bookID})).getData();
    }

    public List<Library> getBookByBookName(String bookName) {
        return (List<Library>) client.send(new ClientRequest(serviceName, "getBookByBookName", new Class[]{String.class}, new Object[]{bookName})).getData();
    }

    //学生通过图书id获取所借图书信息
    public Library getBookByBookId(int id) {
        return (Library) client.send(new ClientRequest(serviceName, "getBookByBookId", new Class[]{int.class}, new Object[]{id})).getData();
    }

    //学生通过学生id获取图书
    public List<Library> getBooksByStudentId(int studentId) {
        return (List<Library>) client.send(new ClientRequest(serviceName, "getBooksByStudentId", new Class[]{int.class}, new Object[]{studentId})).getData();
    }

    //管理员更新图书信息
    public int updateBook(Library book) {
        return (int) client.send(new ClientRequest(serviceName, "updateBook", new Class[]{Library.class}, new Object[]{book})).getData();
    }

    //管理员获取所有学生所借图书全部信息
    public List<Library> getLibraryAll() {
        return (List<Library>) client.send(new ClientRequest(serviceName, "getLibraryAll")).getData();
    }
}
