package fr.fbe.tondeuse.moteur;

import fr.fbe.tondeuse.exception.OutOfRangeException;
import fr.fbe.tondeuse.geo.PointCardinal;
import fr.fbe.tondeuse.geo.RoseDesVents;
import fr.fbe.tondeuse.programme.Action;
import fr.fbe.tondeuse.programme.DimensionTerrain;
import fr.fbe.tondeuse.programme.Position;
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
public class TondeuseTest {

    private final DimensionTerrain terrain5x5 = new DimensionTerrain(5,5);
    private final DimensionTerrain terrain2x2 = new DimensionTerrain(2,2);
    private final Position est1x1 = new Position(1,1,PointCardinal.EST);

    @Test
    public void avancerAuNord() throws Exception {
        Position position = new Position(1,1, PointCardinal.NORD);
        Tondeuse tondeuse = new Tondeuse(position,terrain2x2);
        tondeuse.actionner(Action.AVANCER);
        assertThat(tondeuse.getCoordonneesX()).isEqualTo( 1 );
        assertThat(tondeuse.getCoordonneesY()).isEqualTo( 2 );
    }

    @Test
    public void avancerAuSud() throws Exception {
        Position position = new Position(1,1, PointCardinal.SUD);
        Tondeuse tondeuse = new Tondeuse(position,terrain2x2);
        tondeuse.actionner(Action.AVANCER);
        assertThat(tondeuse.getCoordonneesX()).isEqualTo( 1 );
        assertThat(tondeuse.getCoordonneesY()).isEqualTo( 0 );
    }

    @Test
    public void avancerAlEst() throws Exception {
        Position position = new Position(1,1, PointCardinal.EST);
        Tondeuse tondeuse = new Tondeuse(position,terrain2x2);

        tondeuse.actionner(Action.AVANCER);
        assertThat(tondeuse.getCoordonneesX()).isEqualTo( 2 );
        assertThat(tondeuse.getCoordonneesY()).isEqualTo( 1 );
    }

    @Test
    public void avancerAlOuest() throws Exception {
        Position position = new Position(1,1, PointCardinal.OUEST);
        Tondeuse tondeuse = new Tondeuse(position,terrain2x2);

        tondeuse.actionner(Action.AVANCER);
        assertThat(tondeuse.getCoordonneesX()).isEqualTo( 0 );
        assertThat(tondeuse.getCoordonneesY()).isEqualTo( 1 );
    }

    @Test(expected = OutOfRangeException.class)
    public void sortir_sud() throws OutOfRangeException {
        Position position = new Position(0,0, PointCardinal.SUD);
        Tondeuse tondeuse = new Tondeuse(position,terrain2x2);
        tondeuse.actionner(Action.AVANCER);

    }

    @Test(expected = OutOfRangeException.class)
    public void sortir_ouest() throws OutOfRangeException {
        Position position = new Position(0,0, PointCardinal.OUEST);
        Tondeuse tondeuse = new Tondeuse(position,terrain2x2);
        tondeuse.actionner(Action.AVANCER);

    }

    @Test(expected = OutOfRangeException.class)
    public void sortir_est() throws OutOfRangeException {
        Position position = new Position(1,1, PointCardinal.EST);
        Tondeuse tondeuse = new Tondeuse(position,terrain2x2);
        tondeuse.actionner(Action.AVANCER);
        assertThat(tondeuse.getCoordonneesX()).isEqualTo(2);
        assertThat(tondeuse.getCoordonneesY()).isEqualTo(1);
        tondeuse.actionner(Action.AVANCER);

    }

    @Test(expected = OutOfRangeException.class)
    public void sortir_nord() throws OutOfRangeException {
        Position position = new Position(2,2, PointCardinal.NORD);
        Tondeuse tondeuse = new Tondeuse(position,terrain2x2);
        tondeuse.actionner(Action.AVANCER);
        fail();
    }


    @Mock
    private RoseDesVents roseDesVents ;

    @InjectMocks
    private Tondeuse tondeuse = new Tondeuse(est1x1,terrain5x5);

    @Test
    public void allerDroite() throws OutOfRangeException {

        given(roseDesVents.allerDroite()).willReturn( PointCardinal.EST, PointCardinal.NORD, PointCardinal.OUEST );

        assertThat( tondeuse.actionner(Action.DROITE) ).isEqualTo(PointCardinal.EST);
        verify(roseDesVents, times(1)).allerDroite();
        assertThat( tondeuse.actionner(Action.DROITE) ).isEqualTo(PointCardinal.NORD);
        verify(roseDesVents, times(2)).allerDroite();
        assertThat( tondeuse.actionner(Action.DROITE) ).isEqualTo(PointCardinal.OUEST);
        verify(roseDesVents, times(3)).allerDroite();

    }

    @Test
    public void allerGauche() throws OutOfRangeException {

        given(roseDesVents.allerGauche()).willReturn( PointCardinal.EST, PointCardinal.NORD, PointCardinal.OUEST );

        assertThat( tondeuse.actionner(Action.GAUCHE) ).isEqualTo(PointCardinal.EST);
        verify(roseDesVents, times(1)).allerGauche();
        assertThat( tondeuse.actionner(Action.GAUCHE) ).isEqualTo(PointCardinal.NORD);
        verify(roseDesVents, times(2)).allerGauche();
        assertThat( tondeuse.actionner(Action.GAUCHE) ).isEqualTo(PointCardinal.OUEST);
        verify(roseDesVents, times(3)).allerGauche();

    }

}
