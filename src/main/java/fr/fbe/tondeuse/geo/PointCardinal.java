package fr.fbe.tondeuse.geo;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 13/06/14
 * Time: 21:10
 * To change this template use File | Settings | File Templates.
 */
@Getter
public enum PointCardinal {
    NORD("N"),
    SUD("S"),
    EST("E"),
    OUEST("O");

    @SuppressWarnings("PMD.SingularField")
    private String libelle;

    PointCardinal(String o){
        this.libelle=o;
    }

}
