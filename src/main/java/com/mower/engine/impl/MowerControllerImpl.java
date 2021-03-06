package com.mower.engine.impl;

import com.mower.engine.MowerController;
import com.mower.exception.OutOfRangeException;
import com.mower.geo.OrientationService;
import com.mower.geo.core.enums.Compass;
import com.mower.geo.impl.OrientationServiceImpl;
import com.mower.reader.core.enums.Action;
import com.mower.reader.core.DimensionTerrain;
import com.mower.geo.core.Position;

/**
 * User: francoisb.
 * Date: 13/06/14
 * Time: 21:13
 * Implementation Class of {@link MowerController}
 */
public class MowerControllerImpl implements MowerController {

    final private DimensionTerrain terrain;

    private OrientationService orientation;
    private int posX;
    private int posY;

    /**
     * Main Constructor with parameters
     * @param pPosition : original position
     * @param pTerrain : Ground Dimension
     */
    public MowerControllerImpl(final Position pPosition, final DimensionTerrain pTerrain){

        if(pPosition == null){
            throw new IllegalArgumentException("Position Missing");
        }
        if(pTerrain == null){
            throw new IllegalArgumentException("DimensionTerrain Missing");
        }
        posX = pPosition.getX();
        posY = pPosition.getY();
        orientation = new OrientationServiceImpl(pPosition.getCompass());
        terrain = pTerrain;

    }

    /**
     * {@see MowerController.getOrientation()}
     */
    private Compass getOrientation(){
        return orientation.getOrientation();
    }

    /**
     * to move the mower
     * @throws OutOfRangeException
     */
    private void move() throws OutOfRangeException {
        switch (getOrientation()) {
            case NORD:
                posY++;
                break;
            case SUD:
                posY--;
                break;
            case EST:
                posX++;
                break;
            case OUEST:
                posX--;
                break;
        }

        if(posX < 0){
            throw new OutOfRangeException("Out of Range should not x<0");
        }
        if(posY < 0){
            throw new OutOfRangeException("Out of Range should not y<0");
        }
        if(terrain.getX() < posX){
            throw new OutOfRangeException("Out of Range should not x>" + terrain.getX());
        }
        if(terrain.getY() < posY){
            throw new OutOfRangeException("Out of Range should not y>" + terrain.getY());
        }
    }

    /**
     * {@see MowerController.move(action)}
     */
    public Compass move(Action action) throws OutOfRangeException, IllegalArgumentException{
        switch (action){
            case AVANCER:
                move();
                return getOrientation();
            case DROITE:
                return orientation.turnRight();
            case GAUCHE:
                return orientation.turnLeft();
            default:
                throw new IllegalArgumentException("Unexpected Action");
        }
    }

    /**
     * toString() Method
     * @return
     */
    public String toString(){
        StringBuilder buf = new StringBuilder();
        buf.append(posX);
        buf.append(" ");
        buf.append(posY);
        buf.append(" ");
        buf.append(getOrientation().getCode());
        return buf.toString();
    }

    /**
     * {@see MowerController.getOrientation()}
     */
    public Position getPosition() {
        return new Position(posX,posY, getOrientation());
    }
}
