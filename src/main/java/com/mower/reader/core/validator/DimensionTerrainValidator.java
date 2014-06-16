package com.mower.reader.core.validator;


import com.mower.reader.core.DimensionTerrain;

import static java.lang.Integer.parseInt;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 07:52
 * To change this template use File | Settings | File Templates.
 */
public class DimensionTerrainValidator extends Validator<DimensionTerrain> {

    @Override
    protected DimensionTerrain checkValidation() {
        String cX = matcher.group(1);
        String cY = matcher.group(2);

        try {
            int x = parseInt(cX);
            int y = parseInt(cY);
            return new DimensionTerrain(x,y);
        } catch (NumberFormatException nfe){
            throw new IllegalArgumentException("Terrain Dimention must be Integer");
        }
    }

    @Override
    protected String getRegExp() {
        return "^(\\d*)[ ](\\d*)?$";
    }

}
