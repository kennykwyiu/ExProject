package kenny.lambda.cart;

public enum SkuCategoryEnum {
    CLOTHING(10,"CLOTHING"),
    ELECTRONICS(20, "ELECTRONICS"),
    SPORTS(30, "SPORTS"),
    BOOKS(40, "BOOKS");

    private Integer code;
    private  String name;

    SkuCategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
