package kenny.stream;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

public class ReduceAndCollectTest {

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
    }
}
