package demo.medium.java16;

import java.io.ObjectStreamException;
import java.io.Serial;
import java.io.Serializable;

public class RecordLegacyUnit implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final String unitId;

    public RecordLegacyUnit(String unitId) {
        if (unitId == null)
            throw new IllegalArgumentException("unitId cannot be null!");
        this.unitId = unitId;
    }

    public String getUnitId() {
        return unitId;
    }

   /* @Serial
    private Object writeReplace() throws ObjectStreamException {
        System.out.println("Replacing serialising object.");
        return new RecordLegacyUnit(unitId);
    }

    @Serial
    private Object readResolve() throws ObjectStreamException {
        System.out.println("Replacing de-serializing object.");
        return new RecordLegacyUnit(unitId);
    }*/

    @Override
    public String toString() {
        return "RecordLegacyUnit{" +
                "unitId='" + unitId + '\'' +
                '}';
    }
}
