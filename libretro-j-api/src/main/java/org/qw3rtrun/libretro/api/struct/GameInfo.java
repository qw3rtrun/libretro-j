package org.qw3rtrun.libretro.api.struct;

import java.nio.ByteBuffer;
import java.util.Objects;

public class GameInfo {

    private final String path;

    private final ByteBuffer data;

    private final String meta;

    public GameInfo(String path, ByteBuffer data, String meta) {
        this.path = path;
        this.data = data;
        this.meta = meta;
    }

    public String getPath() {
        return path;
    }

    public ByteBuffer getData() {
        return data;
    }

    public String getMeta() {
        return meta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameInfo)) return false;
        GameInfo gameInfo = (GameInfo) o;
        return Objects.equals(path, gameInfo.path) &&
                Objects.equals(data, gameInfo.data) &&
                Objects.equals(meta, gameInfo.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, data, meta);
    }

    @Override
    public String toString() {
        return "GameInfo{" +
                "path='" + path + '\'' +
                ", data=" + data +
                ", meta='" + meta + '\'' +
                '}';
    }
}
