package org.qw3rtrun.libretro.api.struct;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class RomInfo {

    final private String description;

    final private Set<String> validExtensions;

    final private boolean needFullpath;

    final private boolean blockExtract;

    final private boolean required;

    final private List<MemoryInfo> memory;

    public RomInfo(String description, boolean needFullpath, boolean blockExtract, boolean required, List<MemoryInfo> memory, String... validExtensions) {
        this.description = description;
        this.validExtensions = Set.of(validExtensions);
        this.needFullpath = needFullpath;
        this.blockExtract = blockExtract;
        this.required = required;
        this.memory = memory;
    }

    public RomInfo(String description, boolean needFullpath, boolean blockExtract, boolean required, MemoryInfo memory, String... validExtensions) {
        this(description, needFullpath, blockExtract, required, Collections.singletonList(memory), validExtensions);
    }

    public String getDescription() {
        return description;
    }

    public Set<String> getValidExtensions() {
        return validExtensions;
    }

    public boolean isNeedFullpath() {
        return needFullpath;
    }

    public boolean isBlockExtract() {
        return blockExtract;
    }

    public boolean isRequired() {
        return required;
    }

    public List<MemoryInfo> getMemory() {
        return memory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RomInfo)) return false;
        RomInfo romInfo = (RomInfo) o;
        return needFullpath == romInfo.needFullpath &&
                blockExtract == romInfo.blockExtract &&
                required == romInfo.required &&
                Objects.equals(description, romInfo.description) &&
                Objects.equals(validExtensions, romInfo.validExtensions) &&
                Objects.equals(memory, romInfo.memory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, validExtensions, needFullpath, blockExtract, required, memory);
    }

    @Override
    public String toString() {
        return "RomInfo{" +
                "description='" + description + '\'' +
                ", validExtensions=" + validExtensions +
                ", needFullpath=" + needFullpath +
                ", blockExtract=" + blockExtract +
                ", required=" + required +
                ", memory=" + memory +
                '}';
    }
}
