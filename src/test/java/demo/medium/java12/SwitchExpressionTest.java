package demo.medium.java12;

import org.junit.jupiter.api.Test;

public class SwitchExpressionTest {

    @Test
    void oldWaySwitchExpr() {
        SwitchExpr.oldWaySwitchExpr(Weight.HEAVY);
    }

    @Test
    void newWaySwitchExpr() {
        SwitchExpr.newWaySwitchExpr(Weight.LIGHT);
    }

}
