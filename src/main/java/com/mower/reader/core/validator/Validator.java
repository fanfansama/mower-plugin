package com.mower.reader.core.validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.mower.Strings.isNullOrEmpty;

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
abstract class Validator<K> {

    protected Pattern pattern;
    protected Matcher matcher;

    protected abstract K checkValidation();

    protected abstract String getRegExp();

    public K valide(String valeur){
        if(valeur == null){
            return null;
        } else {
            valeur = valeur.trim();
            if( valeur.matches(getRegExp()) ){
                pattern = Pattern.compile(getRegExp());
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

}
