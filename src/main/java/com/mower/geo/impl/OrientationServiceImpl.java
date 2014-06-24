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
 * Implementation of {@link OrientationService}
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
     * {@see OrientionService.getOrientation()}
     */
    public Compass getOrientation(){
        return linkedList == null ? null : linkedList.getCompass();
    }

    /**
     * {@see OrientionService.turnRight()}
     */
    public Compass turnRight(){
        // clockwise could not be null
        linkedList = linkedList.getClockwise();
        return linkedList.getCompass();
    }

    /**
     * {@see OrientionService.turnLeft()}
     */
    public Compass turnLeft(){
        // anticlockwise could not be null
        linkedList = linkedList.getAnticlockwise();
        return linkedList.getCompass();
    }
}
