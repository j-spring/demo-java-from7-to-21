package demo.medium.java16;

import java.io.Serializable;

public record RecordUnit(String unitId) implements Serializable {

    private static final long serialVersionUID = 1L;

    public RecordUnit {
        if (unitId == null)
            throw new IllegalArgumentException("unitId cannot be null!");
    }

}
