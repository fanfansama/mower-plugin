package com.mower.reader.core.validator;


import com.mower.reader.core.enums.Action;

/**
 * User: fanfan
 * Date: 14/06/14
 * Time: 21:40
 */
public class ActionValidator extends Validator<Action> {

    @Override
    protected Action checkValidation() {
        String string = matcher.group(1);

        for(Action c: Action.values()){
            if(c.getCode().equals(string)){
                return c;
            }
        }
        return null;

    }

    @Override
    protected String getRegExp() {
        return "^(["
                + Action.AVANCER.getCode()
                + Action.DROITE.getCode()
                + Action.GAUCHE.getCode()
                +"])?$";
    }
}
