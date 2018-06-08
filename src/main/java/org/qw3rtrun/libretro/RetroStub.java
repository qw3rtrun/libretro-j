package org.qw3rtrun.libretro;

import org.qw3rtrun.libretro.cb.*;
import org.qw3rtrun.libretro.struct.GameInfo;
import org.qw3rtrun.libretro.struct.SystemAVInfo;
import org.qw3rtrun.libretro.struct.SystemInfo;

import java.nio.ByteBuffer;
import java.util.Collection;

public class RetroStub implements Retro {

    @Override
    public void setEnvironment(Environment environment) {

    }

    @Override
    public void init() {

    }

    @Override
    public void deinit() {

    }

    @Override
    public void setControllerPortDevice(int port, int device) {

    }

    @Override
    public SystemInfo getSystemInfo() {
        return null;
    }

    @Override
    public SystemAVInfo getSystemAVInfo() {
        return null;
    }

    @Override
    public void setAudioSample(AudioSampleCallback audioCallback) {

    }

    @Override
    public void setAudioSampleBatch(AudioSampleBatchCallback audioBatchCallback) {

    }

    @Override
    public void setInputStatePoll(InputStatePollCallback inputStatePollCallback) {

    }

    @Override
    public void setInputState(InputStateCallback inputStateCallback) {

    }

    @Override
    public void setVideoRefresh(VideoRefreshCallback videoRefreshCallback) {

    }

    @Override
    public void reset() {

    }

    @Override
    public void run() {

    }

    @Override
    public long serializeSize() {
        return 0;
    }

    @Override
    public boolean retroSerialize(ByteBuffer out) {
        return false;
    }

    @Override
    public boolean retroDeserialize(ByteBuffer in) {
        return false;
    }

    @Override
    public boolean cheatReset() {
        return false;
    }

    @Override
    public boolean cheatSet(int index, boolean enabled, String code) {
        return false;
    }

    @Override
    public boolean loadGame(GameInfo gameInfo) {
        return false;
    }

    @Override
    public boolean loadGameSpecial(int gameType, Collection<GameInfo> gameInfos) {
        return false;
    }

    @Override
    public boolean unloadGame() {
        return false;
    }

    @Override
    public int getRegion() {
        return 0;
    }

    @Override
    public void getMemoryData(int id, ByteBuffer out) {

    }
}
