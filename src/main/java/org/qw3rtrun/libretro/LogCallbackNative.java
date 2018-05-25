package org.qw3rtrun.libretro;

public class LogCallbackNative implements LogCallback {

    @Override
    public void log(LogLevel level, String msg) {
        call(level.code(), msg);
    }

    private native void call(int level, String msg);
}
