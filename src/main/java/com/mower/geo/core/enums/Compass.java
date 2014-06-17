package com.mower.geo.core.enums;

import lombok.Getter;

/**
 * User: fanfan
 * Date: 13/06/14
 * Time: 21:10
 */
@Getter
public enum Compass {
    NORD("N"),
    SUD("S"),
    EST("E"),
    OUEST("O");

    @SuppressWarnings("PMD.SingularField")
    private String code;

    Compass(String o){
        this.code=o;
    }

}
