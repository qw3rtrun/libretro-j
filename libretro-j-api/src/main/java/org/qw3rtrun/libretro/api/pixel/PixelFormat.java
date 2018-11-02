package org.qw3rtrun.libretro.api.pixel;

public interface PixelFormat<T extends PixelFormat> {

    Pixel<T> pixel(float red, float green, float blue);

    int size();

    default Pixel<T> black() {
        return pixel(0,0,0);
    }

    default Pixel<T> white() {
        return pixel(1,1,1);
    }

    default Pixel<T> grey() {
        return pixel((float).5,(float).5, (float).5);
    }

    default Pixel<T> red() {
        return pixel(1, 0, 0);
    }

    default Pixel<T> green() {
        return pixel(0, 1, 0);
    }

    default Pixel<T> blue() {
        return pixel(0, 1, 0);
    }

    default Pixel<T> convert(Pixel<?> p) {
        return pixel(p.red(), p.green(), p.blue());
    }

    int getCode();
}
