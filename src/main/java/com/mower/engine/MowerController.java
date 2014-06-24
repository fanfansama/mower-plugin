package com.mower.engine;

import com.mower.exception.OutOfRangeException;
import com.mower.geo.core.enums.Compass;
import com.mower.reader.core.enums.Action;
import com.mower.geo.core.Position;

/**
 * User: francois
 * Date: 16/06/14
 * Time: 12:44
 */
public interface MowerController {

    /**
     * main mower method
     * @param action
     * @return Compass enum (North, East, South, West)
     * @throws OutOfRangeException
     * @throws IllegalArgumentException
     */
    Compass move(Action action) throws OutOfRangeException, IllegalArgumentException;

    /**
     * getter of the current position
     * @return Position
     */
    Position getPosition();
}
