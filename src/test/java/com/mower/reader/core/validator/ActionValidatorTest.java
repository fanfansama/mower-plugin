package com.mower.reader.core.validator;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: fanfan
 * Date: 14/06/14
 * Time: 21:46
 */
public class ActionValidatorTest {

    private ActionValidator validateur = new ActionValidator();

    @Test
    public void validerActionsCorrectes() throws Exception {
        assertThat(validateur.validate("A ")).isNotNull();
        assertThat(validateur.validate("D")).isNotNull();
        assertThat(validateur.validate("G")).isNotNull();
    }

    @Test
    public void validerActionsIncorrectes() throws Exception {

        assertThat(validateur.validate("R")).isNull();
        assertThat(validateur.validate("")).isNull();
        assertThat(validateur.validate(null)).isNull();

    }
}
