package kenny.stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ReduceAndCollectTest {

    @Test
    public void reduceTest() {
        @Data
        @AllArgsConstructor
        class Order {
            private Integer id;
            private Integer productCount;
            private Double totalAmount;
        }

        ArrayList<Order> list = Lists.newArrayList();
        list.add(new Order(1, 2, 25.12));
        list.add(new Order(2, 5, 257.23));
        list.add(new Order(3, 3, 23332.12));

        /*
        1. count the total product qty
        2. count the total amount
         */

        Order order = list.stream()
                .reduce(
                        new Order(0, 0, 0.0),
                        (Order order1, Order order2) -> {
                            int productCount = order1.getProductCount() + order2.getProductCount();
                            double totalAmount = order1.getTotalAmount() + order2.getTotalAmount();
                            return new Order(0, productCount, totalAmount);
                        },
                        (Order order1, Order order2) -> {
                            int productCount = order1.getProductCount() + order2.getProductCount();
                            double totalAmount = order1.getTotalAmount() + order2.getTotalAmount();
                            return new Order(0, productCount, totalAmount);
                        });

        System.out.println(JSON.toJSONString(order, true));
    }

    @Test
    public void collectTest() {
        @Data
        @AllArgsConstructor
        class Order {
            private Integer id;
            private String account;
            private Integer productCount;
            private Double totalAmount;
        }

        ArrayList<Order> list = Lists.newArrayList();
        list.add(new Order(1, "Peter", 2, 25.12));
        list.add(new Order(2, "Peter", 5, 257.23));
        list.add(new Order(3, "Liz", 3, 23332.12));

        HashMap<String, Order> collect = list.stream()
                .parallel()
                .collect(
                        () -> {
                            System.out.println("execute collect stream!!!");
                            return new HashMap<String, Order>();
                        },
                        (HashMap<String, Order> map, Order newOrder) -> {
                            System.out.println("execute add new elements into collect");

                            String account = newOrder.getAccount();
                            if (map.containsKey(account)) {
                                Order order = map.get(account);
                                order.setProductCount(newOrder.getProductCount() + order.getProductCount());
                                order.setTotalAmount(newOrder.getTotalAmount() + order.getTotalAmount());


                            } else {
                                map.put(account, newOrder);
                            }
                        },
                        (HashMap<String, Order> map1, HashMap<String, Order> map2) -> {
                            System.out.println("execute parallel merge");

                            map2.forEach((key, value) -> {
                                map1.merge(key, value, (order1, order2) -> {
                                    return new Order(0, key, order1.getProductCount() + order2.getProductCount(),
                                            order1.getTotalAmount() + order2.getTotalAmount());
                                });
                            });
                        });

        System.out.println(JSON.toJSONString(collect, true));
    }
}
