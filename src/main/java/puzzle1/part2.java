/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle1;

import java.util.ArrayList;
import static puzzle1.example.opcionElemet;
import static puzzle1.example.txtReader;

/**
 *
 * @author Omar Nicolas Guerrero
 */
public class part2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> input = txtReader("./txt/Solucion1P1.txt");
        int solucion = 0;
        for (int i = 0; i < input.size(); i++) {
            solucion += opcionElemet(input.get(i),true);
            System.out.println(i+1 + ". " + opcionElemet(input.get(i),true));
        }
        System.out.println("La solucion es: " + solucion);
    }
    
}
