/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.Random;

/**
 *
 * @author sandeep.kumar
 */
public class RandomEx {
    public static void main(String...args) {
        new Random().ints(10, 30, 40).forEach(System.out::println);
    }
    
    public static int getRandomNumberInRange(int min, int max) {
        if(min >= max) {
            throw new IllegalArgumentException("Illegal Argument(s): Min must be less than max!");
        }
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
    
    public static int getMathRandomNumberInRange(int min, int max) {
        if(min >= max) {
            throw new IllegalArgumentException("Illegal Argument(s): Min must be less than max!");
        }
        return (int)(Math.random() * (min - max + 1)) + min;
    }
    
    public static int getRandomNumberInRange8(int min, int max) {
        if(min >= max) {
            throw new IllegalArgumentException("Illegal Argument(s): Min must be less than max!");
        }
        return new Random().ints(min, max + 1).findFirst().getAsInt();
    }
    
    
    
}
