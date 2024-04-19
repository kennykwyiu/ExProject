package kenny.stream.cases;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CaseOne  {
    @Data
    @AllArgsConstructor
    class ExamStudentScore {
        private String studentName;
        private Integer scoreValue;
        private String subject;
    }
}
