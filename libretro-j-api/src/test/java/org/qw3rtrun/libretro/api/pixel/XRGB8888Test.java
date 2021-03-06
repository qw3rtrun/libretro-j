package org.qw3rtrun.libretro.api.pixel;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class XRGB8888Test {

    private static XRGB8888 f = new XRGB8888();

    private static Stream<Arguments> colors() {
        return Stream.of(
                arguments(1, 1, 1),
                arguments(0, 0, 0),
                arguments(1, (float) .5, 0),
                arguments(0, (float) .5, 1),
                arguments((float) 0.25, (float) .15, 1),
                arguments(1, (float) 0.25, (float) .15),
                arguments((float) .15, 1, (float) 0.25),
                arguments((float) 0.25, (float) .15, 0),
                arguments(0, (float) 0.25, (float) .15),
                arguments((float) .15, 0, (float) 0.25)
        );
    }

    @ParameterizedTest
    @MethodSource("colors")
    void test(float red, float green, float blue) {
        Pixel<?> pixel = f.pixel(red, green, blue);
        assertEquals(red, pixel.red(), (double) 1 / 0xFF);
        assertEquals(green, pixel.green(), (double) 1 / 0xFF);
        assertEquals(blue, pixel.blue(), (double) 1 / 0xFF);
    }
}