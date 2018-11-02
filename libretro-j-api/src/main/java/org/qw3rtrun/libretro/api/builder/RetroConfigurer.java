package org.qw3rtrun.libretro.api.builder;

import org.qw3rtrun.libretro.api.DefaultFrameBuffer;
import org.qw3rtrun.libretro.api.FrameBuffer;
import org.qw3rtrun.libretro.api.InitContext;
import org.qw3rtrun.libretro.api.RunContext;
import org.qw3rtrun.libretro.api.pixel.ORGB1555;
import org.qw3rtrun.libretro.api.pixel.PixelFormat;
import org.qw3rtrun.libretro.cb.Environment;
import org.qw3rtrun.libretro.struct.SystemAVInfo;

import java.util.function.Consumer;
import java.util.function.Function;

public interface RetroConfigurer {

    RetroConfigurer setInfo(SystemAVInfo info);

    <T extends PixelFormat> RetroConfigurer setRunner(T pixelFormat, Function<RunContext, FrameBuffer<T>> runner);

    RetroConfigurer setDefaultRunner(Function<RunContext, FrameBuffer<ORGB1555>> runner);

    RetroConfigurer setInitializer(Consumer<InitContext> initializer);
}
