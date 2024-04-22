package kenny.stream.cases;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void sortTrade() {
        List<Trade> sorted = trades.stream()
                .sorted(Comparator.comparing(Trade::getPrice, Comparator.reverseOrder())
                        .thenComparing(Trade::getTime)
                        .thenComparing(Trade::getCount, Comparator.reverseOrder())
                        .thenComparing(Trade::getType, (type1, type2) -> {
                            if ("Company".equals(type1) && "individual".equals(type2)) {
                                return -1;
                            } else if ("Company".equals(type2) && "individual".equals(type1)) {
                                return 1;
                            } else {
                                return 0;
                            }
                        }))
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(sorted, true));
    }
}
