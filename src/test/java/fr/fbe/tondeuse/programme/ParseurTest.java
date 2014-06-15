package fr.fbe.tondeuse.programme;

import fr.fbe.tondeuse.exception.OutOfRangeException;
import fr.fbe.tondeuse.geo.PointCardinal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import static org.powermock.api.support.membermodification.MemberModifier.stub;

import org.powermock.modules.junit4.PowerMockRunner;


/**
 * User: francois b.
 * Date: 15/06/14 08:04
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest( Parseur.class )
public class ParseurTest {

    @Mock
    private BufferedReader bufferedReader;
    @Mock
    InputStreamReader inputStreamReader ;
  //  @Mock
  //  Class<Parseur> mockedClass;
    @Mock
    InputStream inputStream;

    private Parseur parseur;

    private Position expected1 = new Position(1,3, PointCardinal.NORD);
    private Position expected2 = new Position(5,1, PointCardinal.EST);
    private static final String EOF = null;

    @Before
    public void setup() throws Exception {

        stub(Parseur.class.getMethod("getInputStream",String.class)).toReturn(inputStream);
        whenNew(InputStreamReader.class).withArguments(inputStream, "UTF-8").thenReturn(inputStreamReader);
        whenNew(BufferedReader.class).withArguments(inputStreamReader).thenReturn( bufferedReader );
        parseur = spy(new Parseur("test"));

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
    public void casA() throws IOException, OutOfRangeException {
        given(bufferedReader.readLine()).willReturn("5 5","1 2 N","GAGAGAGAA",EOF);
        List result = parseur.traitement();

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
    public void casB() throws IOException, OutOfRangeException {
        given(bufferedReader.readLine()).willReturn("5 5","3 3 E","AADAADADDA",EOF);
        List result = parseur.traitement();

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
    public void casC() throws IOException, OutOfRangeException {
        given(bufferedReader.readLine()).willReturn("5 5","1 2 N","GAGAGAGAA","3 3 E","AADAADADDA",EOF);

        List result = parseur.traitement();
        assertThat(result).isNotNull().isNotEmpty().hasSize(2).containsExactly(expected1, expected2);

    }

    @Test(expected = IllegalArgumentException.class)
    public void casD() throws IOException, OutOfRangeException {
        given(bufferedReader.readLine()).willReturn("","5 5","1 2 N","GAGAGAGAA","3 3 E","AADAADADDA",EOF);

        parseur.traitement();

    }

    @Test(expected = IllegalArgumentException.class)
    public void casE() throws IOException, OutOfRangeException {
        given(bufferedReader.readLine()).willReturn("5 5","1  N","GAGAGAGAA","3 3 E","AADAADADDA",EOF);

        parseur.traitement();

    }

    @Test(expected = IllegalArgumentException.class)
    public void casF() throws IOException, OutOfRangeException {
        given(bufferedReader.readLine()).willReturn("5 5","1 2 N","GAGAG AGAA","3 3 E","AADAADADDA",EOF);

        parseur.traitement();

    }

    @Test(expected = IllegalArgumentException.class)
    public void casG() throws IOException, OutOfRangeException {
        given(bufferedReader.readLine()).willReturn("5 5","1 2 N","GAGAGAGAA","3 3 E",EOF);

        parseur.traitement();

    }

    @Test(expected = IllegalArgumentException.class)
    public void casH() throws IOException, OutOfRangeException {
        given(bufferedReader.readLine()).willReturn("5 5","1 2 N","GAGAGAGAA","",EOF);

        parseur.traitement();

    }
}