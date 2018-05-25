package org.qw3rtrun.libretro;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EnvironmentNativeTest {

    @Before
    public void setUp() throws Exception {
        System.loadLibrary("libretrojc");
    }

    @Test
    public void test() {
        Environment env = new EnvironmentNative();
        Variable test = env.getVariable("test");
        assertNotNull(test);
        assertEquals("test", test.getValue());
    }
}
