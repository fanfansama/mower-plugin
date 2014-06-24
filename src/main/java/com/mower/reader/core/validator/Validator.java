package com.mower.reader.core.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: fanfan
 * Date: 14/06/14
 * Time: 11:54
 * Generic Validator
 */
abstract class Validator<K> {

    protected Pattern pattern;
    protected Matcher matcher;

    protected abstract K checkValidation();

    protected abstract String getRegExp();

    /**
     *
     * @param value
     * @return
     */
    public K validate(String value){
        return value == null ? null : match(value.trim());
    }

    /**
     *
     * @param valeur
     * @return
     */
    private K match(String valeur) {
        if( valeur.matches(getRegExp()) ){
            pattern = Pattern.compile(getRegExp());
            matcher = pattern.matcher(valeur);

            if (matcher.matches()) {
                matcher.reset();
                if (matcher.find()) {
                    return checkValidation();
                }
            }

            return null;

        } else {
            return null;
        }
    }

}
