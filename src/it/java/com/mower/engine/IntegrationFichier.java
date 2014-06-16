package com.mower.engine;

import com.mower.exception.OutOfRangeException;
import com.mower.geo.core.PointCardinal;
import com.mower.reader.Parseur;
import com.mower.geo.core.Position;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: francois
 * Date: 16/06/14
 * Time: 09:39
 */
public class IntegrationFichier {

    private Position expectedBasic = new Position(1,5, PointCardinal.NORD);
    private Position expectedBasic1 = new Position(1,3, PointCardinal.NORD);
    private Position expectedBasic2 = new Position(5,1, PointCardinal.EST);

    @Test
    public void fichierDeRefence() throws IOException, OutOfRangeException {
        Parseur parseur = new Parseur("/basic.txt");
        List result = parseur.traitement();
        assertThat(result).isNotNull().isNotEmpty().hasSize(3)
                .containsExactly(expectedBasic, expectedBasic1, expectedBasic2);
    }

}