package com.mower.reader.core.validator;

import com.mower.geo.core.Position;
import com.mower.geo.core.enums.Compass;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: fanfan
 * Date: 14/06/14
 * Time: 12:14
 */
public class PositionValidatorTest {

    private PositionValidator validator = new PositionValidator();

    @Test
    public void valide() throws Exception {
        assertThat(validator.validate("1 23 N")).isNotNull();
        assertThat(validator.validate("1 23 S")).isNotNull();
        assertThat(validator.validate("1 23 E")).isNotNull();
        assertThat(validator.validate("1 23 O")).isNotNull();
        assertThat(validator.validate("1 23 O    ")).isNotNull();

        Position expected = new Position(12,34, Compass.NORD);
        assertThat(validator.validate("12 34 N")).isEqualTo(expected);
    }

    @Test
    public void nestPasvalide() throws Exception {

        assertThat(validator.validate("1 23 o")).isNull();
        assertThat(validator.validate("123 E")).isNull();
        assertThat(validator.validate("12  3 E")).isNull();
        assertThat(validator.validate("123456789012345 45 E")).isNull();
        assertThat(validator.validate("12 3S")).isNull();
    }

}
