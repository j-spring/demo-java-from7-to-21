package demo.medium.java7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TryWithResources {
    private static final Logger LOG = LoggerFactory.getLogger(TryWithResources.class);
    private static final String OUTPUT_PATH = "src/test/output/";
    private static final String TRY_WITH_RESOURCES_FILENAME = "fileTryWithResources.txt";
    private static final String OLD_TRY_CATCH_FILENAME = "fileWithOldTryCatch.txt";

    private TryWithResources() {
    }

    public static void tryCatchOldWay() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(OUTPUT_PATH.concat(OLD_TRY_CATCH_FILENAME));
            outputStream.write(
                    "This is a file created using old way tryCatch block!"
                            .getBytes(StandardCharsets.UTF_8)
            );
        } catch (FileNotFoundException e) {
            LOG.error("File Not Found, Sorry :(");
            throw new CustomFileNotFoundException(e);
        } catch (IOException e) {
            LOG.error("Something went wrong :(");
            throw new CustomIOException(e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    throw new ClosingOutputException(e);
                }
            }
        }
    }

    public static void tryWithResources() {
        try (FileOutputStream outputStream = new FileOutputStream(OUTPUT_PATH.concat(TRY_WITH_RESOURCES_FILENAME))) {
            outputStream.write(
                    "This is a file created using tryWithResources feature!"
                            .getBytes(StandardCharsets.UTF_8)
            );
        } catch (FileNotFoundException e) {
            throw new CustomFileNotFoundException(e);
        } catch (IOException e) {
            throw new CustomIOException(e);
        }
    }

    private static class CustomFileNotFoundException extends RuntimeException {
        public CustomFileNotFoundException(FileNotFoundException e) {
            super(e);
        }
    }

    private static class CustomIOException extends RuntimeException {
        public CustomIOException(IOException e) {
            super(e);
        }
    }

    private static class ClosingOutputException extends RuntimeException {
        public ClosingOutputException(IOException e) {
            super(e);
        }
    }
}
