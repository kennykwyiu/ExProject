package kenny.stream;

import com.alibaba.fastjson.JSON;
import kenny.lambda.cart.CartService;
import kenny.lambda.cart.Sku;
import kenny.lambda.cart.SkuCategoryEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

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
    public void peek() {
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(x -> System.out.println(JSON.toJSONString(x, true)));
    }

    @Test
    public void sortTest() {
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .forEach(x -> System.out.println(JSON.toJSONString(x, true)));
    }

    @Test
    public void distinctTest() {
        list.stream()
                .map(sku -> sku.getSkuCategory())
                .distinct()
                .forEach(x -> System.out.println(JSON.toJSONString(x, true)));
    }

    @Test
    public void skipTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(3)
                .forEach(x -> System.out.println(JSON.toJSONString(x, true)));
    }

    @Test
    public void limitTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(1 * 3)
                .limit(3)
                .forEach(x -> System.out.println(JSON.toJSONString(x, true)));
    }

    @Test
    public void allMatchTest() {
        boolean match = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .allMatch(sku -> sku.getTotalPrice() > 100);
        System.out.println(match);
    }

    @Test
    public void anyMatchTest() {
        boolean match = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .anyMatch(sku -> sku.getTotalPrice() > 100);
        System.out.println(match);
    }

    @Test
    public void noneMatchTest() {
        boolean match = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .noneMatch(sku -> sku.getTotalPrice() > 10_000);
        System.out.println(match);
    }

    @Test
    public void findFirstTest() {
        Optional<Sku> optionalSku = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .findFirst();
        System.out.println(JSON.toJSONString(optionalSku.get(), true));
    }

    @Test
    public void findAnyTest() {
        Optional<Sku> optionalSku = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .findAny();
        System.out.println(JSON.toJSONString(optionalSku.get(), true));
    }

    @Test
    public void maxTest() {
        OptionalDouble optionalDouble = list.stream()
                .mapToDouble(Sku::getTotalPrice)
                .max();
        System.out.println(optionalDouble.getAsDouble());
    }

    @Test
    public void minTest() {
        OptionalDouble optionalDouble = list.stream()
                .mapToDouble(Sku::getTotalPrice)
                .min();
        System.out.println(optionalDouble.getAsDouble());
    }


}

