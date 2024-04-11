package kenny.stream;

import com.alibaba.fastjson.JSON;
import kenny.lambda.cart.CartService;
import kenny.lambda.cart.Sku;
import kenny.lambda.cart.SkuCategoryEnum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class StreamVs {

    /**
     * 1 what's products in the cart
     * 2 buy all book product
     * 3 buy the most expensive of 2 items
     * 4 only need the product name and ttaol price of 2 items
     */

    // use collection
    @Test
    public void oldCartHandle() {
        // 1
        List<Sku> cartSkuList = CartService.getCartSkuList();
        for (Sku sku : cartSkuList) {
            System.out.println(JSON.toJSONString(sku, true));
        }

        // 2
        List<Sku> notBooksSkuList = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            if (!SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory())) {
                notBooksSkuList.add(sku);
            }
        }

        // 3
        notBooksSkuList.sort(new Comparator<Sku>() {
            @Override
            public int compare(Sku o1, Sku o2) {
                if (o1.getTotalPrice() > o2.getTotalPrice()) {
                    return -1;
                } else if (o1.getTotalPrice() < o2.getTotalPrice()) {
                    return 1;
                }
                return 0;
            }
        });

        List<Sku> top2SkuList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            top2SkuList.add(notBooksSkuList.get(i));
        }

        // 4
        Double money = 0.0;
        for (Sku sku : top2SkuList) {
            money += sku.getTotalPrice();
        }

        List<String> resultSkuNameList = new ArrayList<>();
        for (Sku sku : top2SkuList) {
            resultSkuNameList.add(sku.getSkuName());
        }

        System.out.println(JSON.toJSONString(resultSkuNameList, true));
        System.out.println("Total product price: " + money);
    }

    // by using Stream
    @Test
    public void newCartHandle() {
        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.0));

        List<String> resultSkuNameList = CartService.getCartSkuList()
                .stream()
                // 1
                .peek(sku -> System.out.println(JSON.toJSONString(sku, true)))
                // 2
                .filter(sku -> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                // 3
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                // 4
                .limit(2)
                .peek(sku -> money.set(money.get() + sku.getTotalPrice()))
                .map(sku -> sku.getSkuName())
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(resultSkuNameList, true));
        System.out.println("Total product price: " + money.get());
    }

}
