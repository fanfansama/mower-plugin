package com.mower.engine;

import com.mower.engine.impl.MowerControllerImpl;
import com.mower.exception.OutOfRangeException;
import com.mower.geo.core.PointCardinal;
import com.mower.reader.core.Action;
import com.mower.reader.core.DimensionTerrain;
import com.mower.geo.core.Position;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 00:17
 * To change this template use File | Settings | File Templates.
 */
public class BasicTest {

    /**
     5 5
     1 2 N
     GAGAGAGAA -> 1 3 N
     */
    @Test
    public void cas1() throws OutOfRangeException {
        DimensionTerrain terrain = new DimensionTerrain(5,5);
        Position position = new Position(1,2,PointCardinal.NORD);
        MowerController mower = new MowerControllerImpl(position,terrain);
        mower.actionner(Action.GAUCHE);
        mower.actionner(Action.AVANCER);
        mower.actionner(Action.GAUCHE);
        mower.actionner(Action.AVANCER);
        mower.actionner(Action.GAUCHE);
        mower.actionner(Action.AVANCER);
        mower.actionner(Action.GAUCHE);
        mower.actionner(Action.AVANCER);
        mower.actionner(Action.AVANCER);

        Position result = mower.getPosition();
        assertThat(result.getX()).isEqualTo(1);
        assertThat(result.getY()).isEqualTo(3);
        assertThat(result.getPointCardinal()).isEqualTo(PointCardinal.NORD);

    }

    /**
     5 5
     3 3 E
     AADAADADDA -> 5 1 E
     */
    @Test
    public void cas2() throws OutOfRangeException {
        DimensionTerrain terrain = new DimensionTerrain(5,5);
        Position position = new Position(3,3,PointCardinal.EST);
        MowerController mower = new MowerControllerImpl(position ,terrain);

        mower.actionner(Action.AVANCER);
        mower.actionner(Action.AVANCER);
        mower.actionner(Action.DROITE);
        mower.actionner(Action.AVANCER);
        mower.actionner(Action.AVANCER);
        mower.actionner(Action.DROITE);
        mower.actionner(Action.AVANCER);
        mower.actionner(Action.DROITE);
        mower.actionner(Action.DROITE);
        mower.actionner(Action.AVANCER);

        Position result = mower.getPosition();
        assertThat(result.getX()).isEqualTo(5);
        assertThat(result.getY()).isEqualTo(1);
        assertThat(result.getPointCardinal()).isEqualTo(PointCardinal.EST);
    }

}
