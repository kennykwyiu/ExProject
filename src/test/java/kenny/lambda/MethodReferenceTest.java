package kenny.lambda;

import kenny.lambda.cart.Sku;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MethodReferenceTest {
    static class Sku {
        private String skuName;
        private Integer skuPrice;

        public Integer getSkuPrice() {
            return this.skuPrice;
        }

        public static int staticComparePrice(Sku sku1, Sku sku2) {
            return sku1.getSkuPrice() - sku2.getSkuPrice();
        }

        public int instanceComparePrice(Sku sku) {
            return this.getSkuPrice() - sku.getSkuPrice();

        }

    }

    class PriceComparator {
        public int instanceComparePrice(Sku sku1, Sku sku2) {
            return sku1.getSkuPrice() - sku2.getSkuPrice();
        }

    }


    public void test() {
        List<Sku> skuList = new ArrayList<>();
        skuList.sort((sku1, sku2) ->
                sku1.getSkuPrice() - sku2.getSkuPrice());

        // ClassName::static method
        skuList.sort(Sku::staticComparePrice);

        //
        skuList.sort((Sku sku1, Sku sku2) -> {
            return Sku.staticComparePrice(sku1, sku2);
        });

        PriceComparator priceComparator = new PriceComparator();
        // Object::instanceMethodName
        skuList.sort(priceComparator::instanceComparePrice);
        skuList.sort((Sku sku1, Sku sku2) -> {
                    return priceComparator.instanceComparePrice(sku1, sku2);
                }
        );

        // ClassName::instanceMethodName
        skuList.sort(Sku::instanceComparePrice);
        //
        skuList.sort((Sku object, Sku sku) -> {
            return object.instanceComparePrice(sku);
        });

        Optional.ofNullable(skuList)
                .orElseGet(ArrayList::new);
    }

}
