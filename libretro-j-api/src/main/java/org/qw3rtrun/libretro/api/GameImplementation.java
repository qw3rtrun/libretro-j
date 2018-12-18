package org.qw3rtrun.libretro.api;

import org.qw3rtrun.libretro.api.pixel.PixelFormat;
import org.qw3rtrun.libretro.api.struct.SystemAVInfo;
import org.qw3rtrun.libretro.cb.Environment;

import java.nio.ByteBuffer;

public interface GameImplementation<T extends PixelFormat> {
    SystemAVInfo getAVInfo();

    void load(InitContext env) throws RetroLoadException;

    void run(RunContext<T> env);

    default void unload() {};
}
