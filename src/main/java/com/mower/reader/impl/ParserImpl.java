package com.mower.reader.impl;

import com.mower.engine.MowerController;
import com.mower.exception.OutOfRangeException;
import com.mower.engine.impl.MowerControllerImpl;
import com.mower.geo.core.Position;
import com.mower.reader.Parser;
import com.mower.reader.core.enums.Action;
import com.mower.reader.core.DimensionTerrain;
import com.mower.reader.core.validator.ActionLineValidator;
import com.mower.reader.core.validator.DimensionTerrainValidator;
import com.mower.reader.core.validator.PositionValidator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * User: francois b.
 * Date: 15/06/14 06:48
 */
public class ParserImpl implements Parser {

    private static final String UTF_8 = "UTF-8";

    private static final DimensionTerrainValidator terrainValidateur = new DimensionTerrainValidator();
    private static final PositionValidator positionValidator = new PositionValidator();
    private static final ActionLineValidator actionLineValidator = new ActionLineValidator();

    private BufferedReader bufferedReader;

    /**
     *
     * @param pathFichier
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public ParserImpl(String pathFichier) throws FileNotFoundException, UnsupportedEncodingException {
        InputStream is = getInputStream(pathFichier);
        bufferedReader = new BufferedReader(new InputStreamReader(is, UTF_8));
    }

    /**
     *
     *
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */

    public InputStream getInputStream(String filePath) throws FileNotFoundException {
        InputStream is = getClass().getResourceAsStream(filePath);
        if(is==null){
            throw new FileNotFoundException(filePath);
        }
        return is;
    }

    /**
     *
     * Read the first line and validate it
     * then
     * for each pair of line
     *
     * @return
     * @throws OutOfRangeException
     * @throws IOException
     */
    public List<Position> process() throws OutOfRangeException, IOException {
        // lire la premiere ligne
        String ligneDimensionTerrain = bufferedReader.readLine();
        DimensionTerrain dimensionTerrain = terrainValidateur.validate(ligneDimensionTerrain);


       /*

        Code avant l'utilisation de l'API Stream

       // pour chaque paire de ligne suivante
         List<Position> positionList = new ArrayList<>();
        for(String lignePositionTondeuse; (lignePositionTondeuse = bufferedReader.readLine()) != null; ) {
            Position position = positionValidator.validate(lignePositionTondeuse);
            MowerController controller = new MowerControllerImpl(position, dimensionTerrain);

            for(Action action : actionLineValidator.validate(bufferedReader.readLine())){
                controller.move(action);
            }
            positionList.add(controller.getPosition());
        }  */

        List<Position> positionList = bufferedReader.lines()
            .map(
                new Function<String, Position>() {
                    String previous;
                    @Override
                    public Position apply(String s) {
                        if (previous != null) {
                            Position position = positionValidator.validate(previous);
                            MowerController controller = new MowerControllerImpl(position, dimensionTerrain);
                            for(Action action : actionLineValidator.validate(s)){
                                controller.move(action);
                            }
                            previous = null;
                            return controller.getPosition();
                        } else {
                            previous = s;
                            return null;
                        }
                    }
                }
            )
                .filter(p ->p!=null)
                .collect(Collectors.toList());

        return positionList;
    }

}
