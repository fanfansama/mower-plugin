package com.mower.reader.core.validator;

import com.mower.geo.core.PointCardinal;
import com.mower.geo.core.Position;

import static java.lang.Integer.parseInt;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 11:57
 * To change this template use File | Settings | File Templates.
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
                +PointCardinal.NORD.getLibelle()
                +PointCardinal.SUD.getLibelle()
                +PointCardinal.EST.getLibelle()
                +PointCardinal.OUEST.getLibelle()
                + "])?$";
    }

    /**
     *
     * @param chaine
     * @return
     */
    private PointCardinal transform(String chaine){

        for(PointCardinal c: PointCardinal.values()){
            if(c.getLibelle().equals(chaine)){
                return c;
            }
        }
        throw new IllegalArgumentException("Point Cardinal unjknown");
    }
}
