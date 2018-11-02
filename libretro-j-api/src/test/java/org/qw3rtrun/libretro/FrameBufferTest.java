package org.qw3rtrun.libretro;

import org.junit.jupiter.api.Test;
import org.qw3rtrun.libretro.api.FrameBuffer;
import org.qw3rtrun.libretro.api.pixel.ORGB1555;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class FrameBufferTest {

    @Test
    void testPut() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        ORGB1555 f = new ORGB1555();
        FrameBuffer<ORGB1555> frame = new FrameBuffer<>(5, 1, f, buffer);
        frame
                .put(f.red())
                .put(f.red())
                .put(f.red())
                .put(f.red())
                .put(f.red())
                .put(f.red())
                .put(f.red());

        byte[] actual = new byte[10];
        buffer.flip().get(actual);
        System.out.println(Arrays.toString(actual));
    }
}
