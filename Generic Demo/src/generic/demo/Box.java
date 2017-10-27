/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic.demo;

/**
 *
 * @author MD SHAMIM
 * @param <T>
 */
public class Box<T> {
    private T s;

    public void setS(T s) {
        this.s = s;
    }

    public T getS() {
        return s;
    }
    public <U extends Number> void inspect(U u)
    {
        System.out.println("T Type = " + s.getClass().getName() );
        System.out.println("U Type = " + u.getClass().getName() );
    }
}
