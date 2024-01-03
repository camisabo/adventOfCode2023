/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle1;


/**
 *
 * @author Omar Nicolas Guerrero
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<String> input = txtReader("./EjemploP1.txt");
        int solucion = 0;
        for (int i = 0; i < input.size(); i++) {
            solucion += opcionElemet(input.get(i));
            System.out.println(i+1 + ". " + opcionElemet(input.get(i)));
        }
        System.out.println("La solucion es: " + solucion);
    }

    /**
     * Metodo que lee las lineas de un txt
     * 
     * @param path String que indica la ruta al txt
     * @return Un arraylist de strings con cada linea del txt
     */
    public static ArrayList<String> txtReader (String path){
        ArrayList<String> lineas = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String linea;

            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }
    
    
    
    public static char[] split (String code){
        return code.toCharArray();
    }
    
    public static int FirstElemet (String line){
        char[] letters = split(line);
        for (int i = 0; i < letters.length; i++) {
            try {
                int first = Integer.parseInt(letters[i]+"");
                return first;
            } catch (Exception e) {
            }
        }
        return -1;
    }
    
    public static int LastElemet (String line){
        char[] letters = split(line);
        for (int i = 0; i < letters.length; i++) {
            try {
                int last = Integer.parseInt(letters[letters.length-i-1]+"");
                return last;
            } catch (Exception e) {
            }
        }
        return -2;
    }
    
    public static int opcionElemet (String line){
        String last = LastElemet(line) +"";
        String first = FirstElemet(line) +"";
        String number = first+last;
        return Integer.parseInt(number);
    }
    
    
    
}
