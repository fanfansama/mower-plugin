package fr.fbe.tondeuse.programme;

import fr.fbe.tondeuse.exception.OutOfRangeException;
import fr.fbe.tondeuse.moteur.Tondeuse;
import fr.fbe.tondeuse.programme.validateur.DimensionTerrainValidateur;
import fr.fbe.tondeuse.programme.validateur.PositionValidateur;

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
public class Parseur {

    private DimensionTerrainValidateur terrainValidateur = new DimensionTerrainValidateur();
    private PositionValidateur positionValidateur = new PositionValidateur();
    private LigneActionValidateur ligneActionValidateur = new LigneActionValidateur();
    private BufferedReader bufferedReader;

    public Parseur(String pathFichier) throws FileNotFoundException, UnsupportedEncodingException {
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
            Tondeuse tondeuse = new Tondeuse(position, dimensionTerrain);

            for(Action action : ligneActionValidateur.valide(bufferedReader.readLine())){
                tondeuse.actionner(action);
            }
            positionList.add( tondeuse.getPosition() );
           // System.out.println(tondeuse.toString());
        }
        return positionList;
    }

}
