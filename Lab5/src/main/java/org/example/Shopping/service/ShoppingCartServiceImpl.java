package org.example.Shopping.service;

import org.example.Shopping.db.DB;
import org.example.Shopping.entity.Item;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    public static Map<Integer, Item> map = new HashMap<>();

    @Override
    public Item add(Integer id) {
        // Kiểm tra xem sản phẩm đã có trong giỏ hàng cá nhân chưa
        Item itemInCart = map.get(id);

        if (itemInCart != null) {
            itemInCart.setQty(itemInCart.getQty() + 1);
            return itemInCart;
        } else {
            Item productFromDB = DB.items.get(id);

            if (productFromDB != null) {
                Item newItemForCart = new Item(id, productFromDB.getName(), productFromDB.getPrice(), 1);
                map.put(id, newItemForCart);
                return newItemForCart;
            } else {
                return null;
            }
        }
    }

    @Override
    public void remove (Integer id){
        map.remove(id);
    }

    @Override
    public Item update(Integer id, int qty){
        Item item = map.get(id);
        item.setQty(qty);
        return item;
    }

    @Override
    public void clear(){
        map.clear();
    }

    @Override
    public Collection<Item> getItems(){
        return map.values();
    }

    @Override
    public int getCount(){
        return map.values().stream().mapToInt(Item::getQty).sum();
    }

    @Override
    public double getAmount(){
        return map.values().stream().mapToDouble(item -> item.getQty() * item.getPrice()).sum();
    }
}
