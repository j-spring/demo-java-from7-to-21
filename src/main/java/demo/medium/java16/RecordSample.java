package demo.medium.java16;

import demo.medium.java7.TryWithResources;

import java.io.*;

import static demo.medium.java7.TryWithResources.OUTPUT_PATH;

public class RecordSample {

    private RecordSample() {}

    public static RecordLegacyUnit serializeObjectOldWay() {
        RecordLegacyUnit legacyUnit = new RecordLegacyUnit("hello");
        writeObj(legacyUnit, "RecordLegacyUnit.ser");
        return legacyUnit;
    }

    public static RecordLegacyUnit deserializeObjectOldWay() throws InvalidObjectException {
        return (RecordLegacyUnit) readObj("RecordLegacyUnitCorrupted.ser");
    }

    public static RecordUnit serializeRecord() {
        RecordUnit legacyUnit = new RecordUnit("hello");
        writeObj(legacyUnit, "RecordUnit.ser");
        return legacyUnit;
    }

    public static RecordUnit deserializeRecord() throws InvalidObjectException {
        return (RecordUnit) readObj("RecordUnitCorrupted.ser");
    }

    public static void writeObj(Object obj, String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_PATH.concat(fileName));
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream)) {
            outputStream.writeObject(obj);

        } catch (FileNotFoundException e) {
            throw new TryWithResources.CustomFileNotFoundException(e);
        } catch (IOException e) {
            throw new TryWithResources.CustomIOException(e);
        }
    }

    public static Object readObj(String fileName) throws InvalidObjectException {
        try (FileInputStream fileInputStream = new FileInputStream(OUTPUT_PATH.concat(fileName));
             ObjectInputStream inputStream = new ObjectInputStream(fileInputStream)) {
            return inputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new TryWithResources.CustomFileNotFoundException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            if (e instanceof InvalidObjectException ie) {
                throw ie;
            }
            throw new TryWithResources.CustomIOException(e);
        }
    }


}
