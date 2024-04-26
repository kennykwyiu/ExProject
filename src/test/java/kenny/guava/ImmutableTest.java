package kenny.guava;

import java.util.ArrayList;
import java.util.List;

public class ImmutableTest {
    public static  void test(List<Integer> list) {
        list.remove(0);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        test(list);
        System.out.println(list);
    }
}
