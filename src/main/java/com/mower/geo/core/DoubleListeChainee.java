package com.mower.geo.core;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 13/06/14
 * Time: 21:18
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
public class DoubleListeChainee {

    Compass compass;

    DoubleListeChainee sensHoraire;
    DoubleListeChainee sensAnteHoraire;


    public DoubleListeChainee(Compass cardinal){
        compass = cardinal;
        sensHoraire = this;
        sensAnteHoraire = this;
    }

    public DoubleListeChainee ajouterDansLeSensHoraire(Compass cardinal){
        DoubleListeChainee chaine = new DoubleListeChainee(cardinal);

        chaine.setSensHoraire(this.getSensHoraire());
        chaine.setSensAnteHoraire(this);

        getSensHoraire().setSensAnteHoraire(chaine);
        setSensHoraire(chaine);

        return chaine;

    }



}
