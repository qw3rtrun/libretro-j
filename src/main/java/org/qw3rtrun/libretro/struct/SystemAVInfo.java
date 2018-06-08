package org.qw3rtrun.libretro.struct;

import java.util.Objects;

public class SystemAVInfo {

    private final GameGeometry geometry;
    private final SystemTiming timing;

    public SystemAVInfo(GameGeometry geometry, SystemTiming timing) {
        this.geometry = geometry;
        this.timing = timing;
    }

    public GameGeometry getGeometry() {
        return geometry;
    }

    public SystemTiming getTiming() {
        return timing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SystemAVInfo)) return false;
        SystemAVInfo that = (SystemAVInfo) o;
        return Objects.equals(geometry, that.geometry) &&
                Objects.equals(timing, that.timing);
    }

    @Override
    public int hashCode() {

        return Objects.hash(geometry, timing);
    }

    @Override
    public String toString() {
        return "SystemAVInfo{" +
                "geometry=" + geometry +
                ", timing=" + timing +
                '}';
    }
}
