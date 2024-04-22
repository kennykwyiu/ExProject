package kenny.stream.cases;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CaseFive {
    @Data
    @AllArgsConstructor
    class Trade {
        private BigDecimal price;
        private LocalDateTime time;
        private Integer count;
        private String type;
    }

    List<Trade> trades;

    @Before
    public void init() {
        trades = new ArrayList<>();

        trades.add(new Trade(new BigDecimal(100),
                LocalDateTime.now().plusSeconds(1),
                500, "Company"));
        trades.add(new Trade(new BigDecimal(101),
                LocalDateTime.now().plusSeconds(2),
                1, "individual"));
        trades.add(new Trade(new BigDecimal(101),
                LocalDateTime.now().plusSeconds(1),
                1, "individual"));
        trades.add(new Trade(new BigDecimal(100),
                LocalDateTime.now().plusSeconds(1),
                500, "individual"));
        trades.add(new Trade(new BigDecimal(100),
                LocalDateTime.now().plusSeconds(0),
                2, "individual"));
        trades.add(new Trade(new BigDecimal(100),
                LocalDateTime.now().plusSeconds(0),
                100, "Company"));
    }
}
