package org.qw3rtrun.libretro.internal;

import org.qw3rtrun.libretro.api.FrameBuffer;
import org.qw3rtrun.libretro.api.Implementation;
import org.qw3rtrun.libretro.api.InitContext;
import org.qw3rtrun.libretro.api.RunContext;
import org.qw3rtrun.libretro.api.builder.RetroConfigurer;
import org.qw3rtrun.libretro.api.pixel.ORGB1555;
import org.qw3rtrun.libretro.api.pixel.PixelFormat;
import org.qw3rtrun.libretro.cb.Environment;
import org.qw3rtrun.libretro.api.struct.SystemAVInfo;

import java.util.function.Consumer;
import java.util.function.Function;

public class ImplementationBuilderImpl implements RetroConfigurer, ImplementationBuilder {

    private SystemAVInfo info;

    private PixelFormat pixelFormat;

    private Function<RunContext, ? extends FrameBuffer> runner;

    private Function<RunContext, FrameBuffer<ORGB1555>> defaultRunner;

    private Consumer<Environment> onLoad;

    private Consumer<InitContext> initializer;

    @Override
    public ImplementationBuilderImpl setInfo(SystemAVInfo info) {
        this.info = info;
        return this;
    }

    @Override
    public <T extends PixelFormat> ImplementationBuilderImpl setRunner(T pixelFormat, Function<RunContext, FrameBuffer<T>> onRun) {
        this.pixelFormat = pixelFormat;
        runner = onRun;
        return this;
    }

    @Override
    public ImplementationBuilderImpl setDefaultRunner(Function<RunContext, FrameBuffer<ORGB1555>> runner) {
        this.defaultRunner = runner;
        return this;
    }

    @Override
    public ImplementationBuilderImpl setInitializer(Consumer<InitContext> initializer) {
        this.initializer = initializer;
        return this;
    }

    @Override
    public Implementation build() {
        return new ImplementationImpl(info, pixelFormat, defaultRunner, runner, initializer);
    }

}
