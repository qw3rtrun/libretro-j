package org.qw3rtrun.libretro;

public interface InputStateCallback {
    int state(int port, int device, int index, int id);
}
