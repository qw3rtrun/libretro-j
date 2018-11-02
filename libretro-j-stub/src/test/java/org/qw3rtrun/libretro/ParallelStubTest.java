package org.qw3rtrun.libretro;

import org.junit.jupiter.api.Test;
import org.qw3rtrun.libretro.cb.EnvironmentNative;
import org.qw3rtrun.libretro.internal.Implementation;
import org.qw3rtrun.libretro.internal.ImplementationBuilder;
import org.qw3rtrun.libretro.internal.ImplementationBuilderImpl;

import java.nio.ByteBuffer;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ParallelStubTest {

    @Test
    void setupRetro() {
        ParallelStub retroStub = new ParallelStub();
        ImplementationBuilder builder = new ImplementationBuilderImpl();
        retroStub.setupRetro(builder);
        Implementation impl = builder.build();

        impl.load(null);

        while (true) {
            long millis = System.currentTimeMillis();
            for (int i = 0; i < 60; i++) {
                ByteBuffer b = impl.run(null);
            }
            System.out.println(System.currentTimeMillis() - millis);
        }
    }
}