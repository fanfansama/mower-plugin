package com.mower.reader.core.validator;


import com.mower.reader.core.DimensionTerrain;

import static java.lang.Integer.parseInt;

/**
 * User: fanfan
 * Date: 14/06/14
 * Time: 07:52
 */
public class DimensionTerrainValidator extends Validator<DimensionTerrain> {

    /**
     *
     * @return
     */
    @Override
    protected DimensionTerrain checkValidation() {
        String cX = matcher.group(1);
        String cY = matcher.group(2);

        try {
            int x = parseInt(cX);
            int y = parseInt(cY);
            return new DimensionTerrain(x,y);
        } catch (NumberFormatException nfe){
            throw new IllegalArgumentException("Terrain Dimension must be Integer");
        }
    }

    /**
     *
     * @return
     */
    @Override
    protected String getRegExp() {
        return "^(\\d*)[ ](\\d*)?$";   // 2 numbers with a whitespace
    }

}
