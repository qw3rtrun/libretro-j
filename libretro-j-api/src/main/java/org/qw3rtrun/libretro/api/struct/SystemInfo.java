package org.qw3rtrun.libretro.api.struct;

import java.util.Objects;
import java.util.Set;

public class SystemInfo {

    final private String libraryName;
    final private String libraryVersion;
    final private boolean needFullPath;
    final private Set<String> validExtensions;

    public SystemInfo(String libraryName, String libraryVersion, boolean needFullPath, String... extensions) {
        this.libraryName = libraryName;
        this.libraryVersion = libraryVersion;
        this.needFullPath = needFullPath;
        this.validExtensions = Set.of(extensions);
    }

    public SystemInfo(String libraryName, String libraryVersion) {
        this(libraryName, libraryVersion, false);
    }

    public SystemInfo(String libraryName) {
        this(libraryName, "v1");
    }

    public String getLibraryName() {
        return libraryName;
    }

    public String getLibraryVersion() {
        return libraryVersion;
    }

    public boolean isNeedFullPath() {
        return needFullPath;
    }

    public Set<String> getValidExtensions() {
        return validExtensions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SystemInfo)) return false;
        SystemInfo that = (SystemInfo) o;
        return needFullPath == that.needFullPath &&
                Objects.equals(libraryName, that.libraryName) &&
                Objects.equals(libraryVersion, that.libraryVersion) &&
                Objects.equals(validExtensions, that.validExtensions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(libraryName, libraryVersion, needFullPath, validExtensions);
    }

    @Override
    public String toString() {
        return "SystemInfo{" +
                "libraryName='" + libraryName + '\'' +
                ", libraryVersion='" + libraryVersion + '\'' +
                ", needFullPath=" + needFullPath +
                ", validExtensions=" + validExtensions +
                '}';
    }
}
