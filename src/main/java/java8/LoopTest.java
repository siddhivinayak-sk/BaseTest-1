/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

/**
 *
 * @author sandeep.kumar
 */
public class LoopTest {
    public static void main(String...args) {
        A:
        for(int j = 0; j < 5; j++) {
            for(int k = 0; k < 3; k++) {
                System.out.println(" " + j);
                if(j == 3 && k == 1) break A;
                if(j == 0 || j == 2) break;
                
            }
        }
    }
}
enum X {
    X1(1), X2(2);
    int x;
    X(int x) {
    this.x = x;
    }
}
class T {
    public static void main(String...args) {
        Boolean[] ba[];
        System.out.println(X.X1.x);;
        int y;
    }
}

