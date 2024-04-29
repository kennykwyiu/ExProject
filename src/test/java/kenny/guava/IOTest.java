package kenny.guava;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class IOTest {

    @Test
    public void copyFile() throws IOException {
        CharSource charSource = Files.asCharSource(new File(""), Charsets.UTF_8);
        CharSink charSink = Files.asCharSink(new File(""), Charsets.UTF_8);

        charSource.copyTo(charSink);
    }
}
