/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
        ArrayList<String> input = txtReader("./txt/Ejemplo2P1.txt");
        Integer[] supose = {12, 13, 14}; //red, green, blue
        System.out.println(input);
        System.out.println(Arrays.toString(split(input.get(0))));
        System.out.println(diccionario(split(input.get(0))));
        System.out.println(operation(input, supose));
    }
    
    public static String[] split (String line){
        String[] result = line.split(" ");
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i].replace(",", "");
            result[i] = result[i].replace(" ", "");
            result[i] = result[i].replace(":", "");
            result[i] = result[i].replace(";", "");
        }
        
        return result;
    }
    
    public static Map<String, Integer> diccionario (String[] line) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("id", search("id", line));
        map.put("blue", search("b", line));
        map.put("red", search("r", line));
        map.put("green", search("g", line));

        return map;
    }

    private static Integer search(String id, String[] line) {
        Integer resuInteger = 0;
        String word = "";
        switch (id){
            
            case "id":
                word = "Game";
                break;
            case "b":
                word = "blue";
                break;
            case "r":
                word = "red";
                break;
            case "g":
                word = "green";
                break;
        }
        if (id.equals("id")) {
            return Integer.parseUnsignedInt(line[1]);
        }
        else{
            for (int i = 0; i < line.length; i++) {
                if (line[i].equals(word) && Integer.parseInt(line[i-1])>resuInteger) {
                    resuInteger =Integer.parseInt(line[i-1]);
                }
            }
            return resuInteger;
        }
    }
    
    public static Integer operation (ArrayList<String> input, Integer[] elfBagContained){
        Integer resuInteger = 0;
        for (int i = 0; i < input.size(); i++) {
            Map<String, Integer> mapa = diccionario(split(input.get(i)));
            if (elfBagContained[0] >= mapa.get("red") 
                    && elfBagContained[1] >= mapa.get("green") 
                    && elfBagContained[2] >= mapa.get("blue")) {
                resuInteger +=mapa.get("id");
            }
        }
        return resuInteger;
    }

    
    //
}
