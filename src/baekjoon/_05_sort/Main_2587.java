package baekjoon._05_sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2587 {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        int[] input = new int[5];
        int sum = 0;
        int mid = 0;
        
        for(int i = 0; i < 5; i++){
            input[i] = sc.nextInt();
            sum += input[i];
        }
        
        Arrays.sort(input);
        
        System.out.println(sum/5);
        System.out.println(input[2]);
        
        sc.close();
    }
}