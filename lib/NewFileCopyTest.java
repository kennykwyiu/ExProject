package kenny.resource;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class NewFileCopyTest {
    @Test
    public void copyFile() {
        String originalUrl = "lib/NewFileCopyTest.java";
        String targetUrl = "targetTest/new.txt";

        try (
                FileInputStream originalFileInputStream = new FileInputStream(originalUrl);
             FileOutputStream targetFileOutputStream = new FileOutputStream(targetUrl);
        ) {
            int content;

            while ((content = originalFileInputStream.read()) != -1) {
                targetFileOutputStream.write(content);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
