package org.qw3rtrun.libretro.api.facade;

import org.qw3rtrun.libretro.api.Implementation;
import org.qw3rtrun.libretro.api.log.LogCallback;
import org.qw3rtrun.libretro.api.log.LogLevel;
import org.qw3rtrun.libretro.cb.Environment;
import org.qw3rtrun.libretro.cb.VideoRefreshCallback;

import java.util.Objects;

public class Endpoint {

    private Environment env;

    private Implementation impl;

    private LogCallback log;

    private VideoRefreshCallback video;

    public void load(Environment env) {
        this.env = Objects.requireNonNull(env);
        populateLog(env);
    }

    private void populateLog(Environment env) {
        LogCallback logInterface = env.getLogInterface();
        if (logInterface == null) {
            logInterface = new LogCallback() {
                @Override
                public void log(LogLevel level, String msg) {
                    System.err.printf("%s: %s", level, msg);
                }
            };
            logInterface.log(LogLevel.WARN, "Environment does not provide log interface");
        }
        this.log = logInterface;
    }
}
