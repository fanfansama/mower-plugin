package com.mower.reader;

import com.mower.exception.OutOfRangeException;
import com.mower.geo.core.Position;

import java.io.IOException;
import java.util.List;

/**
 * User: francois b.
 * Date: 16/06/14 22:32
 * Parser Engine
 */
public interface Parser {

    /**
     * process a file
     * @return List of Position
     * @throws OutOfRangeException
     * @throws IOException
     */
    List<Position> process() throws OutOfRangeException, IOException;

}
