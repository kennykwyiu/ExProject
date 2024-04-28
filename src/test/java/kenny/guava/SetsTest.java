package kenny.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetsTest {

    private static final Set set1 = Sets.newHashSet(1, 2, 3) ;
    private static final Set set2 = Sets.newHashSet(4, 5, 6);

    @Test
    public void union() {
        Set<Integer> set = Sets.union(set1, set2);
        System.out.println(set);
    }

    @Test
    public void difference() {
        Sets.SetView difference = Sets.difference(set1, set2);

        System.out.println(difference);

        Set<Integer> set = Sets.difference(set1, set2);

        System.out.println(set);

        set = Sets.symmetricDifference(set1, set2);
        System.out.println(set);
    }

    @Test
    public void powerSet() {
        Set<Set<Integer>> set = Sets.powerSet(set1);
        System.out.println(set);

        Set<Set<Integer>> powerSet = Sets.powerSet(set1);

        System.out.println(JSON.toJSONString(powerSet));
    }

    @Test
    public void cartesianProduct() {
        Set set = Sets.cartesianProduct(set1, set2);
        System.out.println(set);
        System.out.println(JSON.toJSONString(set));
    }

    @Test
    public void partition() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
        List<List<Integer>> partition = Lists.partition(list, 3);
        System.out.println(JSON.toJSONString(partition));
    }

}
