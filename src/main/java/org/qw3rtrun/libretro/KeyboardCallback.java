package org.qw3rtrun.libretro;

public interface KeyboardCallback {

    void call(boolean down, int keycode, char ch, int mod);
}
