/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package basictest;

/**
 *
 * @author Sandeep
 */
public class BasucTest1 {
    public static void main1(String...args) {
        Integer[] arr = {
            1, 3, 5, 7, 9, 11, 13, 15,    
            11, 13, 15, 17, 19, 111, 113, 115,
            11, 31, 51, 71, 91, 111, 131, 151,
            31, 33, 35, 37, 39, 311, 313, 315,
            13, 33, 53, 73, 93, 113, 133, 153,
            51, 53, 55, 57, 59, 511, 513, 515,
            15, 35, 55, 75, 95, 115, 135, 155,
            71, 73, 75, 77, 79, 711, 713, 715,
            17, 37, 57, 77, 97, 117, 137, 157,
            91, 93, 95, 97, 99, 911, 913, 915,
            19, 39, 59, 79, 99, 119, 139, 159
        };
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                for(int k = 0; k < arr.length; k++) {
                    int x = arr[i] + arr[j] + arr[i];
                    count = count + 1;
                    if(x == 30) {
                        System.out.println(arr[i] + "+" + arr[j] + "+" + arr[i]);
                    }
                }
            }
        }
        System.out.println(count);
    }
    

    
    
    
    
    public static void main(String...args) {
        Integer[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int count = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j <8; j++) {
                for(int k = 0; k < 8; k++) {
                    int x = arr[i] + arr[j] + arr[i];
                    count = count + 1;
                    if(x == 30) {
                        System.out.println(arr[i] + "+" + arr[j] + "+" + arr[i]);
                    }
                }
            }
        }
        System.out.println(count);
    }
    

    
    
    
    
    
    static int fact(int x) {
        if(x == 1) {
            return 1;
        }
        else {
            return x * fact(x -1);
        }
    }
    
}
