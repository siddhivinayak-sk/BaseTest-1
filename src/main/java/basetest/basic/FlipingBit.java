/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author sandeepkumar
 */
public class FlipingBit {
    
    
    
    


    
    
    public static int score(int[] input1, int input2) {
        int result = -1;
        
        
        
        return result;
    }
    
    
    
    public static void combinations(int[] iarr, int p) {
        int tempArr[] = new int[iarr.length];

        String tempStr = "";
        int q = 0;
        for(int r = 0; r < tempArr.length; r++) {
            if(!tempStr.contains(iarr[r] + ",")) {
                tempStr += iarr[r] + ",";
                tempArr[q] = iarr[r];
                q++;
            }
        }
        int arr[] = new int[q];
        for(int s = 0; s < q; s++) {
            arr[s] = tempArr[s];
        }
        int n = arr.length;
        List<int[]> list = new ArrayList<>();
        int numArrays = (int)Math.pow(arr.length, n);
        int[][] list1 = new int[numArrays][n];
        for(int j = 0; j < n; j++) {
            int period = (int) Math.pow(arr.length, n - j - 1);
            for(int i = 0; i < numArrays; i++) {
                int index = i / period % arr.length;
                int[] current = list1[i];
                current[j] = arr[index];
                
                if(j+1 == n && !isDuplicateArray(current)) {
                    list.add(current);
                }
            }
        }
        for(int[] tia:list) {
            for(int t:tia) {
                System.out.print(t + ",");
            }
            System.out.println("");
        }
    }    
    
    public static boolean isDuplicateArray(int[] arr) {
        boolean result = false;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(i != j) {
                    if(arr[i] == arr[j]) {
                        result = true;
                    }
                }
            }
        }
        
        return result;
    }


    public static int shortPile(int[] store) {
        int steps = -1;
        if(null == store || store.length <= 0) {
            return steps;
        }
        steps = 0;
        for(int i = 0; i < store.length; i++) {
            for(int j = i + 1; j < store.length; j++) {
                if(store[i] < store[j]) {
                    int temp = store[i];
                    store[i] = store[j];
                    store[j] = temp;
                    steps++;
                }
            }
        }
        return steps;
    }

    public static int giveBallCont(int[] input1, int input2, int input3) {
        int result = -1;
        if(null == input1 || input1.length <= 0 || input1.length > 1000 || input2 < 0 || input3 < 0) {
            return result;
        }
        List<short[]> list = new ArrayList<short[]>();
        int numArrays = (int)Math.pow(input1.length, input3);
        for(int i = 0; i < numArrays; i++) {
            list.add(new short[input3]);
        }
        for(int j = 0; j < input3; j++) {
            int period = (int) Math.pow(input1.length, input3 - j - 1);
            for(int i = 0; i < numArrays; i++) {
                int index = i / period % input1.length;
                short[] current = list.get(i);
                current[j] = Short.valueOf(input1[index]+"");
            }
        }
        for(short[] temp:list) {
            int sum = 0;
            for(int t:temp) {
                sum += t;
            }
            if(((sum % input2) == 0) && sum > input2) {
                result = sum;
                break;
            }
        }
        return result;
    }
    

    public static void combinations(int n, int[] arr, List<int[]> list) {
        int numArrays = (int)Math.pow(arr.length, n);
        for(int i = 0; i < numArrays; i++) {
            list.add(new int[n]);
        }
        for(int j = 0; j < n; j++) {
            int period = (int) Math.pow(arr.length, n - j - 1);
            for(int i = 0; i < numArrays; i++) {
                int[] current = list.get(i);
                int index = i / period % arr.length;
                current[j] = arr[index];
            }
        }
    }    
    
    


    public static int filipBit(String input1, int input2, int input3) {
        if(input2 <= 0 || input3 <= 0) {
            return -1;
        }
        else {
            char[] source = input1.toCharArray();
            char[] sourceb = input1.toCharArray();
            source[input2] = ('0' == source[input2])?'1':'0';
            source[input3] = ('0' == source[input3])?'1':'0';
            
//            for(int x = 0; x < input2; x++) {
//                source[x] = ('0' == source[x])?'1':'0';
//            }
//            for(int x = 0; x < input3; x++) {
//                source[x] = ('0' == source[x])?'1':'0';
//            }
            int count = 0;
            for(int x = 0; x < sourceb.length; x++) {
                if(source[x] == sourceb[x]) {
                    count++;
                }
            }
            return count;
        }
    }
    
    public static void main(String...args) {
//        System.out.println(filipBit("10110101101", 3, 4));
//        int[] temp = {1, 2, 3, 4, 5};
//        System.out.println(giveBallCont(temp, 5, 3));
//        System.out.println(shortPile(new int[]{3, 1, 3, 2}));
        
        //combinations(new int[]{10,2,5,1,2,4,1,6,5,2,2}, 6);
        
        
        System.out.println(score(new int[]{2,2,1,1,1}, 4));
    }
    
}
