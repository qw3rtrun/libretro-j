package org.qw3rtrun.libretro.api.pixel;

import java.nio.ByteBuffer;
import java.util.Objects;

/* 0RGB1555, native endian.
 * 0 bit must be set to 0.
 * This pixel format is default for compatibility concerns only.
 * If a 15/16-bit pixel format is desired, consider using RGB565. */
public class ORGB1555 implements PixelFormat<ORGB1555> {

    @Override
    public Pixel0RGB1555 pixel(float red, float green, float blue) {
        byte r = (byte)(red * 0b00011111);
        byte g = (byte)(green * 0b00011111);
        byte b = (byte)(blue * 0b00011111);

        byte hi = (byte) (((r & 0b00011111) << 2) | ((g & 0b00011000) >> 3));
        byte low = (byte) (((g & 0b00000111) << 5) | (b & 0b00011111));
        return new Pixel0RGB1555(hi, low);
    }

    @Override
    public int size() {
        return 2;
    }

    float red(Pixel0RGB1555 pixel) {
        return (float)((pixel.hi >> 2) & 0x1F) / 0x1F;
    }

    float green(Pixel0RGB1555 pixel) {
        return (float)((pixel.hi & 0x03) << 3 | ((pixel.low >> 5) & 0x07)) / 0x1F;
    }

    float blue(Pixel0RGB1555 pixel) {
        return (float)(pixel.low & 0b00011111) / 0b00011111;
    }

    @Override
    public int getCode() {
        return 2;
    }

    private class Pixel0RGB1555 implements Pixel<ORGB1555> {

        final byte hi;
        final byte low;

        private Pixel0RGB1555(byte hi, byte low) {
            this.hi = hi;
            this.low = low;
        }

        @Override
        public float red() {
            return ORGB1555.this.red(this);
        }

        @Override
        public float green() {
            return ORGB1555.this.green(this);
        }

        @Override
        public float blue() {
            return ORGB1555.this.blue(this);
        }

        @Override
        public void put(ByteBuffer buffer) {
            buffer.put(hi).put(low);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pixel0RGB1555)) return false;
            Pixel0RGB1555 that = (Pixel0RGB1555) o;
            return hi == that.hi &&
                    low == that.low;
        }

        @Override
        public int hashCode() {
            return Objects.hash(hi, low);
        }

        @Override
        public String toString() {
            String hiStr = String.format("%02x", hi);
            String loStr = String.format("%02x", low);

            return "Pixel0RGB1555{0x" + hiStr + loStr + '}';
        }
    }
}
