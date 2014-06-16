package fr.fbe.tondeuse.moteur;


import fr.fbe.tondeuse.programme.Parseur;
import fr.fbe.tondeuse.programme.Position;

import org.junit.Test;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * User: francois b.
 * Date: 15/06/14 10:49
 */
public class ProcesserFichiersIT {


    @Test
    public void lireToutLesFichiers() throws IOException {

        Files.list(new File("./src/test/resources").toPath())
                .filter(p
                        ->
                        p.getFileName().toString().endsWith(".txt"))
                .forEach(
                        filePath -> {
                            try {
                                System.out.println("********** " + filePath.getFileName().toString() + " **********");
                                Parseur parseur = new Parseur( "/" + filePath.getFileName().toString() );
                                List<Position> result = parseur.traitement();
                                for (Position position : result) {
                                    System.out.println(position.toString());
                                }

                            } catch (Exception ex) {
                                System.out.println("++++[" + filePath.getFileName().toString() + "] ERREUR DETECTEE (" + ex.getClass().getSimpleName() + ":" + ex.getMessage() + ")++++");
                            }
                        }

                );

    }
}
