package demo.medium.java16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InvalidObjectException;

class SerializationRecordTest {

    @Test
    void testSerializationProcessOldWay() {
        RecordLegacyUnit unitSerialized = RecordSample.serializeObjectOldWay();
        System.out.println(unitSerialized);
        Assertions.assertNotNull(unitSerialized);

        Assertions.assertDoesNotThrow(
                RecordSample::deserializeObjectOldWay);
    }

    @Test
    void testSerializationRecords() {
        RecordUnit unitSerialized = RecordSample.serializeRecord();
        System.out.println(unitSerialized);
        Assertions.assertNotNull(unitSerialized);

        Assertions.assertThrows(InvalidObjectException.class,
                RecordSample::deserializeRecord);
    }
}
