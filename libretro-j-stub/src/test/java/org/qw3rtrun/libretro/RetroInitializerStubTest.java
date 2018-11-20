package org.qw3rtrun.libretro;

import org.junit.jupiter.api.Test;
import org.qw3rtrun.libretro.api.Implementation;
import org.qw3rtrun.libretro.internal.ImplementationBuilder;
import org.qw3rtrun.libretro.internal.ImplementationBuilderImpl;
import org.qw3rtrun.libretro.stub.RetroInitializerStub;

import java.nio.ByteBuffer;

class RetroInitializerStubTest {

    @Test
    void setupRetro() {
        RetroInitializerStub retroStub = new RetroInitializerStub();
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