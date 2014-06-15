package fr.fbe.tondeuse.programme.validateur;

import fr.fbe.tondeuse.programme.Action;
import fr.fbe.tondeuse.programme.LigneActionValidateur;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */
public class LigneActionValidateurTest {

    private LigneActionValidateur validateur = new LigneActionValidateur();

    @Test
    public void valide() throws Exception {
        assertThat(validateur.valide("ADG"))
                .isNotNull().isNotEmpty().hasSize(3).containsExactly(Action.AVANCER, Action.DROITE, Action.GAUCHE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void actionNonValide_caracteresNonValide() throws Exception {

        assertThat(validateur.valide("ADxG")).isNull();

    }
    @Test(expected = IllegalArgumentException.class)
    public void actionNonValide_caractereNonValide() throws Exception {

        assertThat(validateur.valide("P")).isNull();

    }
    @Test(expected = IllegalArgumentException.class)
    public void actionNonValide_null() throws Exception {

        assertThat(validateur.valide(null)).isNull();

    }
    @Test(expected = IllegalArgumentException.class)
    public void actionNonValide_vide() throws Exception {

        assertThat(validateur.valide("")).isNull();

    }
}
