package kenny.stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;

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
}
