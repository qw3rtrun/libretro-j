package org.qw3rtrun.libretro;

import java.util.Objects;

public class Variable {

    private final String key;
    private final String value;

    public Variable(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Variable)) return false;
        Variable variable = (Variable) o;
        return Objects.equals(key, variable.key) &&
                Objects.equals(value, variable.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "Variable{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
