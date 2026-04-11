package slidingWindow.easy;

/*
 EASY
 No. 3
 Problem: Count Subarrays of Size K
 Pattern: Sliding Window (Fixed Size)
 Status: ✅ Solved

 LeetCode similar:
 - Basic concept (no direct exact problem)

 Input:
 arr = [1,2,3,4,5]
 k = 3

 Output:
 3

 Explanation:
 Subarrays of size 3:
 [1,2,3]
 [2,3,4]
 [3,4,5]

 Total count = 3
*/

public class CountSubarrays03 {

    public static int countSubarrays(int[] arr, int k) {

        int count = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {

            // when window size becomes k
            if (end >= k - 1) {

                count++;       // one valid subarray found
                start++;       // slide window
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        int k = 3;

        int result = countSubarrays(arr, k);

        System.out.println("Total subarrays: " + result);
    }
}

/*

Note:
in this sum start not needed
windowSum -= arr[start] ❌
window = [1,2,3]

*******

Dry code:
arr = [1,2,3,4,5]
k = 3
count = 0

Step 1 → end = 0
window size = 1
end >= k-1 ? → 0 >= 2 ❌
so,
count = 0

Step 2 → end = 1
window size = 2
end >= k-1 ? → 1 >= 2 ❌
so,
count = 0

Step 3 → end = 2 ✅
window size = 3
end >= k-1 ? → 2 >= 2 ✅
First subarray:
[1,2,3]
count = 1

Step 4 → end = 3 ✅
end >= k-1 ? → 3 >= 2
Second subarray:
[2,3,4]
count = 2

Step 5 → end = 4 ✅
end >= k-1 ? → 4 >= 2
Third subarray:
[3,4,5]
count = 3

Final Answer count = 3

 */