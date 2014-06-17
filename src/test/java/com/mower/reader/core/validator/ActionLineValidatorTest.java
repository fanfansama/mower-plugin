package com.mower.reader.core.validator;

import com.mower.reader.core.enums.Action;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */
public class ActionLineValidatorTest {

    private ActionLineValidator validator = new ActionLineValidator();

    @Test
    public void valide() throws Exception {
        assertThat(validator.validate("ADG"))
                .isNotNull().isNotEmpty().hasSize(3).containsExactly(Action.AVANCER, Action.DROITE, Action.GAUCHE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void actionNonValide_caracteresNonValide() throws Exception {

        assertThat(validator.validate("ADxG")).isNull();

    }
    @Test(expected = IllegalArgumentException.class)
    public void actionNonValide_caractereNonValide() throws Exception {

        assertThat(validator.validate("P")).isNull();

    }
    @Test(expected = IllegalArgumentException.class)
    public void actionNonValide_null() throws Exception {

        assertThat(validator.validate(null)).isNull();

    }
    @Test(expected = IllegalArgumentException.class)
    public void actionNonValide_vide() throws Exception {

        assertThat(validator.validate("")).isNull();

    }
}
