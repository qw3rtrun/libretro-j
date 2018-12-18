package org.qw3rtrun.libretro.api;

import org.qw3rtrun.libretro.api.builder.RetroConfigurer;

public interface RetroInitializer {

    GameImplementation setupRetro(RetroConfigurer config);
}
