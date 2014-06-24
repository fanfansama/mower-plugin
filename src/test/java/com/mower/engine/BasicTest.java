package com.mower.engine;

import com.mower.engine.impl.MowerControllerImpl;
import com.mower.exception.OutOfRangeException;
import com.mower.geo.core.enums.Compass;
import com.mower.reader.core.enums.Action;
import com.mower.reader.core.DimensionTerrain;
import com.mower.geo.core.Position;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: fanfan
 * Date: 14/06/14
 * Time: 00:17
 * Basic Test Case
 */
public class BasicTest {

    /**
     5 5
     1 2 N
     GAGAGAGAA -> 1 3 N
     */
    @Test
    public void premierJeuDesSpecs() throws OutOfRangeException {
        DimensionTerrain terrain = new DimensionTerrain(5,5);
        Position position = new Position(1,2, Compass.NORD);
        MowerController mower = new MowerControllerImpl(position,terrain);
        mower.move(Action.GAUCHE);
        mower.move(Action.AVANCER);
        mower.move(Action.GAUCHE);
        mower.move(Action.AVANCER);
        mower.move(Action.GAUCHE);
        mower.move(Action.AVANCER);
        mower.move(Action.GAUCHE);
        mower.move(Action.AVANCER);
        mower.move(Action.AVANCER);

        Position result = mower.getPosition();
        assertThat(result.getX()).isEqualTo(1);
        assertThat(result.getY()).isEqualTo(3);
        assertThat(result.getCompass()).isEqualTo(Compass.NORD);

    }

    /**
     5 5
     3 3 E
     AADAADADDA -> 5 1 E
     */
    @Test
    public void secondJeuDesSpecs() throws OutOfRangeException {
        DimensionTerrain terrain = new DimensionTerrain(5,5);
        Position position = new Position(3,3, Compass.EST);
        MowerController mower = new MowerControllerImpl(position ,terrain);

        mower.move(Action.AVANCER);
        mower.move(Action.AVANCER);
        mower.move(Action.DROITE);
        mower.move(Action.AVANCER);
        mower.move(Action.AVANCER);
        mower.move(Action.DROITE);
        mower.move(Action.AVANCER);
        mower.move(Action.DROITE);
        mower.move(Action.DROITE);
        mower.move(Action.AVANCER);

        Position result = mower.getPosition();
        assertThat(result.getX()).isEqualTo(5);
        assertThat(result.getY()).isEqualTo(1);
        assertThat(result.getCompass()).isEqualTo(Compass.EST);
    }

}
