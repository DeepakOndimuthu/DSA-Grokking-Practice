package twoPointers.traps;

/*
 TRAP 1
 Problem: Left == Right Case
*/

public class Trap01_LeftEqualsRight {

    public static void check(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) { // <= includes middle

            System.out.println(arr[left] + " , " + arr[right]);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        check(arr);
    }
}

/*

left == right → middle element
<= → includes middle
< → excludes middle

 */