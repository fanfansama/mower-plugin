package com.mower.geo;

import com.mower.geo.core.Compass;

/**
 * User: francoisb.
 * Date: 14/06/14
 * Time: 00:04
 */
public interface OrientationService {

    Compass getOrientation();

    Compass turnRight();

    Compass turnLeft();
}
