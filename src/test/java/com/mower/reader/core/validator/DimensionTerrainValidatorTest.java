package com.mower.reader.core.validator;

import com.mower.reader.core.DimensionTerrain;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: fanfan
 * Date: 14/06/14
 * Time: 08:00
 */
public class DimensionTerrainValidatorTest {

    private DimensionTerrainValidator validator = new DimensionTerrainValidator();

    @Test
    public void estValide() throws Exception {
        DimensionTerrain expected = new DimensionTerrain(123,4);
        assertThat(validator.validate("123 4")).isNotNull().isEqualTo( expected );
        assertThat(validator.validate("123 4     ")).isNotNull().isEqualTo( expected );
    }

    @Test
    public void badformat() throws Exception {

        assertThat(validator.validate("")).isNull();
        assertThat(validator.validate("                                 ")).isNull();
        assertThat(validator.validate(null)).isNull();
        assertThat(validator.validate("9")).isNull();

    }

    @Test
    public void estValide_presenceEspaceSupplumentaire() throws Exception {

        assertThat(validator.validate("123  465")).isNull();

        DimensionTerrain expected = new DimensionTerrain(13,456);
        assertThat(validator.validate("123 465 ")).isNotNull().isEqualTo(expected);
        assertThat(validator.validate(" 123 465 ")).isNotNull().isEqualTo(expected);
        assertThat(validator.validate(" 123 465")).isNotNull().isEqualTo(expected);

    }

    @Test(expected = IllegalArgumentException.class)
    public void estValide_valeurTropGrande_X() throws Exception {
       validator.validate("123456789012345 0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void estValide_valeurTropGrande_Y() throws Exception {
        validator.validate("0 123456789012345");
    }

    @Test
    public void estValide_alphanumerique() throws Exception {
        assertThat(validator.validate("1A3 465")).isNull();
        assertThat(validator.validate("123-465")).isNull();
        assertThat(validator.validate("123;465")).isNull();
        assertThat(validator.validate("123,465")).isNull();
        assertThat(validator.validate("A A")).isNull();
        assertThat(validator.validate("10.5 3.14")).isNull();

    }

}
