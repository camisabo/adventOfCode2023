/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle5;

import java.util.ArrayList;
import java.util.regex.Matcher;
import static puzzle1.example.txtReader;
import static puzzle4.example.separator;
import static puzzle5.example. printSeed;
import static puzzle5.example.completeEspesifications;
import static puzzle5.example.pattern;
import static puzzle5.example.seedEspesificationsInitialitation;

/**
 *
 * @author Omar Nicolas Guerrero
 */
public class puzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = txtReader("./txt/Solucion1p5.txt",true).get(0);
        Matcher pruveLine = separator(input, pattern);
        if (pruveLine.find()) {        }
        
        ArrayList<SeedEspesification> seeds = seedEspesificationsInitialitation(pruveLine.group("seeds"));
        completeEspesifications(pruveLine, seeds);
        
        long min = seeds.get(0).getSeedLocation();
        
        for (int i = 0; i < seeds.size(); i++) {
            long seedLocation = seeds.get(i).getSeedLocation();
            if (min>seedLocation) {
                min = seedLocation;
            }
            printSeed(i, seeds);
        }
        System.out.println("\n---------\n"+min);
    }
    
}
