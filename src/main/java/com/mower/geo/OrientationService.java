package com.mower.geo;

import com.mower.geo.core.enums.Compass;

/**
 * Orientation Service : "Pour ne pas perdre le nord"
 * "They know on which side their bread is buttered "
 *
 * User: francoisb.
 * Date: 14/06/14
 * Time: 00:04
 */
public interface OrientationService {

    Compass getOrientation();

    Compass turnRight();

    Compass turnLeft();
}
