package org.qw3rtrun.libretro.internal;

import org.qw3rtrun.libretro.api.FrameBuffer;
import org.qw3rtrun.libretro.api.Implementation;
import org.qw3rtrun.libretro.api.InitContext;
import org.qw3rtrun.libretro.api.RunContext;
import org.qw3rtrun.libretro.api.pixel.ORGB1555;
import org.qw3rtrun.libretro.api.pixel.PixelFormat;
import org.qw3rtrun.libretro.cb.Environment;
import org.qw3rtrun.libretro.api.struct.SystemAVInfo;

import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class ImplementationImpl implements Implementation {

    private final SystemAVInfo info;

    private final PixelFormat format;

    private final Function<RunContext, ? extends FrameBuffer> onRun;

    private final Function<RunContext, FrameBuffer<ORGB1555>> fallbackRun;

    private final Consumer<InitContext> onLoad;

    private Function<RunContext, ? extends FrameBuffer> actualRunner;

    ImplementationImpl(SystemAVInfo info, PixelFormat format,
                       Function<RunContext, FrameBuffer<ORGB1555>> fallbackRunner,
                       Function<RunContext, ? extends FrameBuffer> runner,
                       Consumer<InitContext> initializer) {
        this.info = Objects.requireNonNull(info);
        this.fallbackRun = Objects.requireNonNull(fallbackRunner);
        this.format = Objects.requireNonNull(format);
        this.onRun = Objects.requireNonNull(runner);
        this.onLoad = Objects.requireNonNullElse(initializer, (env) -> {
        });
    }

    ImplementationImpl(SystemAVInfo info,
                       Function<RunContext, FrameBuffer<ORGB1555>> fallbackRunner,
                       Consumer<InitContext> initializer) {
        this.info = Objects.requireNonNull(info);
        this.format = null;
        this.onRun = null;
        this.fallbackRun = Objects.requireNonNull(fallbackRunner);
        this.onLoad = Objects.requireNonNullElse(initializer, (env) -> {
        });
    }

    @Override
    public SystemAVInfo getAVInfo() {
        return info;
    }

    @Override
    public void load(Environment env) {
        if (format != null && env.setPixelFormat(format)) {
            actualRunner = onRun;
        } else {
            actualRunner = fallbackRun;
        }
        onLoad.accept(null);
    }

    @Override
    public ByteBuffer run(Environment env) {
        FrameBuffer buf = actualRunner.apply(null);
        return buf.getDirectByteBuffer();
    }
}