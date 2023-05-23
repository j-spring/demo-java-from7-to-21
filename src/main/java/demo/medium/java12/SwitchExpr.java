package demo.medium.java12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwitchExpr {
    private static final Logger LOG = LoggerFactory.getLogger(SwitchExpr.class);

    public static void oldWaySwitchExpr(Weight weight) {
        String dailyStress = null;
        switch (weight) {
            case LIGHT: case NORMAL:
                dailyStress = "Good";
                break;
            case HEAVY:
                dailyStress = "Bad";
                break;
        }

        LOG.info("Today is a {} day", dailyStress);
    }

    public static void newWaySwitchExpr(Weight weight) {
        String dailyStress = switch (weight) {
            case LIGHT, NORMAL -> "Good";
            case HEAVY -> "Bad";
        };

        LOG.info("Today is a {} day", dailyStress);
    }

}

enum Weight {
    LIGHT,NORMAL,HEAVY;
}