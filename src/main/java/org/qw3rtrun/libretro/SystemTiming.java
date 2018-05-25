package org.qw3rtrun.libretro;

import java.util.Objects;

public class SystemTiming {

    final private double sampleRate;
    final private double fps;

    public SystemTiming(double sampleRate, double fps) {
        this.sampleRate = sampleRate;
        this.fps = fps;
    }

    public double getSampleRate() {
        return sampleRate;
    }

    public double getFps() {
        return fps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SystemTiming)) return false;
        SystemTiming that = (SystemTiming) o;
        return Double.compare(that.sampleRate, sampleRate) == 0 &&
                Double.compare(that.fps, fps) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(sampleRate, fps);
    }

    @Override
    public String toString() {
        return "SystemTiming{" +
                "sampleRate=" + sampleRate +
                ", fps=" + fps +
                '}';
    }
}
