/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle2;

import java.util.ArrayList;
import java.util.Arrays;
import static puzzle1.example.txtReader;
import static puzzle2.example.diccionario;
import static puzzle2.example.operation;
import static puzzle2.example.split;

/**
 *
 * @author Omar Nicolas Guerrero
 */
public class puzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> input = txtReader("./txt/Solucion1P2.txt");
        Integer[] supose = {12, 13, 14}; //red, green, blue
        System.out.println(input);
        System.out.println(Arrays.toString(split(input.get(0))));
        System.out.println(diccionario(split(input.get(0))));
        System.out.println(operation(input, supose));
    }
    
}
