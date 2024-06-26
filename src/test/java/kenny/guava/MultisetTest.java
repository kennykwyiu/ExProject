package kenny.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.primitives.Chars;
import org.junit.Test;

public class MultisetTest {

    private static final String text =
            "《南陵別兒童入京》" +
            "白酒新熟山中歸，黃雞啄黍秋正肥。" +
            "呼童烹雞酌白酒，兒女嬉笑牽人衣。" +
            "高歌取醉欲自慰，起舞落日爭光輝。" +
            "遊說萬乘苦不早，著鞭跨馬涉遠道。" +
            "會稽愚婦輕買臣，餘亦辭家西入秦。" +
            "仰天大笑出門去，我輩豈是蓬蒿人。";

    @Test
    public void handle() {
        HashMultiset<Character> multiset = HashMultiset.create();

        char[] chars = text.toCharArray();

        Chars.asList(chars)
                .stream()
//                .forEach(charItem -> multiset.add(charItem));
                .forEach(multiset::add);

        System.out.println("Size: " + multiset.size());
        System.out.println("Count: " + multiset.count('人'));
    }
}
