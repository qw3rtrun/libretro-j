package org.qw3rtrun.libretro.struct;

import java.util.Objects;

/* Describes how the libretro implementation maps a libretro input bind
 * to its internal input system through a human readable string.
 * This string can be used to better let a user configure input. */
public class InputDescriptor {

    private final int port;
    private final int device;
    private final int index;
    private final int id;
    private final String description;

    public InputDescriptor(int port, int device, int index, int id, String description) {
        this.port = port;
        this.device = device;
        this.index = index;
        this.id = id;
        this.description = description;
    }

    public int getPort() {
        return port;
    }

    public int getDevice() {
        return device;
    }

    public int getIndex() {
        return index;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InputDescriptor)) return false;
        InputDescriptor that = (InputDescriptor) o;
        return port == that.port &&
                device == that.device &&
                index == that.index &&
                id == that.id &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(port, device, index, id, description);
    }

    @Override
    public String toString() {
        return "InputDescriptor{" +
                "port=" + port +
                ", device=" + device +
                ", index=" + index +
                ", id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
