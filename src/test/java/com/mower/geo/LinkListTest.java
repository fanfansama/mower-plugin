package com.mower.geo;

import com.mower.geo.core.DoubleCircularlyLinkedList;
import com.mower.geo.core.enums.Compass;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: fanfan
 * Date: 13/06/14
 * Time: 21:32
 */
public class LinkListTest {

    @Test
    public void oneElementGettersNotNull() throws Exception {

        DoubleCircularlyLinkedList linkedList = new DoubleCircularlyLinkedList(Compass.NORD);
        assertThat(linkedList.getAnticlockwise()).isNotNull().isEqualTo(linkedList);
        assertThat(linkedList.getClockwise()).isNotNull().isEqualTo(linkedList);

    }

    @Test
    public void twoElements(){

        DoubleCircularlyLinkedList nord = new DoubleCircularlyLinkedList(Compass.NORD);
        DoubleCircularlyLinkedList sud = nord.addNext(Compass.SUD);

        assertThat(nord.getAnticlockwise()).isNotNull().isEqualTo(sud);
        assertThat(nord.getClockwise()).isNotNull().isEqualTo(sud);

        assertThat(sud.getAnticlockwise()).isNotNull().isEqualTo(nord);
        assertThat(sud.getClockwise()).isNotNull().isEqualTo(nord);

    }

    @Test
    public void treeElements(){

        DoubleCircularlyLinkedList nord = new DoubleCircularlyLinkedList(Compass.NORD);
        DoubleCircularlyLinkedList est = nord.addNext(Compass.EST);
        DoubleCircularlyLinkedList sud = est.addNext(Compass.SUD);

        assertThat(nord.getAnticlockwise()).isNotNull().isEqualTo(sud);
        assertThat(nord.getClockwise()).isNotNull().isEqualTo(est);

        assertThat(sud.getAnticlockwise()).isNotNull().isEqualTo(est);
        assertThat(sud.getClockwise()).isNotNull().isEqualTo(nord);

        assertThat(est.getAnticlockwise()).isNotNull().isEqualTo(nord);
        assertThat(est.getClockwise()).isNotNull().isEqualTo(sud);

    }

}
