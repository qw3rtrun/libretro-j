package org.qw3rtrun.libretro.api.pixel;

import java.nio.ByteBuffer;

public interface Pixel<T extends PixelFormat> {
    void put(ByteBuffer buffer);

    float red();
    float green();
    float blue();
}
