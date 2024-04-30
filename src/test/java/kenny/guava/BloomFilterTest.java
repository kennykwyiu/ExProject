package kenny.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.PrimitiveSink;
import org.junit.Test;

public class BloomFilterTest {

    @Test
    public void bloomFilter() {
        BloomFilter<Integer> integerBloomFilter = BloomFilter
                .create((Integer from, PrimitiveSink primitiveSink)
                                -> primitiveSink.putInt(from),
                    10000L,
                                0.1);
        for (int i = 0; i < 10000; i++) {
            integerBloomFilter.put(i);
        }

        boolean mightContain = integerBloomFilter.mightContain(66666);
        System.out.println("Exist? " + mightContain);
    }
}
