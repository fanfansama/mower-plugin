package com.mower.geo.core;

import com.mower.geo.core.enums.Compass;
import lombok.Getter;
import lombok.Setter;

/**
 * User: fanfan
 * Date: 13/06/14
 * Time: 21:18
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DoubleCircularlyLinkedList {

    private Compass compass;

    private DoubleCircularlyLinkedList clockwise;
    private DoubleCircularlyLinkedList anticlockwise;

    /**
     *
     * @param pCardinal
     */
    public DoubleCircularlyLinkedList(Compass pCardinal){
        compass = pCardinal;
        clockwise = this;
        anticlockwise = this;
    }

    /**
     * put a new Compass element at right
     * @param pCompass
     * @return
     */
    public DoubleCircularlyLinkedList addNext(Compass pCompass){
        DoubleCircularlyLinkedList node = new DoubleCircularlyLinkedList(pCompass);

        node.setClockwise(this.getClockwise());
        node.setAnticlockwise(this);

        this.getClockwise().setAnticlockwise(node);
        this.setClockwise(node);

        return node;

    }



}
