package fr.fbe.tondeuse.programme.validateur;

import fr.fbe.tondeuse.programme.validateur.DimensionTerrainValidateur;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 08:00
 * To change this template use File | Settings | File Templates.
 */
public class DimensionTerrainValidateurTest {

    private DimensionTerrainValidateur validateur = new DimensionTerrainValidateur();

    @Test
    public void estValide() throws Exception {
        assertThat(validateur.valide("123 4")).isNotNull();
        assertThat(validateur.valide("123 4").getX()).isEqualTo(123);     // reflexion
        assertThat(validateur.valide("123 4").getY()).isEqualTo(4);
        assertThat(validateur.valide("")).isNull();
        assertThat(validateur.valide(null)).isNull();
        assertThat(validateur.valide("9")).isNull();
    }

    @Test
    public void estValide_presenceEspaceSupplumentaire() throws Exception {
        assertThat(validateur.valide("123  465")).isNull();
        assertThat(validateur.valide("123 465 ")).isNull();
        assertThat(validateur.valide(" 123 465 ")).isNull();
        assertThat(validateur.valide(" 123 465")).isNull();
        assertThat(validateur.valide("0")).isNull();
        assertThat(validateur.valide("1 ")).isNull();
    }

    @Test
    public void estValide_valeurTropGrande() throws Exception {
        assertThat(validateur.valide("123456789012345 0")).isNull();
        assertThat(validateur.valide("0 123456789012345")).isNull();
    }

    @Test
    public void estValide_alphanumerique() throws Exception {
        assertThat(validateur.valide("1A3 465")).isNull();
        assertThat(validateur.valide("123-465")).isNull();
        assertThat(validateur.valide("123;465")).isNull();
        assertThat(validateur.valide("123,465")).isNull();
        assertThat(validateur.valide("A A")).isNull();
        assertThat(validateur.valide("10.5 3.14")).isNull();

    }

}
