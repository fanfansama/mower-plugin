package com.mower.geo;

import com.mower.geo.core.enums.Compass;
import com.mower.geo.impl.OrientationServiceImpl;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: fanfan
 * Date: 13/06/14
 * Time: 22:21
 * Test Class of {@link OrientationServiceImpl}
 */
public class OrientationServiceTest {

    @Test
    public void initialisation() throws Exception {

        assertThat(new OrientationServiceImpl(Compass.EST).getOrientation()).isEqualTo(Compass.EST);
        assertThat(new OrientationServiceImpl(Compass.SUD).getOrientation()).isEqualTo(Compass.SUD);
        assertThat(new OrientationServiceImpl(Compass.OUEST).getOrientation()).isEqualTo(Compass.OUEST);
        assertThat(new OrientationServiceImpl(Compass.NORD).getOrientation()).isEqualTo(Compass.NORD);

    }

    @Test
    public void tournerADroite() throws Exception {

        OrientationService orientation = new OrientationServiceImpl(Compass.EST);
        assertThat(orientation.getOrientation()).isEqualTo(Compass.EST);
        assertThat(orientation.turnRight()).isEqualTo(Compass.SUD);
        assertThat(orientation.getOrientation()).isEqualTo(Compass.SUD);
        assertThat(orientation.turnRight()).isEqualTo(Compass.OUEST);
        assertThat(orientation.getOrientation()).isEqualTo(Compass.OUEST);
        assertThat(orientation.turnRight()).isEqualTo(Compass.NORD);
        assertThat(orientation.getOrientation()).isEqualTo(Compass.NORD);
        assertThat(orientation.turnRight()).isEqualTo(Compass.EST);
        assertThat(orientation.getOrientation()).isEqualTo(Compass.EST);
    }

    @Test
    public void tournerAGauche() throws Exception {

        OrientationService orientation = new OrientationServiceImpl(Compass.SUD);

        assertThat(orientation.turnLeft()).isEqualTo(Compass.EST);
        assertThat(orientation.turnLeft()).isEqualTo(Compass.NORD);
        assertThat(orientation.turnLeft()).isEqualTo(Compass.OUEST);
        assertThat(orientation.turnLeft()).isEqualTo(Compass.SUD);
    }

    @Test
    public void tournerADroiteEtAGauche() throws Exception {

        OrientationService orientation = new OrientationServiceImpl(Compass.NORD);

        assertThat(orientation.turnLeft()).isEqualTo(Compass.OUEST);
        assertThat(orientation.turnLeft()).isEqualTo(Compass.SUD);
        assertThat(orientation.turnRight()).isEqualTo(Compass.OUEST);
        assertThat(orientation.turnRight()).isEqualTo(Compass.NORD);
    }

}
