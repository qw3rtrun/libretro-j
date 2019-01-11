package org.qw3rtrun.libretro.api.endpoint;

import org.qw3rtrun.libretro.api.FrameBuffer;
import org.qw3rtrun.libretro.api.GameImplementation;
import org.qw3rtrun.libretro.api.InitContext;
import org.qw3rtrun.libretro.api.RunContext;
import org.qw3rtrun.libretro.api.log.LogCallback;
import org.qw3rtrun.libretro.api.log.LogLevel;
import org.qw3rtrun.libretro.api.pixel.PixelFormat;
import org.qw3rtrun.libretro.cb.*;

import java.util.Objects;

public class CoreEndpoint {

    private final Environment env;
    private final VideoRefreshCallback video;
    private final AudioSampleCallback audio;
    private final AudioSampleBatchCallback audioBatch;

    private LogCallback log;
    private GameImplementation impl;
    private RunContext runContext;

    public CoreEndpoint(Environment env, VideoRefreshCallback video,
                        AudioSampleCallback audio, AudioSampleBatchCallback audioBatch) {
        this.env = Objects.requireNonNull(env);
        this.video = Objects.requireNonNull(video);
        this.audio = audio;
        this.audioBatch = audioBatch;
        this.runContext = new RunContextImpl();
    }

    public CoreEndpoint() {
        this(new EnvironmentNative(), new VideoRefreshCallbackNative(), null, null);
    }

    public boolean load() {
        populateLog(env);
        GameImplementation i = GameImplementation.lookup();
        if (i == null) {
            log.log(LogLevel.ERROR, "GameImplementation not found");
            return false;
        } else {
            this.impl = i;
            return true;
        }
    }

    public void unload() {
        impl.unload();
    }

    public void run() {
        impl.run(runContext);
    }

    private void populateLog(Environment env) {
        LogCallback logInterface = env.getLogInterface();
        if (logInterface == null) {
            logInterface = (level, msg) -> System.err.printf("%s: %s\n", level, msg);
            logInterface.log(LogLevel.WARN, "Environment does not provide log interface");
        }
        this.log = logInterface;
    }

    private class RunContextImpl implements RunContext {
        public void pushFrameBuffer(FrameBuffer fb) {
            video.render(fb.getDirectByteBuffer(), fb.getWidth(), fb.getHeight(),
                    fb.getWidth() * fb.getPixelFormat().size());
        }
    }

    private class InitContextImpl implements InitContext {
        @Override
        public boolean setPixelFormat(PixelFormat pf) {
            Objects.requireNonNull(pf);
            return env.setPixelFormat(pf);
        }
    }
}
