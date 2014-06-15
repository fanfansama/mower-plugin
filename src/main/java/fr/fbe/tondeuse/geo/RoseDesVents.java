package fr.fbe.tondeuse.geo;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 00:04
 * To change this template use File | Settings | File Templates.
 */
public interface RoseDesVents {

    PointCardinal getOrientation();

    PointCardinal allerDroite();

    PointCardinal allerGauche();
}
