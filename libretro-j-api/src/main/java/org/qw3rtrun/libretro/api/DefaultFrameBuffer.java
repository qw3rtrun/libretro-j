package org.qw3rtrun.libretro.api;

import org.qw3rtrun.libretro.api.pixel.ORGB1555;

import java.nio.ByteBuffer;

public class DefaultFrameBuffer extends FrameBuffer<ORGB1555> {

    public DefaultFrameBuffer(int width, int height, ByteBuffer buffer) {
        super(width, height, new ORGB1555(), buffer);
    }
}
