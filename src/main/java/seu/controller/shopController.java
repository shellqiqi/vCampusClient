package seu.controller;

import com.owlike.genson.Genson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import seu.service.ShopService;

@Controller
public class shopController {

    @Autowired
    ShopService shopService;

    Genson genson = new Genson();

    public String getAllGoods() {
        return genson.serialize(shopService.getCommodity());
    }

    public int buyGoods(int goodId) {
        return shopService.purchase(MainController.account, goodId);
    }

}
