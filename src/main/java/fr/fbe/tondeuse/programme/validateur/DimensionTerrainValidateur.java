package fr.fbe.tondeuse.programme.validateur;


import fr.fbe.tondeuse.programme.DimensionTerrain;

import static java.lang.Integer.parseInt;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 07:52
 * To change this template use File | Settings | File Templates.
 */
public class DimensionTerrainValidateur extends Validateur<DimensionTerrain> {

    @Override
    protected DimensionTerrain checkValidation() {
        String chaineX = matcher.group(1);
        String chaineY = matcher.group(2);

        try {
            int x = parseInt(chaineX);
            int y = parseInt(chaineY);
            return new DimensionTerrain(x,y);
        } catch (NumberFormatException nfe){
            return null;
        }
    }

    @Override
    protected String getExpressionRegulier() {
        return "^(\\d*)[ ](\\d*)?$";
    }

}
