package com.mower.reader.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 08:23
 * To change this template use File | Settings | File Templates.
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
