package org.qw3rtrun.libretro.internal;

import org.qw3rtrun.libretro.api.GameImplementation;
import org.qw3rtrun.libretro.api.InitContext;
import org.qw3rtrun.libretro.api.pixel.PixelFormat;
import org.qw3rtrun.libretro.api.struct.SystemAVInfo;

import java.util.Objects;

public abstract class DefinedFormatGame<T extends PixelFormat> implements GameImplementation<T> {

    abstract T getPixelFormat();

    @Override
    public SystemAVInfo getAVInfo() {
        return null;
    }

    @Override
    public void load(InitContext env) {
        PixelFormat pf = getPixelFormat();
        Objects.requireNonNull(pf);
        env.setPixelFormat(pf);
    }

}
