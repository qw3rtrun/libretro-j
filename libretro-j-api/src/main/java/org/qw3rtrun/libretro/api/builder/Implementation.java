package org.qw3rtrun.libretro.api.builder;

import org.qw3rtrun.libretro.api.FrameBuffer;
import org.qw3rtrun.libretro.api.pixel.PixelFormat;
import org.qw3rtrun.libretro.cb.Environment;
import org.qw3rtrun.libretro.struct.SystemAVInfo;

import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.function.Consumer;

public class Implementation<T extends PixelFormat> {

    private final SystemAVInfo info;

    private final T format;

    private final Consumer<FrameBuffer<T>> onRun;

    private final Consumer<Environment> onLoad;

    Implementation(SystemAVInfo info, T format,
                   Consumer<FrameBuffer<T>> onRun,
                   Consumer<Environment> onLoad) {
        this.info = Objects.requireNonNull(info);
        this.format = Objects.requireNonNull(format);
        this.onRun = Objects.requireNonNull(onRun);
        this.onLoad = Objects.requireNonNullElse(onLoad, (env) -> {
        });
    }

    public SystemAVInfo getAVInfo() {
        return info;
    }

    public void load(Environment env) {
        onLoad.accept(env);
//        env.setPixelFormat(format);
    }

    public void run(ByteBuffer buffer) {
        FrameBuffer<T> f = new FrameBuffer<T>(info.getGeometry().getBaseWidth(),
                info.getGeometry().getBaseHeight(),
                format,
                buffer);
        onRun.accept(f);
    }
}
