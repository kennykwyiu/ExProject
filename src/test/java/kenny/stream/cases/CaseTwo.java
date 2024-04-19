package kenny.stream.cases;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CaseTwo {
    @Data
    @AllArgsConstructor
    class TagReqDTO {
        private String name;
        private Integer age;
    }

    List<String> tagListFromDB;
    List<TagReqDTO> tagListFromReq;

    @Before
    public void init() {
        tagListFromDB = Lists.newArrayList(
                "Liz_4", "Jay_5", "Jenny_6");

        tagListFromReq = Lists.newArrayList(
                new TagReqDTO("Peter_3", 10),
                new TagReqDTO("Liz_4", 30),
                new TagReqDTO("Peter_3", 11));
    }

    @Test
    public void distinctTag() {
        tagListFromReq.stream()
                .filter(tag -> !tagListFromDB.contains(tag.getName()))
                .distinct()
                .forEach(tag -> System.out.println(JSON.toJSONString(tag, true)));
    }
}
