package kenny.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class Version6Test {
    @Test
    public void filterSkus() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> result = CartService.filterSkus(cartSkuList, (Sku sku) -> sku.getSkuPrice() > 1000);
        System.out.println(JSON.toJSONString(result, true));

    }
}
