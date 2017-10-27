package sorting.demo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MD SHAMIM
 */
public class Students {
    private int id;
    private String name;
    private double cgpa;

    public Students(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        return "Students{" + "id = " + id + ", name = " + name + ", cgpa = " + cgpa + '}';
    }
    
    
    
}
