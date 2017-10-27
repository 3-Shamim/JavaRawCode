/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author MD SHAMIM
 */
public class SortingDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        int data[] = new int[50];

        int data[] = {50, 125, 124, 12, 1, 2, 1, 5, 6, 3, 5, 58, -65};
        System.out.println("Before Sorting");
        System.out.println(Arrays.toString(data));

        System.out.println("after Sorting");
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));

        double Doubledata[] = {50.02, 15.014, -12.25, 12.025, 1.20, 2.30, 1.25, 5.25, -65.54};
        System.out.println("Before Sorting");
        System.out.println(Arrays.toString(Doubledata));

        System.out.println("after Sorting");
        Arrays.sort(Doubledata);
        System.out.println(Arrays.toString(Doubledata));

        String Stringdata[] = {"java", "c", "c++", "python", "ok"};
        System.out.println("Before Sorting");
        System.out.println(Arrays.toString(Stringdata));

        System.out.println("after Sorting");
        Arrays.sort(Stringdata);
        System.out.println(Arrays.toString(Stringdata));

//        for(int i = 0; i < data.length; i++)
//        {
//            System.out.print(data[i] + " ");
//        }
        ArrayList<String> StringList = new ArrayList();
        StringList.add("java");
        StringList.add("c");
        StringList.add("Ruby");
        StringList.add("Python");
        StringList.add("C++");
        StringList.add("javaScript");
        StringList.add("a");

        System.out.println("Before Sort");
        System.out.println(StringList);
        System.out.println("After Sort");
        Collections.sort(StringList);
        System.out.println(StringList);

        ArrayList<Students> studentList = new ArrayList();
        studentList.add(new Students(1, "shamim", 3.90));
        studentList.add(new Students(5, "kamrul", 3.90));
        studentList.add(new Students(3, "faisal", 3.92));
        studentList.add(new Students(4, "sourav", 3.922));

        System.out.println("Before Sort");
        System.out.println(studentList);
        System.out.println("After Sort");
        Collections.sort(studentList, (st1, st2) -> {
//            if(st1.getId() < st2.getId())
//            {
//                return -1;
//            }
//            else
//            {
//                return 1;
//            }

//            if (st1.getCgpa() < st2.getCgpa()) 
//            {
//                return 1;
//            }
//            else if (st1.getCgpa() == st2.getCgpa()) 
//            {
//                if (st1.getId() < st2.getId()) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }else
//            {
//                return -1;
//            }

//            if (Math.abs(st1.getCgpa() - st2.getCgpa()) < 0.01) 
//            {
//                if (st1.getId() < st2.getId()) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//            else if (st1.getCgpa() > st2.getCgpa()) 
//            {
//                return -1;
//            }
//            else
//            {
//                return 1;
//            }
            if(st1.getName().compareTo(st2.getName()) < 0)
            {
                return -1;
            }
            else if(st1.getName().compareTo(st2.getName()) == 0)
            {
                return 0;
            }
            else
            {
                return +1;
            }
        });

        System.out.println(studentList);

    }

}
