package org.qw3rtrun.libretro.api;

import org.qw3rtrun.libretro.api.struct.SystemAVInfo;

import java.nio.ByteBuffer;

public interface Implementation {
    SystemAVInfo getAVInfo();

    void load(InitContext env);

    ByteBuffer run(RunContext env);
}
