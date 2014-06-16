package com.mower.reader.core.validator;


import com.mower.reader.core.Action;

import java.util.ArrayList;
import java.util.List;

import static com.mower.Strings.isNullOrEmpty;


/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 21:49
 * To change this template use File | Settings | File Templates.
 */
public class ActionLineValidator {

    private ActionValidator validator = new ActionValidator();

    /**
     *
     * @param chaine
     * @return
     */
    public List<Action> valide(String chaine){

        if(isNullOrEmpty(chaine)){
            throw new IllegalArgumentException("Action Line Missing");
        }

        List<Action> actionList = new ArrayList();
        for(int i =0; i!=chaine.length(); i++){
            Action a = validator.valide(chaine.substring(i, i + 1));
            if(a!=null){
                actionList.add(a);
            } else {
                throw new IllegalArgumentException("Action Code unknown");
            }
        }
       return actionList;
    }

}
