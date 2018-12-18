package org.qw3rtrun.libretro.api;

import org.qw3rtrun.libretro.api.pixel.PixelFormat;

public interface RunContext<T extends PixelFormat> {

    void pushFrameBuffer(FrameBuffer<T> fb);
}
