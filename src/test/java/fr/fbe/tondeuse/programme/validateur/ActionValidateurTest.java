package fr.fbe.tondeuse.programme.validateur;

import fr.fbe.tondeuse.programme.validateur.ActionValidateur;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 21:46
 * To change this template use File | Settings | File Templates.
 */
public class ActionValidateurTest {

    private ActionValidateur validateur = new ActionValidateur();

    @Test
    public void valide() throws Exception {
        assertThat(validateur.valide("A")).isNotNull();
        assertThat(validateur.valide("D")).isNotNull();
        assertThat(validateur.valide("G")).isNotNull();
        assertThat(validateur.valide("R")).isNull();
        assertThat(validateur.valide("")).isNull();
        assertThat(validateur.valide(null)).isNull();

    }
}
