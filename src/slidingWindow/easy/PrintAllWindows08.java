package slidingWindow.easy;

/*
 EASY
 No. 8
 Problem: Print All Windows of Size K
 Pattern: Sliding Window (Fixed Size - Traversal)
 Status: ✅ Solved

 LeetCode similar:
 - Basic concept (used in many problems)

 Input:
 arr = [4,2,7,1,3]
 k = 3

 Output:
 [4,2,7]
 [2,7,1]
 [7,1,3]

 Explanation:
 Print every window of size K
*/

public class PrintAllWindows08 {

    public static void printWindows(int[] arr, int k) {

        int start = 0;

        for (int end = 0; end < arr.length; end++) {

            // when window size becomes k
            if (end >= k - 1) {

                System.out.print("[");

                for (int i = start; i <= end; i++) {
                    System.out.print(arr[i]);

                    if (i < end) {
                        System.out.print(",");
                    }
                }

                System.out.println("]");

                start++; // slide window
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {4,2,7,1,3};
        int k = 3;

        printWindows(arr, k);
    }
}