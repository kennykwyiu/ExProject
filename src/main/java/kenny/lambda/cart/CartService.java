package kenny.lambda.cart;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private static List<Sku> cartSkuList = new ArrayList<Sku>() {
        {
            add(new Sku(654032, "drone", 4999.00, 1, 4999.00, SkuCategoryEnum.ELECTRONICS));
            add(new Sku(642934, "VR", 2299.00, 1, 2299.0000, SkuCategoryEnum.ELECTRONICS));
            add(new Sku(645321, "Shirt", 409.00, 3, 1227.00, SkuCategoryEnum.CLOTHING));
            add(new Sku(654327, "Jeans", 528.00, 1, 528.00, SkuCategoryEnum.CLOTHING));
            add(new Sku(675489, "Treadmill", 2699.00, 1, 2699.00, SkuCategoryEnum.SPORTS));
            add(new Sku(644564, "Java Programming Logic", 79.80, 1, 79.80, SkuCategoryEnum.BOOKS));
            add(new Sku(678678, "Java Core Tech", 149.00, 1, 149.00, SkuCategoryEnum.BOOKS));
            add(new Sku(697894, "Algo", 78.20, 1, 78.20, SkuCategoryEnum.BOOKS));
            add(new Sku(696968, "TensorFlow Master Course", 85.10, 1, 85.10, SkuCategoryEnum.BOOKS));
        }
    };

    public  static List<Sku> getCartSkuList() {
        return cartSkuList;
    }

    /**
     * Version 1.0.0
     * @param cartSkuList
     * @return
     */
    public static List<Sku> filterElectronicsSkus(List<Sku> cartSkuList) {
        List<Sku> result = new ArrayList<Sku>();
        for (Sku sku:cartSkuList             ) {
            if (SkuCategoryEnum.ELECTRONICS.equals(sku.getSkuCategory())) {
                result.add(sku);
            }
        }
        return result;
    }

    /**
     * Version 2.0.0
     * @param cartSkuList
     * @param categoryEnum
     * @return
     */
    public static  List<Sku> filterSkusByCategory(List<Sku> cartSkuList, SkuCategoryEnum categoryEnum) {
        List<Sku> result = new ArrayList<Sku>();
        for (Sku sku:cartSkuList             ) {
            if (categoryEnum.equals(sku.getSkuCategory())) {
                result.add(sku);
            }
        }
        return result;
    }

    /**
     * Version 3.0.0
     * @param cartSkuList
     * @param categoryEnum
     * @param totalPrice
     * @param categoryOrPrice - true: category, false: totalPrice
     * @return
     */
    public static  List<Sku> filterSkus(List<Sku> cartSkuList,
                                                  SkuCategoryEnum categoryEnum,
                                                  Double totalPrice,
                                                  Boolean categoryOrPrice) {
        List<Sku> result = new ArrayList<Sku>();
        for (Sku sku:cartSkuList             ) {
            if ( categoryOrPrice && categoryEnum.equals(sku.getSkuCategory())
                    ||
                    !categoryOrPrice && sku.getTotalPrice() > totalPrice) {
                result.add(sku);
            }
        }
        return result;
    }

}
