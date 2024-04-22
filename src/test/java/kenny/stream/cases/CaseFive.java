package kenny.stream.cases;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CaseFive {
    @Data
    @AllArgsConstructor
    class Trade {
        private BigDecimal price;
        private LocalDateTime time;
        private Integer count;
        private String type;
    }
}
