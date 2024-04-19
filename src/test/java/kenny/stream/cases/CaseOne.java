package kenny.stream.cases;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaseOne {
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

        List<ExamStudentScore> peter_3ScoreList = new ArrayList<>();
        peter_3ScoreList.add(
                new ExamStudentScore(
                        "Peter_3",
                        30,
                        "CHINESE"));
        peter_3ScoreList.add(
                new ExamStudentScore(
                        "Peter_3",
                        40,
                        "ENGLISH"));
        peter_3ScoreList.add(
                new ExamStudentScore(
                        "Peter_3",
                        50,
                        "MATHS"));
        studentMap.put("Peter_3", peter_3ScoreList);

        List<ExamStudentScore> liz_4ScoreList = new ArrayList<>();
        liz_4ScoreList.add(
                new ExamStudentScore(
                        "Liz_4",
                        80,
                        "CHINESE"));
        liz_4ScoreList.add(
                new ExamStudentScore(
                        "Liz_4",
                        null,
                        "ENGLISH"));
        liz_4ScoreList.add(
                new ExamStudentScore(
                        "Liz_4",
                        100,
                        "MATHS"));
        studentMap.put("Liz_4", liz_4ScoreList);

        List<ExamStudentScore> jay_5ScoreList = new ArrayList<>();
        jay_5ScoreList.add(
                new ExamStudentScore(
                        "Jay_5",
                        null,
                        "CHINESE"));
        jay_5ScoreList.add(
                new ExamStudentScore(
                        "Jay_5",
                        null,
                        "ENGLISH"));
        jay_5ScoreList.add(
                new ExamStudentScore(
                        "Jay_5",
                        70,
                        "MATHS"));
        studentMap.put("Jay_5", jay_5ScoreList);
    }

    @Test
    public void findStudent() {
        studentMap.forEach((studentName, scoreList) -> {
            boolean isNull = scoreList.stream().anyMatch(score -> {
                return score.getScoreValue() == null;
            });

            if (isNull) {
                System.out.println("Student - [ " + studentName + " ] is absent the exam!");
            }

        });



    }
}
