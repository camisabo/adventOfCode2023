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
import java.util.ArrayList;
import static puzzle1.example.opcionElemet;
import static puzzle1.example.txtReader;

public class puzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> input = txtReader("./SolucionP1.txt");
        int solucion = 0;
        for (int i = 0; i < input.size(); i++) {
            solucion += opcionElemet(input.get(i));
            System.out.println(i+1 + ". " + opcionElemet(input.get(i)));
        }
        System.out.println("La solucion es: " + solucion);
    }
    
}
