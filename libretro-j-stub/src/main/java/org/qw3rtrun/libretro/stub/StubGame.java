package org.qw3rtrun.libretro.stub;

import org.qw3rtrun.libretro.api.DefaultFormatGame;
import org.qw3rtrun.libretro.api.FrameBuffer;
import org.qw3rtrun.libretro.api.InitContext;
import org.qw3rtrun.libretro.api.RunContext;
import org.qw3rtrun.libretro.api.exception.RetroLoadException;
import org.qw3rtrun.libretro.api.pixel.ORGB1555;
import org.qw3rtrun.libretro.api.struct.GameGeometry;
import org.qw3rtrun.libretro.api.struct.SystemAVInfo;
import org.qw3rtrun.libretro.api.struct.SystemTiming;

import java.nio.ByteBuffer;

public class StubGame extends DefaultFormatGame {

    private final FrameBuffer<ORGB1555> buf;

    @Override
    public SystemAVInfo getAVInfo() {
        return new SystemAVInfo(
                new GameGeometry(300, 200),
                new SystemTiming(1.0, 30)
        );
    }

    public StubGame() {
        this(new FrameBuffer<>(300, 200, new ORGB1555(), ByteBuffer.allocateDirect(300*200*2)));
    }

    public StubGame(FrameBuffer<ORGB1555> buf) {
        this.buf = buf;
    }

    @Override
    public void load(InitContext env) throws RetroLoadException {

    }

    @Override
    public void run(RunContext<ORGB1555> env) {
        env.pushFrameBuffer(buf.putRed());
    }
}
