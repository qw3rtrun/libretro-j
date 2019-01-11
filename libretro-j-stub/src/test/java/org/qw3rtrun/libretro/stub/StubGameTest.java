package org.qw3rtrun.libretro.stub;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.qw3rtrun.libretro.api.endpoint.CoreEndpoint;
import org.qw3rtrun.libretro.cb.AudioSampleBatchCallback;
import org.qw3rtrun.libretro.cb.AudioSampleCallback;
import org.qw3rtrun.libretro.cb.Environment;
import org.qw3rtrun.libretro.cb.VideoRefreshCallback;

@ExtendWith(MockitoExtension.class)
class StubGameTest {

    @InjectMocks
    private CoreEndpoint core;

    @Mock
    private Environment env;

    @Mock
    private VideoRefreshCallback video;

    @Mock
    private AudioSampleCallback audio;

    @Mock
    private AudioSampleBatchCallback audioBatch;

    @Test
    void coreTest() {
        core.load();
        core.run();
    }
}