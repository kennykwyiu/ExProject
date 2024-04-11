package kenny.stream;

import com.alibaba.fastjson.JSON;
import kenny.lambda.cart.CartService;
import kenny.lambda.cart.Sku;
import kenny.lambda.cart.SkuCategoryEnum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamVs {

    /**
     * 1 what's products in the cart
     * 2 buy all book product
     * 3 buy the most expensive of 2 items
     * 4 only need the product name and ttaol price of 2 items
     */

    // use collection
    public void oldCartHandle() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        for (Sku sku : cartSkuList) {
            System.out.println(JSON.toJSONString(sku, true));
        }

        List<Sku> notBooksSkuList = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            if (!SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory())) {
                notBooksSkuList.add(sku);
            }
        }

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
    }

}
