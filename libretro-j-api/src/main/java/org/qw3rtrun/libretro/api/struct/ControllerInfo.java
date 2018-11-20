package org.qw3rtrun.libretro.api.struct;

import java.util.Objects;

public class ControllerInfo {

    private final String description;

    private final int id;

    public ControllerInfo(String description, int id) {
        this.description = description;
        this.id = id;
    }

    public ControllerInfo(String description, DeviceType type, int number) {
        this(description, type.id(number));
    }

    public ControllerInfo(String description, DeviceType type) {
        this(description, type, 0);
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ControllerInfo)) return false;
        ControllerInfo that = (ControllerInfo) o;
        return id == that.id &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(description, id);
    }

    @Override
    public String toString() {
        return "ControllerInfo{" +
                "description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
