package org.qw3rtrun.libretro.api.struct;

import java.util.Objects;

public class GameGeometry {

    final private int baseWidth;
    final private int baseHeight;
    final private int maxWidth;
    final private int maxHeight;
    final private float aspectRatio;

    public GameGeometry(int baseWidth, int baseHeight, int maxWidth, int maxHeight, float aspectRatio) {
        this.baseWidth = baseWidth;
        this.baseHeight = baseHeight;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.aspectRatio = aspectRatio;
    }

    public GameGeometry(int width, int height) {
        this(width, height, width, height, height/(float)width);
    }

    public int getBaseWidth() {
        return baseWidth;
    }

    public int getBaseHeight() {
        return baseHeight;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public float getAspectRatio() {
        return aspectRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameGeometry)) return false;
        GameGeometry that = (GameGeometry) o;
        return baseWidth == that.baseWidth &&
                baseHeight == that.baseHeight &&
                maxWidth == that.maxWidth &&
                maxHeight == that.maxHeight &&
                Float.compare(that.aspectRatio, aspectRatio) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(baseWidth, baseHeight, maxWidth, maxHeight, aspectRatio);
    }

    @Override
    public String toString() {
        return "GameGeometry{" +
                "baseWidth=" + baseWidth +
                ", baseHeight=" + baseHeight +
                ", maxWidth=" + maxWidth +
                ", maxHeight=" + maxHeight +
                ", aspectRatio=" + aspectRatio +
                '}';
    }
}
