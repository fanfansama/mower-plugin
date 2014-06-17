package com.mower.reader.core.enums;

import lombok.Getter;

/**
 * User: fanfan
 * Date: 13/06/14
 * Time: 21:10
 */
@Getter
public enum Action {
    AVANCER("A"),
    GAUCHE("G"),
    DROITE("D");

    @SuppressWarnings("PMD.SingularField")
    private String code;

    Action(String o){
        this.code =o;
    }

}
