package com.mower.geo.core;

import com.mower.geo.core.enums.Compass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * User: fanfan
 * Date: 14/06/14
 * Time: 11:52
 */
@Getter
@Setter
@EqualsAndHashCode
@SuppressWarnings("PMD.UnusedPrivateField")
public class Position {
    private int x;
    private int y;
    private Compass compass;

    public Position(int pX, int pY, Compass pCompass) {
        x=pX;
        y=pY;
        compass = pCompass;
    }

    public String toString(){
        StringBuilder buf = new StringBuilder();
        buf.append(getX());
        buf.append(" ");
        buf.append(getY());
        buf.append(" ");
        buf.append(this.getCompass().getCode());
        return buf.toString();
    }
}
