package kenny.guava;

import org.checkerframework.checker.nullness.Opt;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalTest {
    @Test
    public void test() {
        Optional.empty();
        Optional.of("Peter");
        Optional<Object> optional = Optional.ofNullable("null");

//        System.out.println(optional.isPresent());
        optional.ifPresent(System.out::println);

        optional.orElse("wrongly reference");
        optional.orElseGet(() -> {
            return "custom wrongly reference";
        });
        optional.orElseThrow(() -> {
            throw new RuntimeException("wrongly ref exception");
        });
    }

    public static void stream(List<String> list) {
//        list.stream().forEach(System.out::println);
        Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .forEach(System.out::println );
    }

    public static void main(String[] args) {
        stream(null);
    }
}
