package org.qw3rtrun.libretro;


import org.junit.Ignore;
import org.junit.Test;
import org.qw3rtrun.libretro.cb.Environment;
import org.qw3rtrun.libretro.cb.EnvironmentNative;
import org.qw3rtrun.libretro.struct.Variable;

import java.nio.ByteBuffer;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EnvironmentNativeTest {

    @Test
    @Ignore
    public void test() {
        System.loadLibrary("libretrojc");
        Environment env = new EnvironmentNative();
        Variable test = env.getVariable("test");
        assertNotNull(test);
        assertEquals("test", test.getValue());
    }

    @Test
    public void dbbTest() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        byteBuffer.position(3);
        byteBuffer.put((byte)-1);
        byteBuffer.position(0);
        byteBuffer.put((byte)-1);

        System.out.println(Arrays.toString(byteBuffer.array()));

        byteBuffer.position(0);
        System.out.println(byteBuffer.get());
        byteBuffer.slice();
        byteBuffer.flip();
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
    }
}
