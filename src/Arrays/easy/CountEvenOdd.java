package Arrays.easy;

/*
 EASY
 No. 5
 Problem: Count Even and Odd Numbers in an Array
 Pattern: Array Traversal + Counting
 Status: ✅ Solved
 Input: nums = [1, 2, 3, 4, 5]
 Output: Even = 2, Odd = 3
 Explanation:
 Traverse array and check each number using modulo.
*/

public class CountEvenOdd {

    public static void countEvenOdd(int[] nums) {
        int even = 0;
        int odd = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even = " + even);
        System.out.println("Odd = " + odd);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        countEvenOdd(nums);
    }
}

