package kenny.stream;

import org.junit.Test;

import java.util.stream.Stream;

public class StreamConstructor {
    @Test
    public void streamFromValue() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.forEach(System.out::println);
    }
}
