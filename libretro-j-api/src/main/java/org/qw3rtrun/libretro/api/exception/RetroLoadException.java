package org.qw3rtrun.libretro.api.exception;

public class RetroLoadException extends Exception {

    public RetroLoadException() {
    }

    public RetroLoadException(String message) {
        super(message);
    }

    public RetroLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public RetroLoadException(Throwable cause) {
        super(cause);
    }

    public RetroLoadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
