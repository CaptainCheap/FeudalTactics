// SPDX-License-Identifier: GPL-3.0-or-later

package de.sesu8642.feudaltactics.lib.gamestate;

import com.badlogic.gdx.math.Vector2;

import java.util.Objects;

/**
 * Class containing metadata about the map size and its center.
 **/
public class MapDimensions {
    private Vector2 center;
    private float width;
    private float height;

    public Vector2 getCenter() {
        return center;
    }

    public void setCenter(Vector2 center) {
        this.center = center;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, height, width);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MapDimensions other = (MapDimensions) obj;
        return Objects.equals(center, other.center)
                && Float.floatToIntBits(height) == Float.floatToIntBits(other.height)
                && Float.floatToIntBits(width) == Float.floatToIntBits(other.width);
    }

}