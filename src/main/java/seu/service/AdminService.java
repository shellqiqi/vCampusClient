package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.domain.Admin;
import seu.socket.Client;
import seu.socket.ClientRequest;

import java.util.List;

@Service
public class AdminService {

    private Client client;

    @Autowired
    public void setClient(Client client) {
        this.client = client;
    }

    private String serviceName;

    public AdminService() {
        serviceName = "adminService";
    }

    public int login(int adminID, String password) {
        return (int) client.send(new ClientRequest(serviceName, "login", new Class[]{int.class, String.class}, new Object[]{adminID, password})).getData();
    }

    public String logout() {
        return (String) client.send(new ClientRequest(serviceName, "logout")).getData();
    }

    public int insertAdmin(Admin admin) {
        return (int) client.send(new ClientRequest(serviceName, "insertAdmin", new Class[]{Admin.class}, new Object[]{admin})).getData();
    }

    public int deleteAdmin(int adminID) {
        return (int) client.send(new ClientRequest(serviceName, "deleteAdmin", new Class[]{int.class}, new Object[]{adminID})).getData();
    }

    public int updateAdminPassword(int adminID, String passwd) {
        return (int) client.send(new ClientRequest(serviceName, "updateAdminPassword", new Class[]{int.class, String.class}, new Object[]{adminID, passwd})).getData();
    }

    public int updateAdmin(Admin admin) {
        return (int) client.send(new ClientRequest(serviceName, "updateAdmin", new Class[]{Admin.class}, new Object[]{admin})).getData();
    }

    public Admin queryAdminByAdminId(int adminID) {
        return (Admin) client.send(new ClientRequest(serviceName, "queryAdminByAdminId", new Class[]{int.class}, new Object[]{adminID})).getData();
    }

    public List<Admin> queryAll() {
        return (List<Admin>) client.send(new ClientRequest(serviceName, "queryAll")).getData();
    }
}
