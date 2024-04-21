package kenny.stream.cases;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class CaseFour {
    @Data
    @AllArgsConstructor
    class Order {
        private Integer orderId;
        private String accountId;
    }

    public List<Order> selectFromDB(List<String> accountIds) {
        ArrayList<Order> orderList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            orderList.add(new Order(i, accountIds.get(i % accountIds.size())));
        }
        return orderList;
    }
}
