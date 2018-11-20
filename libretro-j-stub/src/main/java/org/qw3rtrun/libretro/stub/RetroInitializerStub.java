package org.qw3rtrun.libretro.stub;

import org.qw3rtrun.libretro.api.FrameBuffer;
import org.qw3rtrun.libretro.api.RetroInitializer;
import org.qw3rtrun.libretro.api.RunContext;
import org.qw3rtrun.libretro.api.builder.RetroConfigurer;
import org.qw3rtrun.libretro.api.pixel.ORGB1555;
import org.qw3rtrun.libretro.api.pixel.Pixel;
import org.qw3rtrun.libretro.api.struct.GameGeometry;
import org.qw3rtrun.libretro.api.struct.SystemAVInfo;
import org.qw3rtrun.libretro.api.struct.SystemTiming;

import java.util.ArrayList;
import java.util.List;

public class RetroInitializerStub implements RetroInitializer {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    private final ORGB1555 format = new ORGB1555();

    private final FrameBuffer<ORGB1555> buffer = new FrameBuffer<>(WIDTH, HEIGHT, format);

    private List<Pixel<ORGB1555>> pixels = new ArrayList<>();

    @Override
    public void setupRetro(RetroConfigurer cfg) {
        ORGB1555 format = new ORGB1555();
        pixels.add(format.blue());
        pixels.add(format.white());
        pixels.add(format.green());
        pixels.add(format.grey());
        pixels.add(format.red());
        pixels.add(format.black());

        cfg
                .setInfo(
                        new SystemAVInfo(new GameGeometry(WIDTH, HEIGHT), new SystemTiming(1, 30)))
                .setDefaultRunner(this::render);
    }

    private FrameBuffer<ORGB1555> render(RunContext ctx) {
        buffer.linePosition(0, 0);
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                buffer.put(getPixel(x, y));
            }
        }
        return buffer;
    }

    private Pixel<ORGB1555> getPixel(int x, int y) {
        return pixels.get(6 * (x + y) / (WIDTH + HEIGHT));
    }
}
