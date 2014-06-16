package com.mower.engine.impl;

import com.mower.engine.MowerController;
import com.mower.exception.OutOfRangeException;
import com.mower.geo.OrientationService;
import com.mower.geo.impl.OrientationServiceImpl;
import com.mower.geo.core.PointCardinal;
import com.mower.reader.core.Action;
import com.mower.reader.core.DimensionTerrain;
import com.mower.geo.core.Position;

/**
 *
 */
public class MowerControllerImpl implements MowerController {

    final private DimensionTerrain terrain;
    private OrientationService roseDesVents;


    private int coordonneesX;

    private int coordonneesY;

    public MowerControllerImpl(final Position pPosition, final DimensionTerrain pTerrain){

        if(pPosition == null){
            throw new IllegalArgumentException("Position Missing");
        }
        if(pTerrain == null){
            throw new IllegalArgumentException("DimensionTerrain Missing");
        }
        coordonneesX = pPosition.getX();
        coordonneesY = pPosition.getY();
        roseDesVents = new OrientationServiceImpl(pPosition.getPointCardinal());
        terrain = pTerrain;

    }

    public PointCardinal getOrientation(){
        return roseDesVents.getOrientation();
    }

    private void avancer() throws OutOfRangeException {
        switch (getOrientation()) {
            case NORD:
                coordonneesY++;
                break;
            case SUD:
                coordonneesY--;
                break;
            case EST:
                coordonneesX++;
                break;
            case OUEST:
                coordonneesX--;
                break;
        }

        if(coordonneesX < 0){
            throw new OutOfRangeException();
        }
        if(coordonneesY < 0){
            throw new OutOfRangeException();
        }
        if(terrain.getX() < coordonneesX){
            throw new OutOfRangeException();
        }
        if(terrain.getY() < coordonneesY){
            throw new OutOfRangeException();
        }
    }

    private PointCardinal allerDroite(){
        return roseDesVents.allerDroite();
    }

    private PointCardinal allerGauche(){
        return roseDesVents.allerGauche();
    }

    public PointCardinal actionner(Action action) throws OutOfRangeException, IllegalArgumentException{
        switch (action){
            case AVANCER:
                avancer();
                return getOrientation();
            case DROITE:
                return allerDroite();
            case GAUCHE:
                return allerGauche();
            default:
                throw new IllegalArgumentException("Action non prévue");
        }
    }

    public String toString(){
        StringBuilder buf = new StringBuilder();
        buf.append(coordonneesX);
        buf.append(" ");
        buf.append(coordonneesY);
        buf.append(" ");
        buf.append(getOrientation().getLibelle());
        return buf.toString();
    }

    public Position getPosition() {
        return new Position(coordonneesX,coordonneesY, getOrientation());
    }
}
