package com.mower.engine;

import com.mower.engine.impl.MowerControllerImpl;
import com.mower.exception.OutOfRangeException;
import com.mower.geo.OrientationService;
import com.mower.geo.core.enums.Compass;
import com.mower.reader.core.enums.Action;
import com.mower.reader.core.DimensionTerrain;
import com.mower.geo.core.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * User: fanfan
 * Date: 13/06/14
 * Time: 23:04
 * Test Class of {@link MowerController}
 */
@RunWith(MockitoJUnitRunner.class)
public class MowerControllerTest {

    private final DimensionTerrain terrain5x5 = new DimensionTerrain(5,5);
    private final DimensionTerrain terrain2x2 = new DimensionTerrain(2,2);
    private final Position est1x1 = new Position(1,1, Compass.EST);

    @Test
    public void avancerAuNord() throws Exception {
        Position position = new Position(1,1, Compass.NORD);
        MowerController controller = new MowerControllerImpl(position,terrain2x2);
        controller.move(Action.AVANCER);
        assertThat(controller.getPosition().getX()).isEqualTo(1);
        assertThat(controller.getPosition().getY()).isEqualTo(2);
        assertThat(controller.getPosition().getCompass()).isEqualTo(Compass.NORD);
    }

    @Test
    public void avancerAuSud() throws Exception {
        Position position = new Position(1,1, Compass.SUD);
        MowerControllerImpl controller = new MowerControllerImpl(position,terrain2x2);
        controller.move(Action.AVANCER);
        assertThat(controller.getPosition().getX()).isEqualTo(1);
        assertThat(controller.getPosition().getY()).isEqualTo(0);
    }

    @Test
    public void avancerAlEst() throws Exception {
        Position position = new Position(1,1, Compass.EST);
        MowerControllerImpl controller = new MowerControllerImpl(position,terrain2x2);

        controller.move(Action.AVANCER);
        assertThat(controller.getPosition().getX()).isEqualTo(2);
        assertThat(controller.getPosition().getY()).isEqualTo(1);
    }

    @Test
    public void avancerAlOuest() throws Exception {
        Position position = new Position(1,1, Compass.OUEST);
        MowerControllerImpl controller = new MowerControllerImpl(position,terrain2x2);

        controller.move(Action.AVANCER);
        assertThat(controller.getPosition().getX()).isEqualTo(0);
        assertThat(controller.getPosition().getY()).isEqualTo(1);
    }

    @Test(expected = OutOfRangeException.class)
    public void sortir_sud() throws OutOfRangeException {
        Position position = new Position(0,0, Compass.SUD);
        MowerControllerImpl controller = new MowerControllerImpl(position,terrain2x2);
        controller.move(Action.AVANCER);

    }

    @Test(expected = OutOfRangeException.class)
    public void sortir_ouest() throws OutOfRangeException {
        Position position = new Position(0,0, Compass.OUEST);
        MowerControllerImpl controller = new MowerControllerImpl(position,terrain2x2);
        controller.move(Action.AVANCER);

    }

    @Test(expected = OutOfRangeException.class)
    public void sortir_est() throws OutOfRangeException {
        Position position = new Position(1,1, Compass.EST);
        MowerControllerImpl controller = new MowerControllerImpl(position,terrain2x2);
        controller.move(Action.AVANCER);
        assertThat(controller.getPosition().getX()).isEqualTo(2);
        assertThat(controller.getPosition().getY()).isEqualTo(1);
        controller.move(Action.AVANCER);

    }

    @Test(expected = OutOfRangeException.class)
    public void sortir_nord() throws OutOfRangeException {
        Position position = new Position(2,2, Compass.NORD);
        MowerControllerImpl controller = new MowerControllerImpl(position,terrain2x2);
        controller.move(Action.AVANCER);
        fail();
    }


    @Mock
    private OrientationService orentation ;

    @InjectMocks
    private MowerControllerImpl controller = new MowerControllerImpl(est1x1,terrain5x5);

    @Test
    public void turnRight() throws OutOfRangeException {

        given(orentation.turnRight()).willReturn( Compass.EST, Compass.NORD, Compass.OUEST );

        assertThat( controller.move(Action.DROITE) ).isEqualTo(Compass.EST);
        verify(orentation, times(1)).turnRight();
        assertThat( controller.move(Action.DROITE) ).isEqualTo(Compass.NORD);
        verify(orentation, times(2)).turnRight();
        assertThat( controller.move(Action.DROITE) ).isEqualTo(Compass.OUEST);
        verify(orentation, times(3)).turnRight();

    }

    @Test
    public void turnLeft() throws OutOfRangeException {

        given(orentation.turnLeft()).willReturn( Compass.EST, Compass.NORD, Compass.OUEST );

        assertThat( controller.move(Action.GAUCHE) ).isEqualTo(Compass.EST);
        verify(orentation, times(1)).turnLeft();
        assertThat( controller.move(Action.GAUCHE) ).isEqualTo(Compass.NORD);
        verify(orentation, times(2)).turnLeft();
        assertThat( controller.move(Action.GAUCHE) ).isEqualTo(Compass.OUEST);
        verify(orentation, times(3)).turnLeft();

    }

}
