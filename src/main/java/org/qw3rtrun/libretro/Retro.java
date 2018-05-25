package org.qw3rtrun.libretro;

import java.nio.ByteBuffer;
import java.util.Collection;

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
}
