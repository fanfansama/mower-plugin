package fr.fbe.tondeuse.programme.validateur;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static fr.fbe.tondeuse.Strings.isNullOrEmpty;

/**
 * Created with IntelliJ IDEA.
 * User: fanfan
 * Date: 14/06/14
 * Time: 11:54

 String input = "1 fish 2 fish red fish blue fish";
 Scanner s = new Scanner(input);
 s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
 MatchResult result = s.match();
 for (int i=1; i<=result.groupCount(); i++)
 System.out.println(result.group(i));
 s.close();


 */
abstract class Validateur<K> {

    protected Pattern pattern;
    protected Matcher matcher;

    protected abstract K checkValidation();

    protected abstract String getExpressionRegulier();

    public K valide(String valeur){
        if(isNullOrEmpty(valeur)){
            return null;
        }
        else if( valeur.matches(getExpressionRegulier()) ){
            pattern = Pattern.compile(getExpressionRegulier());
            matcher = pattern.matcher(valeur);

            if (matcher.matches()) {
                matcher.reset();
                if (matcher.find()) {
                    return checkValidation();
                }
            }

            return null;

        } else {
            return null;
        }

    }

}
