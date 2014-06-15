package fr.fbe.tondeuse.moteur;

import fr.fbe.tondeuse.exception.OutOfRangeException;
import fr.fbe.tondeuse.geo.PointCardinal;
import fr.fbe.tondeuse.programme.Parseur;
import fr.fbe.tondeuse.programme.Position;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: francois b.
 * Date: 15/06/14 10:49
 */
public class ProcesserFichiersIT {

    private Position expectedBasic = new Position(1,5, PointCardinal.NORD);
    private Position expectedBasic1 = new Position(1,3, PointCardinal.NORD);
    private Position expectedBasic2 = new Position(5,1, PointCardinal.EST);

    @Test
    public void fichierDeRefence() throws IOException, OutOfRangeException {
        Parseur parseur = new Parseur("/basic.txt");
        List result = parseur.traitement();
        assertThat(result).isNotNull().isNotEmpty().hasSize(3)
                .containsExactly(expectedBasic, expectedBasic1, expectedBasic2);
    }

    @Test
    public void lireToutLesFichiersTxt() throws URISyntaxException, IOException, OutOfRangeException {

       URL url = getClass().getClassLoader().getResource("basic.txt");
        Collection<File> filesb =
                FileUtils.listFiles(FileUtils.getFile(url.getFile()).getParentFile(), new String[] {"txt"},false);

        for (File f :filesb){
              System.out.println("************" +f.getName() +"*********************");
              Parseur parseur = new Parseur("/basic.txt");
              List<Position> result = parseur.traitement();
            for(Position position : result ){
               System.out.println(position.toString());
            }

        }

/*
            Files.walk(Paths.get(url.toURI()))
              //  .filter(x -> x.endsWith(".txt"))
                .forEach(filePath -> {

                    System.out.println(filePath);
                    for (String f : filePath.toFile().getParentFile().list()) {
                        System.out.println(f);
                    }
                });

         } */

    }

}
