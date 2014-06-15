package fr.fbe.tondeuse.programme.validateur;

import fr.fbe.tondeuse.geo.PointCardinal;
import fr.fbe.tondeuse.programme.validateur.PositionValidateur;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 */
public class PositionValidateurTest {

    private PositionValidateur validateur = new PositionValidateur();

    @Test
    public void valide() throws Exception {
        assertThat(validateur.valide("1 23 N")).isNotNull();
        assertThat(validateur.valide("1 23 S")).isNotNull();
        assertThat(validateur.valide("1 23 E")).isNotNull();
        assertThat(validateur.valide("1 23 O")).isNotNull();
        assertThat(validateur.valide("1 23 o")).isNull();
        assertThat(validateur.valide("123 E")).isNull();
        assertThat(validateur.valide("123456789012345 45 E")).isNull();
        assertThat(validateur.valide("12 3S")).isNull();
        assertThat(validateur.valide("12 34 N").getX()).isEqualTo(12);     // reflexion
        assertThat(validateur.valide("12 34 N").getY()).isEqualTo(34);     // reflexion
        assertThat(validateur.valide("12 34 N").getPointCardinal()).isEqualTo(PointCardinal.NORD);     // reflexion
    }

}
