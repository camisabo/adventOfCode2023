/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle3;

/**
 *
 * @author Omar Nicolas Guerrero
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static puzzle1.example.txtReader;

public class example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> input = txtReader("./txt/Ejemplo1P3.txt");
        System.out.println(SubArrayList(input));
        System.out.println(Arrays.toString(SubArrayList(input).get(0)));
        System.out.println(Arrays.toString(symbolPositionsArrayList(input).get(0)));
        System.out.println(Arrays.toString(numberPositionsArrayList(input).get(1)));
        System.out.println("el resultado es: " + operation(input));
    }    
    
    public static ArrayList<String[]> SubArrayList(ArrayList<String> input) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        for (int i = 0; i < input.size(); i++) {
            String[] line = split(input.get(i),false);
            result.add(line);
        }
        return result;
    }
    
    public static String[] split(String line, boolean needNumbers) {
        if (needNumbers) {
            return line.split(".");
        } else {
            return line.split("");
        }
    }
    
    
    public static boolean itsANumber(String character){
        try {
            Integer.parseInt(character);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public static ArrayList<Integer[]> symbolPositionsArrayList(ArrayList<String> input) {
        ArrayList<Integer[]> result = new ArrayList<>();
        ArrayList<String[]> subdividido = SubArrayList(input);
        for (int i = 0; i < subdividido.size(); i++) {
            String[] line = subdividido.get(i);
            for (int j = 0; j <line.length; j++) {
                if(!itsANumber(line[j]) && !(line[j].equals("."))){
                    Integer[] Cordenadas = {i,j};
                    result.add(Cordenadas);
                }
            }
        }
        return result;
    }
    
    public static ArrayList<Integer[]> numberPositionsArrayList(ArrayList<String> input) {
        ArrayList<Integer[]> result = new ArrayList<>();
        ArrayList<String[]> subdividido = SubArrayList(input);
        for (int i = 0; i < subdividido.size(); i++) {
            String[] line = subdividido.get(i);
            for (int j = 0; j <line.length; j++) {
                if(itsANumber(line[j])){
                    Integer ref = j;
                    String number = "";
                    do {                        
                        if (itsANumber(line[ref])) {
                            number += line[ref];
                            ref = Integer.min(ref+1, line.length);
                        }if (ref == line.length) {
                            break;
                        } 
                    } while (itsANumber(line[ref]));
                    
                    Integer[] Cordenadas = {i,j,j+number.length()-1, Integer.parseInt(number)}; //linea, col inicial, col final, numero
                    j=ref;
                    result.add(Cordenadas);
                }
            }
        }
        return result;
    }
    
    public static boolean isInInterval(int A, int C, int D) { //A= valor, C = limite inferior, D = limite superior
        if (A >= C && A <= D) {
            return true;
        } else {
            return false;
        }
    }
    
    public static ArrayList<Integer[]> nearNumbers(Integer[] symbol, ArrayList<Integer[]> numbers) {
        ArrayList<Integer[]> result = new ArrayList<Integer[]>();
        for (int i = 0; i < numbers.size(); i++) {
            if (isInInterval(numbers.get(i)[0], symbol[0]-1, symbol[0]+1)) {
                if (isInInterval(symbol[1]-1, numbers.get(i)[1], numbers.get(i)[2]) || isInInterval(symbol[1]+1, numbers.get(i)[1], numbers.get(i)[2]) || isInInterval(symbol[1], numbers.get(i)[1], numbers.get(i)[2])) {
                    result.add(numbers.get(i));
                }
            }
        }
        return result;
    }
    
    public static ArrayList<Integer[]> sumArrayList(ArrayList<Integer[]> list1,ArrayList<Integer[]> list2) {
        list1.addAll(list2);
        Set<Integer[]> set = new HashSet<>(list1);
        list1.clear();
        list1.addAll(set);
            return list1;
    }
    public static Integer operation(ArrayList<String> input) {
        Integer result = 0;
        ArrayList<Integer[]> symbols = symbolPositionsArrayList(input);
        ArrayList<Integer[]> numbers = numberPositionsArrayList(input);
        ArrayList<Integer[]> listOfCorrectNumbers = new ArrayList<>();
        for (int i = 0; i < symbols.size(); i++) {
            ArrayList<Integer[]> sumNumbers = nearNumbers(symbols.get(i), numbers);
            listOfCorrectNumbers = sumArrayList(listOfCorrectNumbers, sumNumbers);
        }
        for (int i = 0; i < listOfCorrectNumbers.size(); i++) {
            result += listOfCorrectNumbers.get(i)[3];
        }
        return result;
    }
}
