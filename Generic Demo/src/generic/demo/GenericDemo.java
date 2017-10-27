/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author MD SHAMIM
 */
public class GenericDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Animal animal = new Animal_Abstrac();
//        animal.eat();
//        animal.travel();

//          List<String> list =  new ArrayList<>();
//          list.add("Shamim");
//          list.add("Molla");
//          String s = list.get(0);
//          String s1 = list.get(1);
//          System.out.println(s);
//          System.out.println(s1);
//          
//          Map<Integer,List<String>> aMap = new HashMap<>();
//        List<Box> list = new ArrayList();
//        Box<Integer> b = new Box();
//        b.setS(10);
//        Box<String> b1 = new Box();
//        b1.setS("Number");
//        list.add(b);
//        list.add(b1);
//        for (Box object : list) {
//            System.out.println(object.getS());
//        }
//        b.inspect(32);

//        Pair<String , String> pair = new OrderPair<>("","");
//        Pair<Integer , String> pair1 = new OrderPair<>(102,"");

        sumOfNumber(Arrays.asList(1,2,3));
        sumOfNumber(Arrays.asList(10.5,2.5,3.3));
        sumOfNumber(Arrays.asList(145l,2564l,35464l));
        
        sumOfNumbers(Arrays.asList(1,2,3));
        sumOfNumbers(Arrays.asList(10.5,2.5,3.3));
        sumOfNumbers(Arrays.asList(145l,2564l,35464l));
    }
    
    private static  void sumOfNumber(List<? extends Number> Number)
    {
        double d = 0.0;
        for (Number object : Number) {
            d += object.doubleValue();
        }
        System.out.println("Sum of List = "  + d);
    }
    private static <T extends Number> void sumOfNumbers(List<T> Number)
    {
        double d = 0.0;
        for (Number object : Number) {
            d += object.doubleValue();
        }
        System.out.println("Sum of List = "  + d);
    }
    
}
