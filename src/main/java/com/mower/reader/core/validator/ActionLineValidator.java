package com.mower.reader.core.validator;


import com.mower.reader.core.enums.Action;

import java.util.ArrayList;
import java.util.List;

import static com.mower.misc.Strings.isNullOrEmpty;


/**
 * User: fanfan
 * Date: 14/06/14
 * Time: 21:49
 */
public class ActionLineValidator {

    private ActionValidator actionValidator = new ActionValidator();

    /**
     * Validate each Letter Action
     * @param s
     * @return
     */
    public List<Action> validate(String s){

        if(isNullOrEmpty(s)){
            throw new IllegalArgumentException("Action Line Missing");
        }

        List<Action> actionList = new ArrayList();
        for(int i =0; i!=s.length(); i++){
            Action a = actionValidator.validate(s.substring(i, i + 1));
            if(a!=null){
                actionList.add(a);
            } else {
                throw new IllegalArgumentException("Action Code Unknown");
            }
        }
       return actionList;
    }

}
