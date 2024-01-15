/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle4;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static puzzle1.example.txtReader;

/**
 *
 * @author Omar Nicolas Guerrero
 */
public class example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Card\\s+(?<index>\\d+):\\s+(?<winning>(\\d+\\s*)*?)\\|\\s+(?<numbers>\\d+(\\s*\\d+)*)");
        ArrayList<String> input = txtReader("./txt/Ejemplo1P4.txt");
        //System.out.println(input);
        System.out.println(input.get(2));
        Matcher pruveLine = separator(input.get(2), pattern);
        if (pruveLine.find()) { 
            System.out.println(pruveLine.group("winning"));
        }
        System.out.println(pruveLine.group("numbers"));
        //System.out.println(points(pruveLine));
        System.out.println(poitCounter(input, pattern));
        
    }
    
    public static Matcher separator (String line, Pattern pattern){
        Matcher matcher = pattern.matcher(line);
        return matcher;
    }
    
    public static Integer points (Matcher data){
        Integer pointCouter = 0;
        String[] elfNumbers = data.group("numbers").split("\\s+");
        String[] winningNumbers = data.group("winning").split("\\s+");
        for(String number: elfNumbers){
            for(String posibleWinNumber: winningNumbers){
                pointCouter = (number.equals(posibleWinNumber))? (pointCouter == 0)? 1 : pointCouter*2: pointCouter;
//                if (number.equals(posibleWinNumber)) {
//                    System.out.println("existe una coincidencia entre:" 
//                            + posibleWinNumber+ " y " + number + "\nse añaden " 
//                            + pointCouter + " puntos\n");
//                } else {
//                    System.out.println("No existe coincidencia entre:" 
//                            + posibleWinNumber+ " y " + number + "\n\n");
//                }
            }     
        }
        return pointCouter;
    }
    
    public static boolean initiatorMatcher (Matcher matcher) {
        return matcher.find();
    }
    
    public static Integer poitCounter (ArrayList<String> input, Pattern pattern) {
        Integer pointCouter = 0;
        
        for(String line: input){
            Matcher LineExpression = separator(line, pattern);
            if (initiatorMatcher(LineExpression)) {
//                System.out.println("el indice de la card, evaluada es: " + LineExpression.group("index")
//                    + "\n" + "los putos otorgados son: " + points(LineExpression));
                pointCouter += points(LineExpression);
            }
        }
        return pointCouter;
    } 
    
}
