package kenny.resource;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {
    /**
     * 1. Create input/output streams
     * 2. Perform file copying, read the contents of the file, and write it to another file
     * 3. **Close file stream resources**
     */

    @Test
    public void copyFile() {
        String originalUrl = "";
        String targetUrl = "";

        FileInputStream originalFileInputStream = null;
        FileOutputStream targetFileOutputStream = null;
        try {
            originalFileInputStream = new FileInputStream(originalUrl);
            targetFileOutputStream = new FileOutputStream(targetUrl);

            int content;

            while ((content = originalFileInputStream.read()) != -1) {
                targetFileOutputStream.write(content);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            if (targetFileOutputStream != null) {
                try {
                    targetFileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (originalFileInputStream != null) {
                try {
                    originalFileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }



}
