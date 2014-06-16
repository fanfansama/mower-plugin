package com.mower.reader.impl;

import com.mower.exception.OutOfRangeException;
import com.mower.engine.impl.MowerControllerImpl;
import com.mower.geo.core.Position;
import com.mower.reader.Parser;
import com.mower.reader.core.Action;
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

/**
 * User: francois b.
 * Date: 15/06/14 06:48
 */
public class ParserImpl implements Parser {

    private DimensionTerrainValidator terrainValidateur = new DimensionTerrainValidator();
    private PositionValidator positionValidateur = new PositionValidator();
    private ActionLineValidator actionLineValidator = new ActionLineValidator();
    private BufferedReader bufferedReader;

    public ParserImpl(String pathFichier) throws FileNotFoundException, UnsupportedEncodingException {
        InputStream is = getInputStream(pathFichier);
        bufferedReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
    }

    public InputStream getInputStream(String pathFichier) throws FileNotFoundException {
        InputStream is = getClass().getResourceAsStream(pathFichier);
        if(is==null){
            throw new FileNotFoundException(pathFichier);
        }
        return is;
    }

    public List<Position> traitement() throws OutOfRangeException, IOException {
        List<Position> positionList = new ArrayList<>();
        // lire la premiere ligne
        String ligneDimensionTerrain = bufferedReader.readLine();
        DimensionTerrain dimensionTerrain = terrainValidateur.valide( ligneDimensionTerrain );

        // pour chaque paire de ligne suivante
        for(String lignePositionTondeuse; (lignePositionTondeuse = bufferedReader.readLine()) != null; ) {
            Position position = positionValidateur.valide( lignePositionTondeuse );
            MowerControllerImpl mowerControllerImpl = new MowerControllerImpl(position, dimensionTerrain);

            for(Action action : actionLineValidator.valide(bufferedReader.readLine())){
                mowerControllerImpl.actionner(action);
            }
            positionList.add( mowerControllerImpl.getPosition() );
           // System.out.println(mowerControllerImpl.toString());
        }
        return positionList;
    }

}
