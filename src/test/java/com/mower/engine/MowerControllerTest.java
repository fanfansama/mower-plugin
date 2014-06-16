package com.mower.engine;

import com.mower.engine.impl.MowerControllerImpl;
import com.mower.exception.OutOfRangeException;
import com.mower.geo.OrientationService;
import com.mower.geo.core.PointCardinal;
import com.mower.reader.core.Action;
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
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 13/06/14
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */
@RunWith(MockitoJUnitRunner.class)
public class MowerControllerTest {

    private final DimensionTerrain terrain5x5 = new DimensionTerrain(5,5);
    private final DimensionTerrain terrain2x2 = new DimensionTerrain(2,2);
    private final Position est1x1 = new Position(1,1,PointCardinal.EST);

    @Test
    public void avancerAuNord() throws Exception {
        Position position = new Position(1,1, PointCardinal.NORD);
        MowerController mowerControllerImpl = new MowerControllerImpl(position,terrain2x2);
        mowerControllerImpl.actionner(Action.AVANCER);
        assertThat(mowerControllerImpl.getPosition().getX()).isEqualTo( 1 );
        assertThat(mowerControllerImpl.getPosition().getY()).isEqualTo( 2 );
        assertThat(mowerControllerImpl.getPosition().getPointCardinal()).isEqualTo( PointCardinal.NORD );
    }

    @Test
    public void avancerAuSud() throws Exception {
        Position position = new Position(1,1, PointCardinal.SUD);
        MowerControllerImpl mowerControllerImpl = new MowerControllerImpl(position,terrain2x2);
        mowerControllerImpl.actionner(Action.AVANCER);
        assertThat(mowerControllerImpl.getPosition().getX()).isEqualTo( 1 );
        assertThat(mowerControllerImpl.getPosition().getY()).isEqualTo( 0 );
    }

    @Test
    public void avancerAlEst() throws Exception {
        Position position = new Position(1,1, PointCardinal.EST);
        MowerControllerImpl mowerControllerImpl = new MowerControllerImpl(position,terrain2x2);

        mowerControllerImpl.actionner(Action.AVANCER);
        assertThat(mowerControllerImpl.getPosition().getX()).isEqualTo( 2 );
        assertThat(mowerControllerImpl.getPosition().getY()).isEqualTo( 1 );
    }

    @Test
    public void avancerAlOuest() throws Exception {
        Position position = new Position(1,1, PointCardinal.OUEST);
        MowerControllerImpl mowerControllerImpl = new MowerControllerImpl(position,terrain2x2);

        mowerControllerImpl.actionner(Action.AVANCER);
        assertThat(mowerControllerImpl.getPosition().getX()).isEqualTo( 0 );
        assertThat(mowerControllerImpl.getPosition().getY()).isEqualTo( 1 );
    }

    @Test(expected = OutOfRangeException.class)
    public void sortir_sud() throws OutOfRangeException {
        Position position = new Position(0,0, PointCardinal.SUD);
        MowerControllerImpl mowerControllerImpl = new MowerControllerImpl(position,terrain2x2);
        mowerControllerImpl.actionner(Action.AVANCER);

    }

    @Test(expected = OutOfRangeException.class)
    public void sortir_ouest() throws OutOfRangeException {
        Position position = new Position(0,0, PointCardinal.OUEST);
        MowerControllerImpl mowerControllerImpl = new MowerControllerImpl(position,terrain2x2);
        mowerControllerImpl.actionner(Action.AVANCER);

    }

    @Test(expected = OutOfRangeException.class)
    public void sortir_est() throws OutOfRangeException {
        Position position = new Position(1,1, PointCardinal.EST);
        MowerControllerImpl mowerControllerImpl = new MowerControllerImpl(position,terrain2x2);
        mowerControllerImpl.actionner(Action.AVANCER);
        assertThat(mowerControllerImpl.getPosition().getX()).isEqualTo(2);
        assertThat(mowerControllerImpl.getPosition().getY()).isEqualTo(1);
        mowerControllerImpl.actionner(Action.AVANCER);

    }

    @Test(expected = OutOfRangeException.class)
    public void sortir_nord() throws OutOfRangeException {
        Position position = new Position(2,2, PointCardinal.NORD);
        MowerControllerImpl mowerControllerImpl = new MowerControllerImpl(position,terrain2x2);
        mowerControllerImpl.actionner(Action.AVANCER);
        fail();
    }


    @Mock
    private OrientationService roseDesVents ;

    @InjectMocks
    private MowerControllerImpl mowerControllerImpl = new MowerControllerImpl(est1x1,terrain5x5);

    @Test
    public void allerDroite() throws OutOfRangeException {

        given(roseDesVents.allerDroite()).willReturn( PointCardinal.EST, PointCardinal.NORD, PointCardinal.OUEST );

        assertThat( mowerControllerImpl.actionner(Action.DROITE) ).isEqualTo(PointCardinal.EST);
        verify(roseDesVents, times(1)).allerDroite();
        assertThat( mowerControllerImpl.actionner(Action.DROITE) ).isEqualTo(PointCardinal.NORD);
        verify(roseDesVents, times(2)).allerDroite();
        assertThat( mowerControllerImpl.actionner(Action.DROITE) ).isEqualTo(PointCardinal.OUEST);
        verify(roseDesVents, times(3)).allerDroite();

    }

    @Test
    public void allerGauche() throws OutOfRangeException {

        given(roseDesVents.allerGauche()).willReturn( PointCardinal.EST, PointCardinal.NORD, PointCardinal.OUEST );

        assertThat( mowerControllerImpl.actionner(Action.GAUCHE) ).isEqualTo(PointCardinal.EST);
        verify(roseDesVents, times(1)).allerGauche();
        assertThat( mowerControllerImpl.actionner(Action.GAUCHE) ).isEqualTo(PointCardinal.NORD);
        verify(roseDesVents, times(2)).allerGauche();
        assertThat( mowerControllerImpl.actionner(Action.GAUCHE) ).isEqualTo(PointCardinal.OUEST);
        verify(roseDesVents, times(3)).allerGauche();

    }

}
