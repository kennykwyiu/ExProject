package kenny.guava;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

public class SetsTest {

    private static final Set set1 = Sets.newHashSet(1, 2, 3) ;
    private static final Set set2 = Sets.newHashSet(4, 5, 6);

    @Test
    public void union() {
        Set<Integer> set = Sets.union(set1, set2);
        System.out.println(set);
    }

}
