package com.mower.reader.core.validator;

import com.mower.reader.core.DimensionTerrain;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 08:00
 * To change this template use File | Settings | File Templates.
 */
public class DimensionTerrainValidatorTest {

    private DimensionTerrainValidator validator = new DimensionTerrainValidator();

    @Test
    public void estValide() throws Exception {
        DimensionTerrain dim = new DimensionTerrain(123,4);
        assertThat(validator.valide("123 4")).isNotNull().isEqualTo( dim );
        assertThat(validator.valide("123 4     ")).isNotNull().isEqualTo( dim );
    }

    @Test
    public void badformat() throws Exception {

        assertThat(validator.valide("")).isNull();
        assertThat(validator.valide("                                 ")).isNull();
        assertThat(validator.valide(null)).isNull();
        assertThat(validator.valide("9")).isNull();

    }

    @Test
    public void estValide_presenceEspaceSupplumentaire() throws Exception {
        assertThat(validator.valide("123  465")).isNull();
        assertThat(validator.valide("123 465 ")).isNotNull();
        assertThat(validator.valide(" 123 465 ")).isNotNull();
        assertThat(validator.valide(" 123 465")).isNotNull();

    }

    @Test(expected = IllegalArgumentException.class)
    public void estValide_valeurTropGrande_X() throws Exception {
       validator.valide("123456789012345 0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void estValide_valeurTropGrande_Y() throws Exception {
        validator.valide("0 123456789012345");
    }

    @Test
    public void estValide_alphanumerique() throws Exception {
        assertThat(validator.valide("1A3 465")).isNull();
        assertThat(validator.valide("123-465")).isNull();
        assertThat(validator.valide("123;465")).isNull();
        assertThat(validator.valide("123,465")).isNull();
        assertThat(validator.valide("A A")).isNull();
        assertThat(validator.valide("10.5 3.14")).isNull();

    }

}
