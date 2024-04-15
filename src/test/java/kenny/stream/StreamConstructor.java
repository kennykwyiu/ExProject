package kenny.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamConstructor {
    @Test
    public void streamFromValue() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.forEach(System.out::println);
    }

    @Test
    public void streamFromArray() {
        int[] numbers = {1,2,3,4,5};
        IntStream stream = Arrays.stream(numbers);
        stream.forEach(System.out::println);

    }

}
