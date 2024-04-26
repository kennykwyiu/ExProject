package kenny.guava;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableTest {
    public static void test(List<Integer> list) {
        list.remove(0);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> unmodifiableList = Collections.unmodifiableList(list);

        test(list);
        System.out.println("list: " + list);

        test(unmodifiableList);
        System.out.println("unmodifiableList: " + unmodifiableList);
    }

    public void immutable() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        ImmutableSet<Integer> immutableSet = ImmutableSet.copyOf(list);

        ImmutableSet<Integer> integerImmutableSet = ImmutableSet.of(1, 2, 3);

        ImmutableSet<Object> objectImmutableSet = ImmutableSet.builder()
                .add(1)
                .addAll(Sets.newHashSet(2, 3))
                .add(4)
                .build();

    }
}
