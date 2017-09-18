package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.domain.Commodity;
import seu.socket.Client;
import seu.socket.ClientRequest;

import java.util.List;

@Service
public class ShopService {

    private Client client;

    @Autowired
    public void setClient(Client client) {
        this.client = client;
    }

    private String serviceName;

    public ShopService() {
        serviceName = "shopService";
    }

    public int updatePrice(int commodityID, int price) {
        return (int) client.send(new ClientRequest(serviceName, "updatePrice", new Class[]{int.class, int.class}, new Object[]{commodityID, price})).getData();
    }

    public int updateInventory(int commodityID, int price) {
        return (int) client.send(new ClientRequest(serviceName, "updateInventory", new Class[]{int.class, int.class}, new Object[]{commodityID, price})).getData();
    }

    public int updateCommodity(Commodity commodity) {
        return (int) client.send(new ClientRequest(serviceName, "updateCommodity", new Class[]{Commodity.class}, new Object[]{commodity})).getData();
    }

    //学生购物
    public int purchase(int studentID, int commodityID) {
        return (int) client.send(new ClientRequest(serviceName, "purchase", new Class[]{int.class, int.class}, new Object[]{studentID, commodityID})).getData();
    }

    //管理员获取某个商品信息
    public Commodity getCommodityById(int id) {
        return (Commodity) client.send(new ClientRequest(serviceName, "getCommodityById", new Class[]{int.class}, new Object[]{id})).getData();
    }

    //管理员添加商品信息
    public int addCommodity(Commodity comm) {
        return (int) client.send(new ClientRequest(serviceName, "addCommodity", new Class[]{Commodity.class}, new Object[]{comm})).getData();
    }

    //学生获取所有商品的信息
    public List<Commodity> getCommodity() {
        return (List<Commodity>) client.send(new ClientRequest(serviceName, "getCommodity")).getData();
    }
}