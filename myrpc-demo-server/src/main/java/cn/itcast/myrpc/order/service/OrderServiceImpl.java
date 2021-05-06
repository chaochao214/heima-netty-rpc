package cn.itcast.myrpc.order.service;

import cn.itcast.myrpc.order.pojo.Item;
import cn.itcast.myrpc.order.pojo.Order;

import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order submitOrder(Long userId, List<Item> itemList) {

        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setDate(System.currentTimeMillis());
        order.setItemCount(itemList.size());
        order.setUserId(userId);

        Long count = 0L;
        for (Item item : itemList) {
            count += item.getPrice();
        }

        order.setTotalPrice(count);

        return order;
    }
}
