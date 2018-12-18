package org.qw3rtrun.libretro.internal;

import org.qw3rtrun.libretro.api.GameImplementation;
import org.qw3rtrun.libretro.api.builder.RetroConfigurer;

public interface ImplementationBuilder extends RetroConfigurer {

    GameImplementation build();

}
