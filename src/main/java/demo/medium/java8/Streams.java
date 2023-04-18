package demo.medium.java8;

import demo.medium.java8.dto.KeyValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Objects.*;

public class Streams {
    private static final Logger LOG = LoggerFactory.getLogger(Streams.class);
    public static final String VALUE_PREFIX = "VALUE";

    private Streams() {}

    public static void forLoop() {
        List<String> resultingStrings = lowerCaseHForLoop(getSampleKeyValues());
        LOG.info("ResultingStringsForLoop: {}", resultingStrings);
    }

    public static void streams() {
        List<String> resultingStrings = lowerCaseHStreams(getSampleKeyValues());
        LOG.info("ResultingStringsStreams: {}", resultingStrings);
    }



    private static List<KeyValue> getSampleKeyValues() {
        return Stream.of("code_one", "code_two", "code_three")
                .map(code -> new KeyValue(
                        code, 
                        code.replace("code", VALUE_PREFIX))
                ).toList();
    }

    private static List<String> lowerCaseHForLoop(List<KeyValue> keyValues) {
        List<String> resultingStrings = new ArrayList<>();
        for (KeyValue keyValue: keyValues) {
            if (keyValue.getCode() != null) {
                if (keyValue.getValue() != null && keyValue.getValue().startsWith(VALUE_PREFIX)) {
                    String modified = keyValue.getValue().toLowerCase();
                    resultingStrings.add(modified);
                }
            }
        }

        return resultingStrings;
    }

    private static List<String> lowerCaseHStreams(List<KeyValue> keyValues) {

        return keyValues.stream()
                .filter(keyValue -> nonNull(keyValue.getCode()))
                .map(KeyValue::getValue)
                .filter(val -> val.startsWith(VALUE_PREFIX))
                .map(String::toLowerCase)
                .toList();
    }

}
