package a.i.perceptron;

import java.util.Scanner;

/**
 *
 * @author MD SHAMIM
 */
public class AIPerceptron {
    
    public static void main(String[] args) {
        double x1,x2,w1,w2,y,fw1,fw2,ep,yp1,yp;
        Scanner input = new Scanner(System.in);
        x1 = input.nextDouble();
        x2 = input.nextDouble();
        y = input.nextDouble();
        w1 = input.nextDouble();
        w2 = input.nextDouble();
        
        yp = (x1*w1)+(x2*w2)-0.2;
        
        System.out.printf("Y = %.2f\n",yp);
        
        yp1 = input.nextDouble();
        
        ep = y - yp1;
        
        fw1 = w1 + 0.1 * x1 * ep;
        fw2 = w2 + 0.1 * x2 * ep;
         
        System.out.printf("ep = %.2f\n",ep);
        System.out.printf("fw1 = %.2f\n",fw1);
        System.out.printf("fw2 = %.2f\n",fw2);
    }
    
}
