package com.mower.geo.core;

import com.mower.geo.core.PointCardinal;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 11:52
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@EqualsAndHashCode
@SuppressWarnings("PMD.UnusedPrivateField")
public class Position {
    private int x;
    private int y;
    private PointCardinal pointCardinal;

    public Position(int pX, int pY, PointCardinal pPointCardinal) {
        x=pX;
        y=pY;
        pointCardinal = pPointCardinal;
    }

    public String toString(){
        StringBuilder buf = new StringBuilder();
        buf.append(getX());
        buf.append(" ");
        buf.append(getY());
        buf.append(" ");
        buf.append(getPointCardinal().getLibelle());
        return buf.toString();
    }
}
