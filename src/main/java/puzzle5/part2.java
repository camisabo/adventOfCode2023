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
import static puzzle5.example.completeEspesifications;
import static puzzle5.example.espesificationSeparator;
import static puzzle5.example.pattern;
import static puzzle5.example.printSeed;
import static puzzle5.example.seedEspesificationsInitialitation;

/**
 *
 * @author Omar Nicolas Guerrero
 */
public class part2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = txtReader("./txt/Solucion1p5.txt",true).get(0);
        Matcher pruveLine = separator(input, pattern);
        if (pruveLine.find()) {        }
        
        ArrayList<Range> seedRanges = seedRanges(pruveLine.group("seeds"));
        
//        String seedsString = seedsString(pruveLine.group("seeds"), 0);
//        System.out.println("salio 1");
//        ArrayList<SeedEspesification> seeds = seedEspesificationsInitialitation(seedsString);
//        completeEspesifications(pruveLine, seeds);
//        System.out.println("salio 2");
//
//        long min = seeds.get(0).getSeedLocation();
//        
//        for (int i = 0; i < seeds.size(); i++) {
//            long seedLocation = seeds.get(i).getSeedLocation();
//            if (min>seedLocation) {
//                min = seedLocation;
//            }
//            printSeed(i, seeds);
//        }
//        System.out.println("\n---------\n"+min);
    }
    
//    public static String seedsString (String seedLine, Integer reference){
//        StringBuilder seeds = new StringBuilder();
//        String[] seedStrings = seedLine.split("\\s+");
//
//        long initialValue = Long.parseLong(seedStrings[reference]);
//        seeds.append(initialValue);
//        long range = Long.parseLong(seedStrings[reference+1]);
//        for (long j = 2; j < range; j++) {
//            seeds.append(" ").append(initialValue + j);
//
//            if (j % 1000 == 0) { // Imprime el progreso cada 1000 iteraciones
//                System.out.println("El rango va en: "+ j + " " + (j*100/range)+ "%");
//            }
//        }
//
//        return seeds.toString();
//    }
    
    
    
    public static ArrayList<Range> seedRanges (String seeds) {
        ArrayList<Range> Ranges = new ArrayList<Range>();
        String[] seedStrings = seeds.split("\\s+");
        
        for (int i = 0; i < seedStrings.length; i+=2) {
            Long firstNumber = Long.parseLong(seedStrings[i]);
            Long lastNumber = firstNumber + Long.parseLong(seedStrings[i])-1;
            Range newRange = new Range(firstNumber, lastNumber);
            Ranges.add(newRange); 
        }
        return Ranges;
    }
    
    public static ArrayList<SeedEspesification> createNewSeeds(ArrayList<Range> ranges) {
        ArrayList<SeedEspesification> seeds = new ArrayList<>();
        for (Range range : ranges) {
            SeedEspesification newSeedEspesification = new SeedEspesification(range.getFirstElement());
            seeds.add(newSeedEspesification);
        }
        return seeds;
    }
    
    public static ArrayList<Range> updateRanges (ArrayList<Range> rangeArrayList, String espesification) {
        ArrayList<Range> updateRanges = new ArrayList<>();
        long[][]espesificationMatrix = espesificationSeparator(espesification);
        return updateRanges;
    }

}
