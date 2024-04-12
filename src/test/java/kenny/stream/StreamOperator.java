package kenny.stream;

import com.alibaba.fastjson.JSON;
import kenny.lambda.cart.CartService;
import kenny.lambda.cart.Sku;
import kenny.lambda.cart.SkuCategoryEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
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

    // change the return type
    @Test
    public void mapTest() {
        list.stream()
                .map(sku -> sku.getSkuName())
                .forEach(x -> System.out.println(JSON.toJSONString(x, true)));
    }

    @Test
    public void flatMapTest() {
        list.stream()
                .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(x -> System.out.println(JSON.toJSONString(x, true)));
    }

    @Test
    public void peek(){
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()) )
                .forEach(x -> System.out.println(JSON.toJSONString(x, true)));
    }

    @Test
    public void sortTest(){
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .forEach(x -> System.out.println(JSON.toJSONString(x, true)));
    }
}
