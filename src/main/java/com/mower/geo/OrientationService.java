package com.mower.geo;

import com.mower.geo.core.PointCardinal;

/**
 * User: francoisb.
 * Date: 14/06/14
 * Time: 00:04
 */
public interface OrientationService {

    PointCardinal getOrientation();

    PointCardinal turnRight();

    PointCardinal turnLeft();
}
