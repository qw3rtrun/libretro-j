package org.qw3rtrun.libretro.api;

import org.qw3rtrun.libretro.api.builder.RetroConfigurer;
import org.qw3rtrun.libretro.api.pixel.PixelFormat;
import org.qw3rtrun.libretro.api.builder.Implementation;

public interface RetroInitializer {

    void setupRetro(RetroConfigurer config);
}
