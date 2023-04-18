package demo.medium;

import demo.medium.java7.TryWithResources;
import org.junit.jupiter.api.Test;

class TryWithResourcesTest {

    @Test
    void tryCatchOldWay() {
        TryWithResources.tryCatchOldWay();
    }

    @Test
    void tryWithResources() {
        TryWithResources.tryWithResources();
    }
}
