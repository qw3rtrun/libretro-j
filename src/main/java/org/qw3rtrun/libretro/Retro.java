package org.qw3rtrun.libretro;

import org.qw3rtrun.libretro.cb.*;
import org.qw3rtrun.libretro.struct.GameInfo;
import org.qw3rtrun.libretro.struct.SystemAVInfo;
import org.qw3rtrun.libretro.struct.SystemInfo;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.StreamSupport.stream;

public interface Retro {

    public static final int RETRO_API_VERSION = 1;

    void setEnvironment(Environment environment);

    void init();

    void deinit();

    default int apiVersion() {
        return RETRO_API_VERSION;
    }

    void setControllerPortDevice(int port, int device);

    SystemInfo getSystemInfo();

    SystemAVInfo getSystemAVInfo();

    void setAudioSample(AudioSampleCallback audioCallback);

    void setAudioSampleBatch(AudioSampleBatchCallback audioBatchCallback);

    void setInputStatePoll(InputStatePollCallback inputStatePollCallback);

    void setInputState(InputStateCallback inputStateCallback);

    void setVideoRefresh(VideoRefreshCallback videoRefreshCallback);

    void reset();

    void run();

    long serializeSize();

    boolean retroSerialize(ByteBuffer out);

    boolean retroDeserialize(ByteBuffer in);

    boolean cheatReset();

    boolean cheatSet(int index, boolean enabled, String code);

    boolean loadGame(GameInfo gameInfo);

    boolean loadGameSpecial(int gameType, Collection<GameInfo> gameInfos);

    boolean unloadGame();

    int getRegion();

    void getMemoryData(int id, ByteBuffer out);

    static Retro getInstance(LogCallback logger) {
        return stream(ServiceLoader.load(Retro.class).spliterator(), false)
                .peek(r -> logger.log(LogLevel.DEBUG, "Retro Implementation found : [" + r.getClass() + "] @ " + r))
                .findFirst().orElseGet(() -> {
                    logger.log(LogLevel.ERROR, "Retro Implementation in not found");
                    return new RetroStub();
                });
    }
}
