package com.mower.geo.impl;

import com.mower.geo.OrientationService;
import com.mower.geo.core.DoubleCircularlyLinkedList;
import com.mower.geo.core.enums.Compass;
import lombok.Getter;
import lombok.Setter;

/**
 * User: francoisb.
 * Date: 13/06/14
 * Time: 21:13
 */
@Getter
@Setter
public class OrientationServiceImpl implements OrientationService {

    private DoubleCircularlyLinkedList linkedList;

    /**
     *
     * @param pDirection
     */
    public OrientationServiceImpl(Compass pDirection){
        // build the Compass Well
        linkedList = new DoubleCircularlyLinkedList(Compass.NORD)
                .addNext(Compass.EST)
                .addNext(Compass.SUD)
                .addNext(Compass.OUEST);

        while ( !pDirection.equals(linkedList.getCompass())  ){
            linkedList = linkedList.getClockwise();
        }
    }

    /**
     *
     * @return
     */
    public Compass getOrientation(){
        return linkedList == null ? null : linkedList.getCompass();
    }

    /**
     *
     * @return
     */
    public Compass turnRight(){
        // clockwise could not be null
        linkedList = linkedList.getClockwise();
        return linkedList.getCompass();
    }

    /**
     *
     * @return
     */
    public Compass turnLeft(){
        // anticlockwise could not be null
        linkedList = linkedList.getAnticlockwise();
        return linkedList.getCompass();
    }
}
