package org.qw3rtrun.libretro.internal;

import org.qw3rtrun.libretro.api.Implementation;
import org.qw3rtrun.libretro.api.builder.RetroConfigurer;

public interface ImplementationBuilder extends RetroConfigurer {

    Implementation build();

}
