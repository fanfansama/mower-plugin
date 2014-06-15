package fr.fbe.tondeuse.programme;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 13/06/14
 * Time: 21:10
 * To change this template use File | Settings | File Templates.
 */
@Getter
public enum Action {
    AVANCER("A"),
    GAUCHE("G"),
    DROITE("D");

    @SuppressWarnings("PMD.SingularField")
    private String libelle;

    Action(String o){
        this.libelle=o;
    }

}
