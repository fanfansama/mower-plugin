package com.mower.reader.core.validator;


import com.mower.reader.core.enums.Action;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 21:40
 * To change this template use File | Settings | File Templates.
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
