package kenny.stream.cases;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Map<String, List<Order>> queryOrderByAccountIds(List<String> accountIds) {
        System.out.println(JSON.toJSONString(selectFromDB(accountIds)));
        return Optional.ofNullable(selectFromDB(accountIds))
                .map(List::stream)
                .orElseGet(Stream::empty)
                .collect(Collectors.groupingBy(order -> order.getAccountId()));
    }

    @Test
    public void test() {
        Map<String, List<Order>> orders = queryOrderByAccountIds(Lists.newArrayList("Peter_3", "Liz_4", "Jay_5"));

        System.out.println(JSON.toJSONString(orders, true));
    }
}
