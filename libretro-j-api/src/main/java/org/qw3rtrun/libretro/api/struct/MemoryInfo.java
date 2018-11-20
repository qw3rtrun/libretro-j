package org.qw3rtrun.libretro.api.struct;

import java.util.Objects;

public class MemoryInfo {

    private final String extension;

    private final int type;

    public MemoryInfo(String extension, int type) {
        Objects.requireNonNull(extension);
        this.extension = extension;
        this.type = type;
    }

    public String getExtension() {
        return extension;
    }

    public int getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemoryInfo)) return false;
        MemoryInfo that = (MemoryInfo) o;
        return type == that.type &&
                Objects.equals(extension, that.extension);
    }

    @Override
    public int hashCode() {

        return Objects.hash(extension, type);
    }

    @Override
    public String toString() {
        return "MemoryInfo{" +
                "extension='" + extension + '\'' +
                ", type=" + type +
                '}';
    }
}
