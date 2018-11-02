package org.qw3rtrun.libretro;

import org.qw3rtrun.libretro.api.FrameBuffer;
import org.qw3rtrun.libretro.api.RetroInitializer;
import org.qw3rtrun.libretro.api.RunContext;
import org.qw3rtrun.libretro.api.builder.RetroConfigurer;
import org.qw3rtrun.libretro.api.pixel.ORGB1555;
import org.qw3rtrun.libretro.api.pixel.Pixel;
import org.qw3rtrun.libretro.struct.GameGeometry;
import org.qw3rtrun.libretro.struct.SystemAVInfo;
import org.qw3rtrun.libretro.struct.SystemTiming;

import java.util.ArrayList;
import java.util.List;

public class LinesStub implements RetroInitializer {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    private final ORGB1555 format = new ORGB1555();

    private final FrameBuffer<ORGB1555> buffer = new FrameBuffer<>(WIDTH, HEIGHT, format);

    private List<Pixel<ORGB1555>> pixels = new ArrayList<>();

    @Override
    public void setupRetro(RetroConfigurer cfg) {
        ORGB1555 format = new ORGB1555();
        pixels.add(format.white());
        pixels.add(format.blue());
        pixels.add(format.grey());
        pixels.add(format.green());
        pixels.add(format.red());
        pixels.add(format.black());

        cfg
                .setInfo(
                        new SystemAVInfo(new GameGeometry(WIDTH, HEIGHT), new SystemTiming(1, 30)))
                .setDefaultRunner(this::render);
    }

    private FrameBuffer<ORGB1555> render(RunContext ctx) {
        buffer.linePosition(0, 0);
        buffer.lines().parallel().forEach(fb -> {
                    for (int x = 0; x < WIDTH; x++) {
                        fb.put(getPixel(x));
                    }
                }
        );
        return buffer;
    }

    private Pixel<ORGB1555> getPixel(int x) {
        return pixels.get(6 * x / WIDTH);
    }
}
