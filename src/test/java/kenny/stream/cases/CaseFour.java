package kenny.stream.cases;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CaseFour {
    @Data
    @AllArgsConstructor
    class Order {
        private Integer orderId;
        private String accountId;
    }
}
