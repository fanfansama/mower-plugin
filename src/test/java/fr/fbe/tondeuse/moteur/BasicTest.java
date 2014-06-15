package fr.fbe.tondeuse.moteur;

import fr.fbe.tondeuse.exception.OutOfRangeException;
import fr.fbe.tondeuse.geo.PointCardinal;
import fr.fbe.tondeuse.programme.Action;
import fr.fbe.tondeuse.programme.DimensionTerrain;
import fr.fbe.tondeuse.programme.Position;
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
        Tondeuse tondeuse = new Tondeuse(position,terrain);
        tondeuse.actionner(Action.GAUCHE);
        tondeuse.actionner(Action.AVANCER);
        tondeuse.actionner(Action.GAUCHE);
        tondeuse.actionner(Action.AVANCER);
        tondeuse.actionner(Action.GAUCHE);
        tondeuse.actionner(Action.AVANCER);
        tondeuse.actionner(Action.GAUCHE);
        tondeuse.actionner(Action.AVANCER);
        tondeuse.actionner(Action.AVANCER);

        Position result = tondeuse.getPosition();
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
        Tondeuse tondeuse = new Tondeuse(position ,terrain);

        tondeuse.actionner(Action.AVANCER);
        tondeuse.actionner(Action.AVANCER);
        tondeuse.actionner(Action.DROITE);
        tondeuse.actionner(Action.AVANCER);
        tondeuse.actionner(Action.AVANCER);
        tondeuse.actionner(Action.DROITE);
        tondeuse.actionner(Action.AVANCER);
        tondeuse.actionner(Action.DROITE);
        tondeuse.actionner(Action.DROITE);
        tondeuse.actionner(Action.AVANCER);

        Position result = tondeuse.getPosition();
        assertThat(result.getX()).isEqualTo(5);
        assertThat(result.getY()).isEqualTo(1);
        assertThat(result.getPointCardinal()).isEqualTo(PointCardinal.EST);
    }

}
