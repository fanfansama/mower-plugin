package com.mower.geo.impl;

import com.mower.geo.OrientationService;
import com.mower.geo.core.DoubleListeChainee;
import com.mower.geo.core.PointCardinal;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 13/06/14
 * Time: 21:13
 * To change this template use File | Settings | File Templates.
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

    public PointCardinal allerDroite(){
        listeChainee = listeChainee.getSensHoraire();
        return listeChainee.getPointCardinal();
    }

    public PointCardinal allerGauche(){
        listeChainee = listeChainee.getSensAnteHoraire();
        return listeChainee.getPointCardinal();
    }
}
