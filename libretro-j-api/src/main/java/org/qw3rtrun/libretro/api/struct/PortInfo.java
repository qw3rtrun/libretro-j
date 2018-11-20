package org.qw3rtrun.libretro.api.struct;

import java.util.List;
import java.util.Objects;

public class PortInfo {

    private final List<ControllerInfo> info;

    public PortInfo(ControllerInfo... info) {
        Objects.checkIndex(0, info.length);
        this.info = List.of(info);
    }

    public List<ControllerInfo> getInfo() {
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PortInfo)) return false;
        PortInfo portInfo = (PortInfo) o;
        return Objects.equals(info, portInfo.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info);
    }

    @Override
    public String toString() {
        return "PortInfo{" +
                "info=" + info +
                '}';
    }
}
