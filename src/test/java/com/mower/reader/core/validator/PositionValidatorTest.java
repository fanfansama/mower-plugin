package com.mower.reader.core.validator;

import com.mower.geo.core.PointCardinal;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 */
public class PositionValidatorTest {

    private PositionValidator validator = new PositionValidator();

    @Test
    public void valide() throws Exception {
        assertThat(validator.valide("1 23 N")).isNotNull();
        assertThat(validator.valide("1 23 S")).isNotNull();
        assertThat(validator.valide("1 23 E")).isNotNull();
        assertThat(validator.valide("1 23 O")).isNotNull();
        assertThat(validator.valide("1 23 o")).isNull();
        assertThat(validator.valide("123 E")).isNull();
        assertThat(validator.valide("123456789012345 45 E")).isNull();
        assertThat(validator.valide("12 3S")).isNull();
        assertThat(validator.valide("12 34 N").getX()).isEqualTo(12);     // reflexion
        assertThat(validator.valide("12 34 N").getY()).isEqualTo(34);     // reflexion
        assertThat(validator.valide("12 34 N").getPointCardinal()).isEqualTo(PointCardinal.NORD);     // reflexion
    }

}
