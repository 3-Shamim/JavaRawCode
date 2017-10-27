/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcode;

import Test.student;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MD SHAMIM
 */
public class TestCode {

    private final String s = "Shamim";

    public static void main(String[] args) {

        String pattern = "dd-MM-yyyy  hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);

        ObservableList<student> list;
        list = FXCollections.observableArrayList();
        list.add(new student(1, "SHAMIM", 3.25));
        list.add(new student(2, "kamrul", 3.52));
        list.add(new student(3, "faisal", 3.70));
        list.add(new student(3, "faisal", 3.70));
        list.add(new student(1, "SHAMIM", 3.25));
        list.add(new student(2, "kamrul", 3.52));
        list.add(new student(1, "SHAMIM", 3.25));

        for (student s : list) {
            if (s.getId() == 1) {
                System.out.println(s.getId() + " " + s.getName() + " " + s.getCgpa());
            }

        }
    }

    public String getS() {
        return s;
    }

}
