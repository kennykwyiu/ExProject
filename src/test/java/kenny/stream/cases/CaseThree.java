package kenny.stream.cases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class CaseThree {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Role {
        private List<Permission> permissions;
    }
    @Data
    @AllArgsConstructor
    class Permission {
        private String name;
    }

}
