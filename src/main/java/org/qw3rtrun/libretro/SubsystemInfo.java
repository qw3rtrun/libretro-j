package org.qw3rtrun.libretro;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SubsystemInfo {

    private final String description;

    private final String identifier;

    private final List<RomInfo> roms;

    public SubsystemInfo(String description, String identifier, RomInfo... roms) {
        Objects.requireNonNull(description);
        Objects.requireNonNull(identifier);
        Objects.checkIndex(0, roms.length);
        this.description = description;
        this.identifier = identifier;
        this.roms = List.of(roms);
    }

    public String getDescription() {
        return description;
    }

    public String getIdentifier() {
        return identifier;
    }

    public List<RomInfo> getRoms() {
        return roms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubsystemInfo)) return false;
        SubsystemInfo that = (SubsystemInfo) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(identifier, that.identifier) &&
                Objects.equals(roms, that.roms);
    }

    @Override
    public int hashCode() {

        return Objects.hash(description, identifier, roms);
    }

    @Override
    public String toString() {
        return "SubsystemInfo{" +
                "description='" + description + '\'' +
                ", identifier='" + identifier + '\'' +
                ", roms=" + roms +
                '}';
    }
}
