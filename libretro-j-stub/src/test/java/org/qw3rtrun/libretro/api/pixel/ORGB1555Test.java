package org.qw3rtrun.libretro.api.pixel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ORGB1555Test {

    private static ORGB1555 f = new ORGB1555();

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
        assertEquals(red, pixel.red(), (double) 1 / 0x1F);
        assertEquals(green, pixel.green(), (double) 1 / 0x1F);
        assertEquals(blue, pixel.blue(), (double) 1 / 0x1F);
    }

    @Test
    void testGrey() {
        Pixel<ORGB1555> pixel = f.grey();
        assertEquals(.5, pixel.red(), (double) 1 / 0x1F);
        assertEquals(.5, pixel.green(), (double) 1 / 0x1F);
        assertEquals(.5, pixel.blue(), (double) 1 / 0x1F);
    }


    @Test
    void testInstances() {
        Pixel<ORGB1555> p1 = f.grey();
        Pixel<ORGB1555> p3 = new ORGB1555().white();
        Pixel<ORGB1555> p2 = new ORGB1555().grey();
        assertEquals(p1, p2);
        assertNotEquals(p2, p3);
        assertNotEquals(p1, p3);
    }

    @ParameterizedTest
    @MethodSource("colors")
    void testSelfConvert(float red, float green, float blue) {
        Pixel<ORGB1555> p = f.pixel(red, green, blue);
        assertEquals(p, f.convert(p));
    }
}

