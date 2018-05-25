package org.qw3rtrun.libretro;

import java.nio.ByteBuffer;

public interface VideoRefreshCallback {

    void render(ByteBuffer data, int width, int height, int pitch);
}
