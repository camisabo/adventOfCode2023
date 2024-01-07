/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle3;

import java.util.ArrayList;
import java.util.Arrays;
import static puzzle1.example.txtReader;
import static puzzle3.example.SubArrayList;
import static puzzle3.example.numberPositionsArrayList;
import static puzzle3.example.operation;
import static puzzle3.example.symbolPositionsArrayList;

/**
 *
 * @author Omar Nicolas Guerrero
 */
public class puzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         ArrayList<String> input = txtReader("./txt/Solucion1P3.txt");
        System.out.println(SubArrayList(input));
        System.out.println(Arrays.toString(SubArrayList(input).get(0)));
        System.out.println(Arrays.toString(symbolPositionsArrayList(input).get(0)));
        System.out.println(Arrays.toString(numberPositionsArrayList(input).get(1)));
        System.out.println("el resultado es: " + operation(input));
    }
    
}
