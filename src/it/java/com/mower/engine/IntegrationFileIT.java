package com.mower.engine;

import com.mower.exception.OutOfRangeException;
import com.mower.geo.core.enums.Compass;
import com.mower.reader.Parser;
import com.mower.geo.core.Position;
import com.mower.reader.impl.ParserImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: francois
 * Date: 16/06/14
 * Time: 09:39
 */
public class IntegrationFileIT {

    private Position expectedBasic = new Position(1,5, Compass.NORD);
    private Position expectedBasic1 = new Position(1,3, Compass.NORD);
    private Position expectedBasic2 = new Position(5,1, Compass.EST);

    @Test
    public void fichierDeRefence() throws IOException, OutOfRangeException {
        Parser parser = new ParserImpl("/src/it/resources/basic.txt");
        List result = parser.process();
        assertThat(result).isNotNull().isNotEmpty().hasSize(3)
                .containsExactly(expectedBasic, expectedBasic1, expectedBasic2);
    }

}
