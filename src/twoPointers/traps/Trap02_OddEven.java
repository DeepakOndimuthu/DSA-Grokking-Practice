package twoPointers;

/*
 TRAP 2
 Problem: Odd / Even Length Center
*/

public class Trap02_OddEven {

    public static void check(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            left++;
            right--;
        }

        System.out.println("Middle index = " + left);
    }

    public static void main(String[] args) {

        int[] odd = {1,2,3,4,5};   // middle = 2
        int[] even = {1,2,3,4};    // middle = 2 (second middle)

        check(odd);
        check(even);
    }
}

/*

Odd → one middle
Even → two middle → returns second middle

 */