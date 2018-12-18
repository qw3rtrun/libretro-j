package org.qw3rtrun.libretro.api.endpoint;

import org.qw3rtrun.libretro.api.GameImplementation;

public class ImplementationFactory {

    public GameImplementation get() {
        return null;//ServiceLoader<GameImplementation>.load()
    }
}
