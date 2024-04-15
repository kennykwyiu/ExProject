package kenny.stream;

import com.alibaba.fastjson.JSON;
import kenny.lambda.cart.CartService;
import kenny.lambda.cart.Sku;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class StreamCollector {
    @Test
    public  void  toLIst() {
        List<Sku> list = CartService.getCartSkuList();

        List<Sku> result = list.stream().filter(sku -> sku.getTotalPrice() > 100)
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(result, true));
    }
}
