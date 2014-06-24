package com.mower.engine;

import com.mower.reader.Parser;
import com.mower.geo.core.Position;

import com.mower.reader.impl.ParserImpl;
import org.junit.Test;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * User: francois b.
 * Date: 15/06/14 10:49
 * Integration Test
 * <p>Read and process all .txt format files into src/it/resources/</p>
 */
public class AllFilesIT {

    private static final String TXT = ".txt";

    @Test
    public void readAllFiles() throws IOException {

        Files.list(new File("./src/it/resources").toPath())
                .filter(p -> p.getFileName().toString().endsWith(TXT))
                .forEach( filePath -> {
                            try {
                                System.out.println("********** " + filePath.getFileName().toString() + " **********");
                                Parser parser = new ParserImpl( "/" + filePath.getFileName().toString() );
                                List<Position> result = parser.process();
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
