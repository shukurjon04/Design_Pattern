package Adapter;

import Interfaces.NewLogger;
import Interfaces.OldLogger;

public class ConvertLogger implements NewLogger {

    private final OldLogger logger;

    public ConvertLogger(OldLogger logger) {
        this.logger = logger;
    }

    @Override
    public void info(String message) {
        logger.log("info",message);
    }

    @Override
    public void warn(String message) {
        logger.log("warn",message);
    }

    @Override
    public void error(String message) {
      logger.log("error",message);
    }
}
