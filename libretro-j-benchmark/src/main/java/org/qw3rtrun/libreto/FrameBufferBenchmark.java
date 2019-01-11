/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package org.qw3rtrun.libreto;

import org.openjdk.jmh.annotations.*;
import org.qw3rtrun.libretro.api.FrameBuffer;
import org.qw3rtrun.libretro.api.pixel.ORGB1555;
import org.qw3rtrun.libretro.api.pixel.Pixel;

import java.nio.ByteBuffer;

//@Fork(3)
//@Warmup(iterations = 5)
//@Measurement(iterations = 5)
public class FrameBufferBenchmark {

    @State(Scope.Benchmark)
    public static class Context {

        ByteBuffer buf;
        ORGB1555 format;
        Pixel<ORGB1555> pixel;
        FrameBuffer<ORGB1555> frame;

        @Setup(Level.Trial)
        public void setUp() {
            buf = ByteBuffer.allocateDirect(2 * 1280 * 720);
            format = new ORGB1555();
            pixel = format.red();
            frame = new FrameBuffer<ORGB1555>(1280, 720, format, buf);
        }

        @Setup(Level.Invocation)
        public void reset() {
            buf.position(0);
        }
    }

    //@Benchmark
    public void simple(Context ctx) {
        /*ctx.simple.run(ctx.buf);*/
    }

    @Benchmark
    public void parallel(Context ctx) {
        /*ctx.parallel.run(ctx.buf);*/
    }

}
