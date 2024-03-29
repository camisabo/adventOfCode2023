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
import static puzzle4.example.points;
import static puzzle4.example.poitCounter;
import static puzzle4.example.separator;

/**
 *
 * @author Omar Nicolas Guerrero
 */
public class puzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Card\\s+(?<index>\\d+):\\s+(?<winning>(\\d+\\s*)*?)\\|\\s+(?<numbers>\\d+(\\s*\\d+)*)");
        ArrayList<String> input = txtReader("./txt/Solucion1P4.txt");
        
        //System.out.println(input);
        Integer index = 1;
        
        System.out.println(input.get(index));
        Matcher pruveLine = separator(input.get(index), pattern);
        
        if (pruveLine.find()) { 
            System.out.println(pruveLine.group("winning"));
        }
        System.out.println(pruveLine.group("numbers"));
        System.out.println(points(pruveLine));
        System.out.println(poitCounter(input, pattern));
    }
    
}
