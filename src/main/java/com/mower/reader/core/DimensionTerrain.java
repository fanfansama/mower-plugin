package com.mower.reader.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * User: fanfan
 * Date: 14/06/14
 * Time: 08:23
 */
@Getter
@Setter
@EqualsAndHashCode
@SuppressWarnings("PMD.UnusedPrivateField")
public class DimensionTerrain {

    private int x;
    private int y;

    public DimensionTerrain(int pX, int pY) {
        this.x = pX;
        this.y = pY;
    }
}
