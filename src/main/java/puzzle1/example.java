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
        
        ArrayList<String> input = txtReader("./txt/Ejemplo1P1.txt");
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
    
    public static int FirstElemet (String line, boolean haveWords){
        char[] letters = split(line);
        for (int i = 0; i < letters.length; i++) {
            try {
                int first = Integer.parseInt(letters[i]+"");
                return first;
            } catch (Exception e) {
            }
            if (haveWords) {
                if (i + 3 <= line.length() && line.substring(i, i+3).equals("one")) {
                    return 1;
                }
                if (i + 3 <= line.length() && line.substring(i, i+3).equals("two")) {
                    return 2;
                }
                if (i + 5 <= line.length() && line.substring(i, i+5).equals("three")) {
                    return 3;
                }
                if (i + 4 <= line.length() && line.substring(i, i+4).equals("four")) {
                    return 4;
                }
                if (i + 4 <= line.length() && line.substring(i, i+4).equals("five")) {
                    return 5;
                }
                if (i + 3 <= line.length() && line.substring(i, i+3).equals("six")) {
                    return 6;
                }
                if (i + 5 <= line.length() && line.substring(i, i+5).equals("seven")) {
                    return 7;
                }
                if (i + 5 <= line.length() && line.substring(i, i+5).equals("eight")) {
                    return 8;
                }
                if (i + 4 <= line.length() && line.substring(i, i+4).equals("nine")) {
                    return 9;
                }
//                switch(letters[i]){
//                    case 'o': //one
//                        if (letters) {
//                            
//                        }
//                        break;
//                    case 't': //two, three
//                        break;
//                    case 'f': //four, five
//                        break;
//                    case 's': //six, seven
//                        break;
//                    case 'e': //eight
//                        break;
//                    case 'n': //nine
//                        break;
//                    default:
//                        break;
//                    
//                }
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
    
    public static int LastElemet (String line, boolean haveWords){
        char[] letters = split(line);
        for (int i = 0; i < letters.length; i++) {
            if (haveWords) {
                if (line.substring(Math.max(0, line.length() - i), Math.min(line.length(), line.length() - i + 3)).equals("one")) {
                    return 1;
                }
                if (line.substring(Math.max(0, line.length() - i), Math.min(line.length(), line.length() - i + 3)).equals("two")) {
                    return 2;
                }
                if (line.substring(Math.max(0, line.length() - i), Math.min(line.length(), line.length() - i + 5)).equals("three")) {
                    return 3;
                }
                if (line.substring(Math.max(0, line.length() - i), Math.min(line.length(), line.length() - i + 4)).equals("four")) {
                    return 4;
                }
                if (line.substring(Math.max(0, line.length() - i), Math.min(line.length(), line.length() - i + 4)).equals("five")) {
                    return 5;
                }
                if (line.substring(Math.max(0, line.length() - i), Math.min(line.length(), line.length() - i + 3)).equals("six")) {
                    return 6;
                }
                if (line.substring(Math.max(0, line.length() - i), Math.min(line.length(), line.length() - i + 5)).equals("seven")) {
                    return 7;
                }
                if (line.substring(Math.max(0, line.length() - i), Math.min(line.length(), line.length() - i + 5)).equals("eight")) {
                    return 8;
                }
                if (line.substring(Math.max(0, line.length() - i), Math.min(line.length(), line.length() - i + 4)).equals("nine")) {
                    return 9;
                }
            }
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
    
    public static int opcionElemet (String line, boolean haveWords){
        String last = LastElemet(line,haveWords) +"";
        String first = FirstElemet(line,haveWords) +"";
        String number = first+last;
        return Integer.parseInt(number);
    }
    
    
    
}
