package fr.fbe.tondeuse.moteur;

import fr.fbe.tondeuse.exception.OutOfRangeException;
import fr.fbe.tondeuse.geo.PointCardinal;
import fr.fbe.tondeuse.geo.RoseDesVents;
import fr.fbe.tondeuse.geo.RoseDesVentsImpl;
import fr.fbe.tondeuse.programme.Action;
import fr.fbe.tondeuse.programme.DimensionTerrain;
import fr.fbe.tondeuse.programme.Position;
import lombok.Getter;

/**
 *
 */
public class Tondeuse {

    final private DimensionTerrain terrain;
    private RoseDesVents roseDesVents;

    @Getter
    private int coordonneesX;
    @Getter
    private int coordonneesY;

    public Tondeuse(final Position pPosition, final DimensionTerrain pTerrain){

        if(pPosition == null){
            throw new IllegalArgumentException("Position Missing");
        }
        if(pTerrain == null){
            throw new IllegalArgumentException("DimensionTerrain Missing");
        }
        coordonneesX = pPosition.getX();
        coordonneesY = pPosition.getY();
        roseDesVents = new RoseDesVentsImpl(pPosition.getPointCardinal());
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
                throw new IllegalArgumentException();
        }
    }

    public String toString(){
        StringBuilder buf = new StringBuilder();
        buf.append(getCoordonneesX());
        buf.append(" ");
        buf.append(getCoordonneesY());
        buf.append(" ");
        buf.append(getOrientation().getLibelle());
        return buf.toString();
    }

    public Position getPosition() {
        return new Position(coordonneesX,coordonneesY, getOrientation());
    }
}
