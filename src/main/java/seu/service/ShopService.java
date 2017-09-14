package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.CommodityDao;
import seu.domain.Commodity;

import java.util.List;
@Service
public class ShopService {
    @Autowired
    CommodityDao commodityDao;


    public CommodityDao getCommodityDao() {
        return commodityDao;
    }

    public void setCommodityDao(CommodityDao commodityDao) {
        this.commodityDao = commodityDao;
    }

    //添加商品信息
    public int addCommodity(Commodity comm){

    }

    public int addCommodity(int id, String name, int prize, int inventory ){

    }

    //删除商品信息
    public int deleteCommodityById(int id){

    }

    //更改商品库存
    public int changeInventoryById(int id,int inventory){

    }

    //更改商品价格
    public int changePriceById(int id, int price){

    }

    //获取商品信息
    public String getCommodityNameById(int id){

    }

    public List<Commodity> getCommodityById(int id){

    }

    public List<Commodity> getCommodity(){

    }
}
