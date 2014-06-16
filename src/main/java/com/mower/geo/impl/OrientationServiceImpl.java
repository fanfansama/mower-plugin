package com.mower.geo.impl;

import com.mower.geo.OrientationService;
import com.mower.geo.core.DoubleListeChainee;
import com.mower.geo.core.PointCardinal;
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

    private DoubleListeChainee listeChainee;

    public OrientationServiceImpl(PointCardinal direction){
        listeChainee = new DoubleListeChainee(PointCardinal.NORD)
                .ajouterDansLeSensHoraire(PointCardinal.EST)
                .ajouterDansLeSensHoraire(PointCardinal.SUD)
                .ajouterDansLeSensHoraire(PointCardinal.OUEST);

        while ( !direction.equals(listeChainee.getPointCardinal())  ){
            listeChainee = listeChainee.getSensHoraire();
        }
    }

    public PointCardinal getOrientation(){
        return listeChainee == null ? null : listeChainee.getPointCardinal();
    }

    public PointCardinal turnRight(){
        listeChainee = listeChainee.getSensHoraire();
        return listeChainee.getPointCardinal();
    }

    public PointCardinal turnLeft(){
        listeChainee = listeChainee.getSensAnteHoraire();
        return listeChainee.getPointCardinal();
    }
}
