package fr.fbe.tondeuse.geo;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 13/06/14
 * Time: 22:21
 * To change this template use File | Settings | File Templates.
 */
public class RoseDesVentsTest {

    @Test
    public void initialisation() throws Exception {

        assertThat(new RoseDesVentsImpl(PointCardinal.EST).getOrientation()).isEqualTo(PointCardinal.EST);
        assertThat(new RoseDesVentsImpl(PointCardinal.SUD).getOrientation()).isEqualTo(PointCardinal.SUD);
        assertThat(new RoseDesVentsImpl(PointCardinal.OUEST).getOrientation()).isEqualTo(PointCardinal.OUEST);
        assertThat(new RoseDesVentsImpl(PointCardinal.NORD).getOrientation()).isEqualTo(PointCardinal.NORD);

    }

    @Test
    public void tournerADroite() throws Exception {

        RoseDesVents roseDesVents = new RoseDesVentsImpl(PointCardinal.EST);

        assertThat(roseDesVents.allerDroite()).isEqualTo(PointCardinal.SUD);
        assertThat(roseDesVents.getOrientation()).isEqualTo(PointCardinal.SUD);
        assertThat(roseDesVents.allerDroite()).isEqualTo(PointCardinal.OUEST);
        assertThat(roseDesVents.getOrientation()).isEqualTo(PointCardinal.OUEST);
        assertThat(roseDesVents.allerDroite()).isEqualTo(PointCardinal.NORD);
        assertThat(roseDesVents.getOrientation()).isEqualTo(PointCardinal.NORD);
        assertThat(roseDesVents.allerDroite()).isEqualTo(PointCardinal.EST);
        assertThat(roseDesVents.getOrientation()).isEqualTo(PointCardinal.EST);
    }

    @Test
    public void tournerAGauche() throws Exception {

        RoseDesVents roseDesVents = new RoseDesVentsImpl(PointCardinal.SUD);

        assertThat(roseDesVents.allerGauche()).isEqualTo(PointCardinal.EST);
        assertThat(roseDesVents.allerGauche()).isEqualTo(PointCardinal.NORD);
        assertThat(roseDesVents.allerGauche()).isEqualTo(PointCardinal.OUEST);
        assertThat(roseDesVents.allerGauche()).isEqualTo(PointCardinal.SUD);
    }

    @Test
    public void tournerADrouteEtAGauche() throws Exception {

        RoseDesVents roseDesVents = new RoseDesVentsImpl(PointCardinal.NORD);

        assertThat(roseDesVents.allerGauche()).isEqualTo(PointCardinal.OUEST);
        assertThat(roseDesVents.allerGauche()).isEqualTo(PointCardinal.SUD);
        assertThat(roseDesVents.allerDroite()).isEqualTo(PointCardinal.OUEST);
        assertThat(roseDesVents.allerDroite()).isEqualTo(PointCardinal.NORD);
    }

}
