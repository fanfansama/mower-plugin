package fr.fbe.tondeuse.geo;

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

    PointCardinal pointCardinal;

    DoubleListeChainee sensHoraire;
    DoubleListeChainee sensAnteHoraire;


    public DoubleListeChainee(PointCardinal cardinal){
        pointCardinal = cardinal;
        sensHoraire = this;
        sensAnteHoraire = this;
    }

    public DoubleListeChainee ajouterDansLeSensHoraire(PointCardinal cardinal){
        DoubleListeChainee chaine = new DoubleListeChainee(cardinal);

        chaine.setSensHoraire(this.getSensHoraire());
        chaine.setSensAnteHoraire(this);

        getSensHoraire().setSensAnteHoraire(chaine);
        setSensHoraire(chaine);

        return chaine;

    }



}
