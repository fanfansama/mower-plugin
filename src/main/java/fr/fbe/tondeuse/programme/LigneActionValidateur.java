package fr.fbe.tondeuse.programme;


import fr.fbe.tondeuse.programme.validateur.ActionValidateur;

import java.util.ArrayList;
import java.util.List;

import static fr.fbe.tondeuse.Strings.isNullOrEmpty;


/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 21:49
 * To change this template use File | Settings | File Templates.
 */
public class LigneActionValidateur {

    private ActionValidateur validateur = new ActionValidateur();

    /**
     *
     * @param chaine
     * @return
     */
    public List<Action> valide(String chaine){

        if(isNullOrEmpty(chaine)){
            throw new IllegalArgumentException("Ligne action non présente");
        }

        List<Action> actionList = new ArrayList();
        for(int i =0; i!=chaine.length(); i++){
            Action a = validateur.valide(chaine.substring(i, i + 1));
            if(a!=null){
                actionList.add(a);
            } else {
                throw new IllegalArgumentException("Code action inconnu");
            }
        }
       return actionList;
    }

}
