package com.mower.engine;

import com.mower.exception.OutOfRangeException;
import com.mower.geo.core.Compass;
import com.mower.reader.core.Action;
import com.mower.geo.core.Position;

/**
 * Created with IntelliJ IDEA.
 * User: francois
 * Date: 16/06/14
 * Time: 12:44
 * To change this template use File | Settings | File Templates.
 */
public interface MowerController {

    Compass actionner(Action action) throws OutOfRangeException, IllegalArgumentException;

    Position getPosition();
}
