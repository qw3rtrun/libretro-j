package org.qw3rtrun.libretro.api.builder;

import org.qw3rtrun.libretro.api.FrameBuffer;
import org.qw3rtrun.libretro.api.pixel.ORGB1555;
import org.qw3rtrun.libretro.api.pixel.PixelFormat;
import org.qw3rtrun.libretro.cb.Environment;
import org.qw3rtrun.libretro.api.struct.SystemAVInfo;

import java.util.function.Consumer;

public class Builder<T extends PixelFormat> {

    private SystemAVInfo info;

    private final T format;

    private Consumer<FrameBuffer<T>> onRun;

    private Consumer<Environment> onLoad;

    public static Builder<ORGB1555> newBuilder() {
        return new Builder<>(new ORGB1555());
    }

    public static <T extends PixelFormat> Builder<T> newBuilder(T pixelFormat) {
        return new Builder<>(pixelFormat);
    }

    private Builder(T format) {
        this.format = format;
    }

    public Builder<T> setInfo(SystemAVInfo info) {
        this.info = info;
        return this;
    }

    public Builder<T> setOnRun(Consumer<FrameBuffer<T>> onRun) {
        this.onRun = onRun;
        return this;
    }

    public Builder<T> setOnLoad(Consumer<Environment> onLoad) {
        this.onLoad = onLoad;
        return this;
    }

    public Implementation<T> build() {
        //noinspection unchecked
        return new Implementation<>(info, format, onRun, onLoad);
    }

}
