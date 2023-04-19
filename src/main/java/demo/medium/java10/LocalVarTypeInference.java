package demo.medium.java10;

import demo.medium.java8.Streams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalVarTypeInference {
    private static final Logger LOG = LoggerFactory.getLogger(Streams.class);

    private LocalVarTypeInference() {}
    public static void oldWayDeclaration() {
        OurCustomLongNamedType longNamedType = new OurCustomLongNamedType();
        LOG.info(longNamedType.toString());
    }

    public static void typeInferenceDeclaration() {
        var longNamedType = new OurCustomLongNamedType();
        LOG.info(longNamedType.toString());
    }

    private static class OurCustomLongNamedType {
        @Override
        public String toString() {
            return "OurCustomLongNamedTypeToString";
        }

    }
}
