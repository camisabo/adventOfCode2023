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
import static puzzle3.example.itsANumber;
import static puzzle3.example.nearNumbers;
import static puzzle3.example.numberPositionsArrayList;
//import static puzzle3.example.operation;
import static puzzle3.example.sumArrayList;
//import static puzzle3.example.symbolPositionsArrayList;
//import static puzzle3.example.symbolPositionsArrayList;

/**
 *
 * @author Omar Nicolas Guerrero
 */
public class part2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> input = txtReader("./txt/Solucion1P3.txt");
        System.out.println(SubArrayList(input));
        System.out.println(Arrays.toString(SubArrayList(input).get(0)));
        System.out.println(Arrays.toString(numberPositionsArrayList(input).get(1)));
        System.out.println("el resultado es: " + operation(input));
    }
   
    public static ArrayList<Integer[]> symbolPositionsArrayList(ArrayList<String> input) {
        ArrayList<Integer[]> result = new ArrayList<>();
        ArrayList<String[]> subdividido = SubArrayList(input);
        for (int i = 0; i < subdividido.size(); i++) {
            String[] line = subdividido.get(i);
            for (int j = 0; j <line.length; j++) {
                if(!itsANumber(line[j]) && (line[j].equals("*"))){
                    Integer[] Cordenadas = {i,j};
                    result.add(Cordenadas);
                }
            }
        }
        return result;
    }
    
    public static Integer operation(ArrayList<String> input) {
        Integer result = 0;
        ArrayList<Integer[]> symbols = symbolPositionsArrayList(input);
        ArrayList<Integer[]> numbers = numberPositionsArrayList(input);
        ArrayList<Integer[]> listOfCorrectNumbers = new ArrayList<>();
        for (int i = 0; i < symbols.size(); i++) {
            ArrayList<Integer[]> sumNumbers = nearNumbers(symbols.get(i), numbers);
            if (sumNumbers.size()==2) {
                result += sumNumbers.get(0)[3]*sumNumbers.get(1)[3];
            }     
        }
        return result;
    }
}
