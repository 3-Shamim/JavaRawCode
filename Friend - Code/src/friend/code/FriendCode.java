/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friend.code;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author MD SHAMIM
 */
public class FriendCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        DecimalFormat myFormatter = new DecimalFormat(".00");
        double o = 23.333333;
        System.out.println(myFormatter.format(o));
        int p = 0;
        Scanner s = new Scanner(System.in);
        int i, j;
        i = s.nextInt();
        j = s.nextInt();
        
        if(i % 2 == 0)
        {
            p += 1;
        }
        if(j % 2 == 0)
        {
            p += 1;
        }
        
        System.out.println(p);
    }

}
