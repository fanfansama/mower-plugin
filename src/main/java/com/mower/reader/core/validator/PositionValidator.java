package com.mower.reader.core.validator;

import com.mower.geo.core.Compass;
import com.mower.geo.core.Position;

import static java.lang.Integer.parseInt;

/**
 * User: fanfan
 * Date: 14/06/14
 * Time: 11:57
 */
public class PositionValidator extends Validator<Position> {


    @Override
    protected Position checkValidation() {
        String chaineX = matcher.group(1);
        String chaineY = matcher.group(2);
        String chaineCardinal = matcher.group(3);

        try {
            int x = parseInt(chaineX);
            int y = parseInt(chaineY);

            return new Position(x,y, transform(chaineCardinal));
        } catch (NumberFormatException nfe){
            return null;
        }    }

    @Override
    protected String getRegExp() {
        return "^(\\d*)[ ](\\d*)[ ](["
                + Compass.NORD.getCode()
                + Compass.SUD.getCode()
                + Compass.EST.getCode()
                + Compass.OUEST.getCode()
                + "])?$";
    }

    /**
     *
     * @param chaine
     * @return
     */
    private Compass transform(String chaine){

        for(Compass c: Compass.values()){
            if(c.getCode().equals(chaine)){
                return c;
            }
        }
        throw new IllegalArgumentException("Point Cardinal unjknown");
    }
}
