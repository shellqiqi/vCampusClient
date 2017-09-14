package seu.service;

import org.springframework.stereotype.Service;
import seu.domain.Commodity;

import java.util.List;
@Service
public class ShopService {

    //添加商品信息
    public int addCommodity(Commodity comm){
        return 0;
    }

    public int addCommodity(int id, String name, int prize, int inventory ){
        return 0;
    }

    //删除商品信息
    public int deleteCommodityById(int id){
        return 0;
    }

    //更改商品库存
    public int changeInventoryById(int id,int inventory){
        return 0;
    }

    //更改商品价格
    public int changePriceById(int id, int price){
        return 0;
    }

    //获取商品信息
    public String getCommodityNameById(int id){
        return null;
    }

    public List<Commodity> getCommodityById(int id){
        return null;
    }

    public List<Commodity> getCommodity(){
        return null;
    }
}
