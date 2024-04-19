package kenny.stream.cases;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaseOne  {
    @Data
    @AllArgsConstructor
    class ExamStudentScore {
        private String studentName;
        private Integer scoreValue;
        private String subject;
    }
    Map<String, List<ExamStudentScore>> studentMap;
    @Before
    public void init() {
        studentMap = new HashMap<>();

        List<ExamStudentScore> zsScoreList = new ArrayList<>();
        zsScoreList.add(
                new ExamStudentScore(
                        "Peter_3",
                        30,
                        "CHINESE"));
        zsScoreList.add(
                new ExamStudentScore(
                        "Peter_3",
                        40,
                        "ENGLISH"));
        zsScoreList.add(
                new ExamStudentScore(
                        "Peter_3",
                        50,
                        "MATHS"));
        studentMap.put("Peter_3", zsScoreList);

        List<ExamStudentScore> lsScoreList = new ArrayList<>();
        lsScoreList.add(
                new ExamStudentScore(
                        "Liz_4",
                        80,
                        "CHINESE"));
        lsScoreList.add(
                new ExamStudentScore(
                        "Liz_4",
                        null,
                        "ENGLISH"));
        lsScoreList.add(
                new ExamStudentScore(
                        "Liz_4",
                        100,
                        "MATHS"));
        studentMap.put("Liz_4", lsScoreList);

        List<ExamStudentScore> wwScoreList = new ArrayList<>();
        wwScoreList.add(
                new ExamStudentScore(
                        "Jay_5",
                        null,
                        "CHINESE"));
        wwScoreList.add(
                new ExamStudentScore(
                        "Jay_5",
                        null,
                        "ENGLISH"));
        wwScoreList.add(
                new ExamStudentScore(
                        "Jay_5",
                        70,
                        "MATHS"));
        studentMap.put("Jay_5", wwScoreList);
    }

}
