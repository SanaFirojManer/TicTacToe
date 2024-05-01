package org.example.Exception;

public class InvalidSymbolSetupExxception extends  RuntimeException {
    public InvalidSymbolSetupExxception() {
    }

    public InvalidSymbolSetupExxception(String message) {
        super(message);
    }

    public InvalidSymbolSetupExxception(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSymbolSetupExxception(Throwable cause) {
        super(cause);
    }

    public InvalidSymbolSetupExxception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
