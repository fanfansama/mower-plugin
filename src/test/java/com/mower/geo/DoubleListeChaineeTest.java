package com.mower.geo;

import com.mower.geo.core.Compass;
import com.mower.geo.core.DoubleListeChainee;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 13/06/14
 * Time: 21:32
 * To change this template use File | Settings | File Templates.
 */
public class DoubleListeChaineeTest {

    @Test
    public void oneElementGettersNotNull() throws Exception {

        DoubleListeChainee listeChainee = new DoubleListeChainee(Compass.NORD);
        assertThat(listeChainee.getSensAnteHoraire()).isNotNull().isEqualTo(listeChainee);
        assertThat(listeChainee.getSensHoraire()).isNotNull().isEqualTo(listeChainee);

    }

    @Test
    public void twoElements(){

        DoubleListeChainee nord = new DoubleListeChainee(Compass.NORD);
        DoubleListeChainee sud = nord.ajouterDansLeSensHoraire(Compass.SUD);

        assertThat(nord.getSensAnteHoraire()).isNotNull().isEqualTo(sud);
        assertThat(nord.getSensHoraire()).isNotNull().isEqualTo(sud);

        assertThat(sud.getSensAnteHoraire()).isNotNull().isEqualTo(nord);
        assertThat(sud.getSensHoraire()).isNotNull().isEqualTo(nord);

    }

    @Test
    public void treeElements(){

        DoubleListeChainee nord = new DoubleListeChainee(Compass.NORD);
        DoubleListeChainee est = nord.ajouterDansLeSensHoraire(Compass.EST);
        DoubleListeChainee sud = est.ajouterDansLeSensHoraire(Compass.SUD);

        assertThat(nord.getSensAnteHoraire()).isNotNull().isEqualTo(sud);
        assertThat(nord.getSensHoraire()).isNotNull().isEqualTo(est);

        assertThat(sud.getSensAnteHoraire()).isNotNull().isEqualTo(est);
        assertThat(sud.getSensHoraire()).isNotNull().isEqualTo(nord);

        assertThat(est.getSensAnteHoraire()).isNotNull().isEqualTo(nord);
        assertThat(est.getSensHoraire()).isNotNull().isEqualTo(sud);

    }

}
