/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static puzzle1.example.txtReader;
import static puzzle4.example.separator;

/**
 *
 * @author Omar Nicolas Guerrero
 */
public class example {
    
    static Pattern pattern = Pattern.compile("seeds:\\s+(?<seeds>\\d+(\\s+\\d+)+)\\n{2}"
                + "seed-to-soil map:\\n(?<soil>(\\d+(\\s+\\d+){2}\\n)+)\\n"
                + "soil-to-fertilizer map:\\n(?<fertilizer>(\\d+(\\s+\\d+){2}\\n)+)\\n"
                + "fertilizer-to-water map:\\n(?<water>(\\d+(\\s+\\d+){2}\\n)+)\\n"
                + "water-to-light map:\\n(?<light>(\\d+(\\s+\\d+){2}\\n)+)\\n"
                + "light-to-temperature map:\\n(?<temperature>(\\d+(\\s+\\d+){2}\\n)+)\\n"
                + "temperature-to-humidity map:\\n(?<humidity>(\\d+(\\s+\\d+){2}\\n)+)\\n"
                + "humidity-to-location map:\\n(?<location>(\\d+(\\s+\\d+){2}\\n)+)");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String input = txtReader("./txt/Ejemplo1P5.txt",true).get(0);
        //System.out.println(input);
        System.out.println(input);
        Matcher pruveLine = separator(input, pattern);
        if (pruveLine.find()) {
            System.out.println(pruveLine.group("seeds"));
            System.out.println(pruveLine.group("soil"));
        }
        ArrayList<SeedEspesification> seeds = seedEspesificationsInitialitation(pruveLine.group("seeds"));
        addEspesification(seeds.get(0), pruveLine.group("soil"), "  ");
        
        
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
    public static void printSeed (int reference, ArrayList<SeedEspesification> seeds){
        System.out.println("----------");
        System.out.println("Semilla con referencia: " + reference);
        System.out.println("----------");
        System.out.println(seeds.get(reference).getSeedName());
        System.out.println(seeds.get(reference).getSeedSoil());
        System.out.println(seeds.get(reference).getSeedFertilizer());
        System.out.println(seeds.get(reference).getSeedWater());
        System.out.println(seeds.get(reference).getSeedLight());
        System.out.println(seeds.get(reference).getSeedTemperature());
        System.out.println(seeds.get(reference).getSeedHumidity());
        System.out.println(seeds.get(reference).getSeedLocation());
    }
    
    public static ArrayList<SeedEspesification> seedEspesificationsInitialitation(String seeds) {
        ArrayList<SeedEspesification> seedArrayList = new ArrayList<>();
        String[] seedStrings = seeds.split("\\s+");
        
        for (String seedString : seedStrings) {
            Long num = Long.parseLong(seedString);
            SeedEspesification seed = new SeedEspesification(num);
            seedArrayList.add(seed);
        }
        
        return seedArrayList;
    }
    
    public static long [][] espesificationSeparator (String espesification){
        String[] lines = espesification.split("\\n");
        long[][] espesificationMatix = new long[lines.length][];
        int reference = 0;
        for (String line : lines) {
            String[] stringsNumbers = line.split("\\s+");
            Long[] numbers = Arrays.stream(stringsNumbers)
                   .map(Long::parseLong)
                   .toArray(Long[]::new);

            long[] numbersLong = Arrays.stream(numbers)
                   .mapToLong(Long::longValue)
                   .toArray();

            espesificationMatix[reference] = numbersLong;
            reference++;
        }

        return espesificationMatix;
    }

    
    public static void addEspesification(SeedEspesification seed, String espesification, String nameDestination) {
        long[][] espesificationMatrix = espesificationSeparator(espesification);
        boolean itsAlreadyChanged = false;
        for (long[] line : espesificationMatrix){
            long destination = line[0];
            long source = line[1];
            long range = line[2];
            String referenceString = nameDestination.substring(0, 2);
            if(seed.itsInRange(source, range, referenceString)){
                long destinationValue;
                switch(nameDestination){
                    case "fertilizer":
                        destinationValue = destination + seed.getSeedSoil() - source;
                        seed.setSeedFertilizer(destinationValue);
                        break;
                    case "water":
                        destinationValue = destination + seed.getSeedFertilizer() - source;
                        seed.setSeedWater(destinationValue);
                        break;
                    case "light":
                        destinationValue = destination + seed.getSeedWater() - source;
                        seed.setSeedLight(destinationValue);
                        break;
                    case "temperature":
                        destinationValue = destination + seed.getSeedLight() - source;
                        seed.setSeedTemperature(destinationValue);
                        break;
                    case "humidity":
                        destinationValue = destination + seed.getSeedTemperature() - source;
                        seed.setSeedHumidity(destinationValue);
                        break;
                    case "location":
                        destinationValue = destination + seed.getSeedHumidity() - source;
                        seed.setSeedLocation(destinationValue);
                        break;
                    default:
                        destinationValue = destination + seed.getSeedName() - source;
                        seed.setSeedSoil(destinationValue);
                        break;
                }
                itsAlreadyChanged = true;
                break;
            }  
        }
        if (!itsAlreadyChanged) {
            switch(nameDestination){
                case "fertilizer":
                    seed.setSeedFertilizer(seed.getSeedSoil());
                    break;
                case "water":
                    seed.setSeedWater(seed.getSeedFertilizer());
                    break;
                case "light":
                    seed.setSeedLight(seed.getSeedWater());
                    break;
                case "temperature":
                    seed.setSeedTemperature(seed.getSeedLight());
                    break;
                case "humidity":
                    seed.setSeedHumidity(seed.getSeedTemperature());
                    break;
                case "location":
                    seed.setSeedLocation(seed.getSeedHumidity());
                    break;
                default:
                    seed.setSeedSoil(seed.getSeedName());
                    break;
            }
        }
    }
    
    
    public static void completeEspesification(SeedEspesification seed, Matcher input) {
        addEspesification(seed, input.group("soil"), "  ");
        addEspesification(seed, input.group("fertilizer"), "fertilizer");
        addEspesification(seed, input.group("water"), "water");
        addEspesification(seed, input.group("light"), "light");
        addEspesification(seed, input.group("temperature"), "temperature");
        addEspesification(seed, input.group("humidity"), "humidity");
        addEspesification(seed, input.group("location"), "location");
    }
    
    public static void completeEspesifications(Matcher input, ArrayList<SeedEspesification> seeds) {
        for (SeedEspesification seed : seeds) {
            completeEspesification(seed, input);
        }
    }
}
