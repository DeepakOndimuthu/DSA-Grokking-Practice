package slidingWindow.traps;

/*
 No. 1
 Problem: Window Not Shrinking
 Pattern: Sliding Window Trap
 Status: ✅ Trap Covered

 Input:
 arr = [1,2,3,4]
 k = 5

 Wrong:
 window keeps expanding

 Correct:
 shrink when condition breaks

 Logic:
 1. Always shrink when invalid
 2. Use while, not if
*/

public class WindowNotShrinking01 {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        int k = 5;

        int start = 0;
        int sum = 0;

        for (int end = 0; end < arr.length; end++) {

            sum += arr[end];

            // ❌ WRONG (only one shrink)
            // if (sum > k)

            // ✅ CORRECT
            while (sum > k) {
                sum -= arr[start];
                start++;
            }

            System.out.println("Window: " + start + " to " + end);
        }
    }
}