package org.qw3rtrun.libretro.cb;

public interface InputStateCallback {
    int state(int port, int device, int index, int id);
}
