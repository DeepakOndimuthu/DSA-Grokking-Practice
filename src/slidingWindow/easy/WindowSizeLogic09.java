package slidingWindow.easy;

/*
 EASY
 No. 9
 Problem: Window Size Logic
 Pattern: Sliding Window (Understanding Size)
 Status: ✅ Solved

 LeetCode similar:
 - Used in almost all sliding window problems

 Input:
 arr = [1,2,3,4,5]
 k = 3

 Output:
 Window size always = 3

 Explanation:
 Understand how window size is calculated:
 window size = end - start + 1
*/

public class WindowSizeLogic09 {

    public static void checkWindowSize(int[] arr, int k) {

        int start = 0;

        for (int end = 0; end < arr.length; end++) {

            int windowSize = end - start + 1;

            // when window reaches size k
            if (windowSize == k) {

                System.out.println("Valid window from index "
                        + start + " to " + end);

                start++; // shrink window
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        int k = 3;

        checkWindowSize(arr, k);
    }
}

/*

Note
window size = end - start + 1
start = beginning index
end = ending index

eg:
start = 0, end = 2
window = [1,2,3]
size = 2 - 0 + 1 = 3

conditions
< k   → expand window
== k  → valid window ✅
> k   → shrink window

Dry Run
arr = [1,2,3,4,5]
k = 3
end = 0
start = 0
windowSize = 0 - 0 + 1 = 1 (< k)

end = 1
windowSize = 1 - 0 + 1 = 2 (< k)

end = 2 ✅
windowSize = 2 - 0 + 1 = 3 (= k)

valid window:
[1,2,3]
Print:
start = 0, end = 2

Then:
start++

end = 3
start = 1
windowSize = 3 - 1 + 1 = 3 (= k)

valid window:
[2,3,4]
Print:
start = 1, end = 3

Then:
start = 2

end = 4
start = 2
windowSize = 4 - 2 + 1 = 3 (= k)

valid window:
[3,4,5]
Print:
start = 2, end = 4

 */