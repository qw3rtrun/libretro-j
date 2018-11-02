package org.qw3rtrun.libretro.api.pixel;

import java.nio.ByteBuffer;
import java.util.Objects;

/* RGB565, native endian.
 * This pixel format is the recommended format to use if a 15/16-bit
 * format is desired as it is the pixel format that is typically
 * available on a wide range of low-power devices.
 *
 * It is also natively supported in APIs like OpenGL ES. */
public class RGB565 implements PixelFormat {

    @Override
    public PixelRGB565 pixel(float red, float green, float blue) {
        byte r = (byte)(red * 0x1F);
        byte g = (byte)(green * 0x3F);
        byte b = (byte)(blue * 0x1F);

        byte hi = (byte) (((r & 0b00011111) << 3) | ((g & 0b00111000) >> 3));
        byte low = (byte) (((g & 0b00000111) << 5) | (b & 0b00011111));
        return new PixelRGB565(hi, low);
    }

    @Override
    public int size() {
        return 2;
    }

    float red(PixelRGB565 pixel) {
        return (float)((pixel.hi >> 3) & 0x1F) / 0x1F;
    }

    float green(PixelRGB565 pixel) {
        return (float)((pixel.hi & 0x07) << 3 | ((pixel.low >> 5) & 0x7)) / 0x3F;
    }

    float blue(PixelRGB565 pixel) {
        return (float)(pixel.low & 0x1F) / 0x1F;
    }

    @Override
    public int getCode() {
        return 2;
    }

    private class PixelRGB565 implements Pixel<RGB565> {

        private final byte hi;
        private final byte low;

        private PixelRGB565(byte hi, byte low) {
            this.hi = hi;
            this.low = low;
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(hi).put(low);
        }

        @Override
        public float red() {
            return RGB565.this.red(this);
        }

        @Override
        public float green() {
            return RGB565.this.green(this);
        }

        @Override
        public float blue() {
            return RGB565.this.blue(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PixelRGB565)) return false;
            PixelRGB565 that = (PixelRGB565) o;
            return hi == that.hi &&
                    low == that.low;
        }

        @Override
        public int hashCode() {
            return Objects.hash(hi, low);
        }

        @Override
        public String toString() {
            String hiStr = String.format("0x%02x", hi);
            String loStr = String.format("0x%02x", low);

            return "PixelRGB565{" + hiStr + loStr + '}';
        }
    }
}
