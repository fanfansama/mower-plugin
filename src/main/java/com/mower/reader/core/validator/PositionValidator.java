package com.mower.reader.core.validator;

import com.mower.geo.core.Position;
import com.mower.geo.core.enums.Compass;

import static java.lang.Integer.parseInt;

/**
 * User: fanfan
 * Date: 14/06/14
 * Time: 11:57
 */
public class PositionValidator extends Validator<Position> {

    /**
     *
     * @return
     */
    @Override
    protected Position checkValidation() {
        String lX = matcher.group(1);
        String lY = matcher.group(2);
        String lCompass = matcher.group(3);

        try {
            int x = parseInt(lX);
            int y = parseInt(lY);

            return new Position(x,y, transform(lCompass));
        } catch (NumberFormatException nfe){
            return null;
        }    }

    /**
     *
     * @return
     */
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
     * transform "N" to Compass.NORD
     * @param s
     * @return
     */
    private Compass transform(String s){
        for(Compass c: Compass.values()){
            if(c.getCode().equals(s)){
                return c;
            }
        }
        throw new IllegalArgumentException("Point Cardinal unjknown");
    }
}
