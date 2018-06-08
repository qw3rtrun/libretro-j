package org.qw3rtrun.libretro.cb;

public interface KeyboardCallback {

    void call(boolean down, int keycode, char ch, int mod);
}
