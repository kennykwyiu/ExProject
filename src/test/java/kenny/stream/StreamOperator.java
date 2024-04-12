package kenny.stream;

import com.alibaba.fastjson.JSON;
import kenny.lambda.cart.CartService;
import kenny.lambda.cart.Sku;
import kenny.lambda.cart.SkuCategoryEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StreamOperator {

    List<Sku> list;

    @Before
    public void init() {
        list = CartService.getCartSkuList();
    }

    @Test
    public void filterTest() {
        list.stream()
                .filter(sku -> SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                .forEach(x -> System.out.println(JSON.toJSONString(x, true)));
    }
}
