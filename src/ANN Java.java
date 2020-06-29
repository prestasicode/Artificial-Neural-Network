
package ann;

import java.util.Scanner;

class hebb{
    
}
public class Pjst {

    public static void main(String[] args) {
     double yik = 0;
           double nett = 0;
           double[] w1 = {0,1};
           double[] w2 = {0,1};
           double[] b = {0,1};
           double random = Math.random();
           random *=2;
           int randomIndex = (int) random;
     double hasil = b[randomIndex]+((w1[randomIndex])+(w2[randomIndex]));  
        System.out.println("b = "+b[randomIndex]+"w1 = "+w1[randomIndex]+"w2 = "+w2[randomIndex]);
        System.out.println("hasil = "+hasil);
    }
}
