package kenny.lambda.file;

import org.junit.Test;

import java.io.IOException;

public class FileServiceTest {

    @Test
    public void fileHandle() throws IOException {
        FileService fileService = new FileService();

        fileService.fileHandle("C:\\Users\\yaowi\\Desktop" +
                "\\java\\ExProject\\src\\test" +
                "\\java\\kenny\\lambda\\file" +
                "\\FileServiceTest.java",
                fileContent -> {
            System.out.println(fileContent);
        });

    }
}
