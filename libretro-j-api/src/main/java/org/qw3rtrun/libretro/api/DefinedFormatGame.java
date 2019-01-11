package org.qw3rtrun.libretro.api;

import org.qw3rtrun.libretro.api.pixel.PixelFormat;

import java.util.Objects;

public abstract class DefinedFormatGame<T extends PixelFormat> implements GameImplementation<T> {

    abstract T getPixelFormat();

    @Override
    public void load(InitContext env) {
        PixelFormat pf = getPixelFormat();
        Objects.requireNonNull(pf);
        env.setPixelFormat(pf);
    }

}
