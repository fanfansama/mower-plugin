package fr.fbe.tondeuse.programme.validateur;


import fr.fbe.tondeuse.programme.Action;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 21:40
 * To change this template use File | Settings | File Templates.
 */
public class ActionValidateur extends Validateur<Action> {

    @Override
    protected Action checkValidation() {
        String chaine = matcher.group(1);

        for(Action c: Action.values()){
            if(c.getLibelle().equals(chaine)){
                return c;
            }
        }
        return null;

    }

    @Override
    protected String getExpressionRegulier() {
        return "^(["
                + Action.AVANCER.getLibelle()
                + Action.DROITE.getLibelle()
                + Action.GAUCHE.getLibelle()
                +"])?$";
    }
}
