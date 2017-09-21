package seu.controller;

import com.owlike.genson.Genson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import seu.domain.Commodity;
import seu.service.ShopService;

@Controller
public class ShopController {

    @Autowired
    ShopService shopService;

    private Genson genson = new Genson();

    public String getAllGoods() {
        return genson.serialize(shopService.getCommodity());
    }

    public int buyGoods(int goodId) {
        return shopService.purchase(MainController.account, goodId);
    }

    public int addGoods(int id, String name, int prize, int inventory) {
        return shopService.addCommodity(new Commodity(id, name, prize, inventory));
    }

    public int deleteGoods(int id) {
        return 0;
    }

    public int updateGoods(int id, String name, int prize, int inventory) {
        return shopService.updateCommodity(new Commodity(id, name, prize, inventory));
    }
}
