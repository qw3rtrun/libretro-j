package org.qw3rtrun.libretro.api.log;

public enum LogLevel {
    DEBUG(0),
    INFO(1),
    WARN(2),
    ERROR(3);

    private final int code;

    LogLevel(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
