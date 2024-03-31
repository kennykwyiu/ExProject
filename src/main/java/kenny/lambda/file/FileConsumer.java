package kenny.lambda.file;

@FunctionalInterface
public interface FileConsumer {
    void fileHandler(String fileContent);
}
