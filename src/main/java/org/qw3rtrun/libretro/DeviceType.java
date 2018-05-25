package org.qw3rtrun.libretro;

public enum DeviceType {
    none(0),
    joypad(1),
    mouse(2),
    keyboard(3),
    lightgun(4),
    analog(5),
    pointer(6),
    ;

    private int code;

    DeviceType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public int id(int num) {
        return (((num + 1) << 8) | code);
    }
}
