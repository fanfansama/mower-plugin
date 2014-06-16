package com.mower.geo.impl;

import com.mower.geo.OrientationService;
import com.mower.geo.core.Compass;
import com.mower.geo.core.DoubleListeChainee;
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

    public OrientationServiceImpl(Compass direction){
        listeChainee = new DoubleListeChainee(Compass.NORD)
                .ajouterDansLeSensHoraire(Compass.EST)
                .ajouterDansLeSensHoraire(Compass.SUD)
                .ajouterDansLeSensHoraire(Compass.OUEST);

        while ( !direction.equals(listeChainee.getCompass())  ){
            listeChainee = listeChainee.getSensHoraire();
        }
    }

    public Compass getOrientation(){
        return listeChainee == null ? null : listeChainee.getCompass();
    }

    public Compass turnRight(){
        listeChainee = listeChainee.getSensHoraire();
        return listeChainee.getCompass();
    }

    public Compass turnLeft(){
        listeChainee = listeChainee.getSensAnteHoraire();
        return listeChainee.getCompass();
    }
}
