package com.mower.reader.impl;

import com.mower.exception.OutOfRangeException;
import com.mower.geo.core.Position;
import com.mower.geo.core.enums.Compass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import static org.powermock.api.support.membermodification.MemberModifier.stub;

import org.powermock.modules.junit4.PowerMockRunner;


/**
 * User: francois b.
 * Date: 15/06/14 08:04
 * Test Class of {@link ParserImpl}
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest( ParserImpl.class )
public class ParserImplTest {

    @Mock
    private BufferedReader bufferedReader;
    @Mock
    private InputStreamReader inputStreamReader ;

    @Mock
    private InputStream inputStream;

    private ParserImpl parseur;

    private Position expected1 = new Position(1,3, Compass.NORD);
    private Position expected2 = new Position(5,1, Compass.EST);
    private static final String EOF = null;

    @Before
    public void setup() throws Exception {

        stub(ParserImpl.class.getMethod("getInputStream",String.class)).toReturn(inputStream);
        whenNew(InputStreamReader.class).withArguments(inputStream, "UTF-8").thenReturn(inputStreamReader);
        whenNew(BufferedReader.class).withArguments(inputStreamReader).thenReturn( bufferedReader );
        parseur = spy(new ParserImpl("test"));

    }

    /**
     *
     * 5 5
     * 1 2 N
     * GAGAGAGAA -> 1 3 N
     *
     * @throws IOException
     * @throws OutOfRangeException
     */
    @Test
    public void cas_normal() throws IOException, OutOfRangeException {
        given(bufferedReader.readLine()).willReturn("5 5","1 2 N","GAGAGAGAA",EOF);
        List result = parseur.process();

        assertThat(result).isNotNull().isNotEmpty().hasSize(1).containsExactly(expected1);
    }

    /**
     *
     * 5 5
     * 3 3 E
     * AADAADADDA -> 5 1 E
     *
     * @throws IOException
     * @throws OutOfRangeException
     */
    @Test
    public void second_cas_normal() throws IOException, OutOfRangeException {
        given(bufferedReader.readLine()).willReturn("5 5","3 3 E","AADAADADDA",EOF);
        List result = parseur.process();

        assertThat(result).isNotNull().isNotEmpty().hasSize(1).containsExactly(expected2);
    }

    /**
     *
     * 5 5
     * 1 2 N
     * GAGAGAGAA -> 1 3 N
     * 3 3 E
     * AADAADADDA -> 5 1 E
     *
     * @throws IOException
     * @throws OutOfRangeException
     */
    @Test
    public void deux_cas_normaux() throws IOException, OutOfRangeException {
        given(bufferedReader.readLine()).willReturn("5 5","1 2 N","GAGAGAGAA","3 3 E","AADAADADDA",EOF);

        List result = parseur.process();
        assertThat(result).isNotNull().isNotEmpty().hasSize(2).containsExactly(expected1, expected2);

    }

    @Test(expected = IllegalArgumentException.class)
    public void ligneTerrainIncomplete() throws IOException, OutOfRangeException {
        given(bufferedReader.readLine()).willReturn("","5 5","1 2 N","GAGAGAGAA","3 3 E","AADAADADDA",EOF);

        parseur.process();

    }

    @Test(expected = IllegalArgumentException.class)
    public void espaceSupplementaire_coordonnees() throws IOException, OutOfRangeException {
        given(bufferedReader.readLine()).willReturn("5 5","1  N","GAGAGAGAA","3 3 E","AADAADADDA",EOF);

        parseur.process();

    }

    @Test(expected = IllegalArgumentException.class)
    public void espaceSupplementaire_actions() throws IOException, OutOfRangeException {
        given(bufferedReader.readLine()).willReturn("5 5","1 2 N","GAGAG AGAA","3 3 E","AADAADADDA",EOF);

        parseur.process();

    }

    @Test(expected = IllegalArgumentException.class)
    public void manque_ligne_actions() throws IOException, OutOfRangeException {
        given(bufferedReader.readLine()).willReturn("5 5","1 2 N","GAGAGAGAA","3 3 E",EOF);

        parseur.process();

    }

    @Test(expected = IllegalArgumentException.class)
    public void manque_ligne_coordonnees() throws IOException, OutOfRangeException {
        given(bufferedReader.readLine()).willReturn("5 5","1 2 N","GAGAGAGAA","",EOF);
        parseur.process();
    }
}
