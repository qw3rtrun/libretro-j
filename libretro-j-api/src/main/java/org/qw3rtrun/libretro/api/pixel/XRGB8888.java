package org.qw3rtrun.libretro.api.pixel;

import java.nio.ByteBuffer;
import java.util.Objects;

/* XRGB8888, native endian.
 * X bits are ignored. */
public class XRGB8888 implements PixelFormat {

    @Override
    public int size() {
        return 4;
    }

    @Override
    public PixelXRGB8888 pixel(float red, float green, float blue) {
        byte r = (byte) (red * 255);
        byte g = (byte) (green * 255);
        byte b = (byte) (blue * 255);
        return new PixelXRGB8888(r, g, b);
    }

    float red(PixelXRGB8888 pixel) {
        return (float) (pixel.r & 0xFF) / 255;
    }

    float green(PixelXRGB8888 pixel) {
        return (float) (pixel.g & 0xFF) / 255;
    }

    float blue(PixelXRGB8888 pixel) {
        return (float) (pixel.b & 0xFF) / 255;
    }

    @Override
    public int getCode() {
        return 1;
    }

    private class PixelXRGB8888 implements Pixel<XRGB8888> {

        private final static byte X = 0;
        private final byte r;
        private final byte g;
        private final byte b;

        PixelXRGB8888(byte r, byte g, byte b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(X).put(r).put(g).put(b);
        }

        @Override
        public float red() {
            return XRGB8888.this.red(this);
        }

        @Override
        public float green() {
            return XRGB8888.this.green(this);
        }

        @Override
        public float blue() {
            return XRGB8888.this.blue(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PixelXRGB8888)) return false;
            PixelXRGB8888 that = (PixelXRGB8888) o;
            return r == that.r &&
                    g == that.g &&
                    b == that.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, g, b);
        }

        @Override
        public String toString() {
            String rStr = String.format("0x%02x", r);
            String gStr = String.format("0x%02x", g);
            String bStr = String.format("0x%02x", b);

            return "PixelXRGB8888{X" + rStr + gStr + bStr + '}';
        }
    }
}
