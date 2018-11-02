package org.qw3rtrun.libretro.api;

import org.qw3rtrun.libretro.api.pixel.Pixel;
import org.qw3rtrun.libretro.api.pixel.PixelFormat;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FrameBuffer<T extends PixelFormat> {

    private final int width;
    private final int height;
    private final T format;
    private final ByteBuffer buffer;

    public FrameBuffer(int width, int height, T format) {
        this.width = width;
        this.height = height;
        this.format = format;
        this.buffer = ByteBuffer.allocateDirect(width * height * format.size());
    }

    public <F extends T> FrameBuffer(int width, int height, F format, ByteBuffer buffer) {
        this.width = width;
        this.height = height;
        this.format = format;
        this.buffer = buffer;
    }

    public T getPixelFormat() {
        return format;
    }

    public int remaining() {
        return buffer.remaining() / format.size();
    }

    public FrameBuffer<T> put(Pixel<T> pixel) {
        if (buffer.remaining() >= format.size())
            pixel.put(buffer);
        return this;
    }

    public FrameBuffer<T> putRed() {
        return put(format.red());
    }

    public FrameBuffer<T> put(Stream<Pixel<T>> pixelStream) {
        pixelStream
                .limit(remaining())
                .forEach(p -> p.put(buffer));
        return this;
    }

    public FrameBuffer<T> put(List<Pixel<T>> pixels) {
        int size = Math.min(remaining(), pixels.size());
        for (int i = 0; i < size; i++) {
            pixels.get(i).put(buffer);
        }
        return this;
    }

    public int line() {
        return buffer.position() / format.size() / width;
    }

    public int position() {
        return buffer.position() / format.size() % width;
    }

    public FrameBuffer<T> line(int line) {
        return linePosition(line, position());
    }

    public FrameBuffer<T> position(int position) {
        return linePosition(line(), position);
    }

    public FrameBuffer<T> linePosition(int line, int position) {
        line %= height;
        position %= width;
        buffer.position((line * width + position) * format.size());
        return this;
    }

    public Stream<FrameBuffer<T>> slice() {
        buffer.position(0);
        ByteBuffer first = buffer.slice();
        first.limit(height * width / 2);
        buffer.position(height * width / 2);
        ByteBuffer second = buffer.slice();
        second.limit(height * width / 2);
        return Stream.of(
                new FrameBuffer<T>(width, height / 2, format, first),
                new FrameBuffer<T>(width, height / 2, format, second)
        );
    }

    public Stream<FrameBuffer<T>> lines() {
        return IntStream.range(0, height)
                .mapToObj(i -> {
                    buffer.position(i * width);
                    ByteBuffer buf = buffer.slice();
                    buf.limit(width);
                    return new FrameBuffer<T>(width, 1, format, buf);
                });
    }

    public ByteBuffer getDirectByteBuffer() {
        return buffer;
    }
}
