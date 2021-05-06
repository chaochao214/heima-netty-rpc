package cn.itcast.myrpc.order.service;

import cn.itcast.myrpc.order.pojo.Item;
import cn.itcast.myrpc.order.pojo.Order;

import java.util.List;

public interface OrderService {

    Order submitOrder(Long userId, List<Item> itemList);

}
