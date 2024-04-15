package kenny.stream;

import com.alibaba.fastjson.JSON;
import kenny.lambda.cart.CartService;
import kenny.lambda.cart.Sku;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollector {
    List<Sku> list;

    @Before
    public void init() {
        list = CartService.getCartSkuList();
    }
    @Test
    public  void  toLIst() {

        List<Sku> result = list.stream().filter(sku -> sku.getTotalPrice() > 100)
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(result, true));
    }

    @Test
    public void group() {
        Map<Enum, List<Sku>> group = list.stream()
                .collect(Collectors.groupingBy(sku -> sku.getSkuCategory()));

        System.out.println(JSON.toJSONString(group, true));
    }

}
