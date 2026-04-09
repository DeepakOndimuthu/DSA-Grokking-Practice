package slidingWindow.easy;

import java.util.Arrays;

/*
 EASY
 No. 2
 Problem: Average of Subarrays of Size K
 Pattern: Sliding Window (Fixed Size)
 Status: ✅ Solved

 LeetCode similar:
 - 643 (Maximum Average Subarray I)

 Input:
 arr = [1,3,2,6,-1,4,1,8,2]
 k = 5

 Output:
 [2.2, 2.8, 2.4, 3.6, 2.8]

 Explanation:
 Subarrays of size 5:
 [1,3,2,6,-1] -> sum = 11 -> avg = 2.2
 [3,2,6,-1,4] -> sum = 14 -> avg = 2.8
 [2,6,-1,4,1] -> sum = 12 -> avg = 2.4
 [6,-1,4,1,8] -> sum = 18 -> avg = 3.6
 [-1,4,1,8,2] -> sum = 14 -> avg = 2.8
*/

public class AverageSubarray02 {

    public static double[] findAverages(int[] arr, int k) {

        double[] result = new double[arr.length - k + 1];

        int windowSum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {

            windowSum += arr[end]; // add next element

            // when we hit window size k
            if (end >= k - 1) {

                result[start] = (double) windowSum / k;

                windowSum -= arr[start]; // remove first element
                start++; // slide window
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1,3,2,6,-1,4,1,8,2};
        int k = 5;

        double[] result = findAverages(arr, k);

        System.out.println(Arrays.toString(result));
    }
}

/*
Window find logic is think this like
First 5 people enter
One person leaves (start++)
Next person enters (end++)

ex:
First time:
We build full window (size = k)
Example:
[1,3,2,6,-1]

After that:
Every step:
Remove first person ➖
Add next person ➕

First time we take 5 elements
After that → remove 1st element and add next element

result size
double[] result = new double[arr.length - k + 1];

n = 9, k = 5
count = 9 - 5 + 1 = 5
so 5 windows
if we use new double[arr.length]
we will get extra empty values

concept
end → moves forward (adds element ➕)
start → removes old element ➖
This is sliding window

*********

[1,3,2,6,-1,4,1,8,2]
k = 5

step 1 loop:
end = 0
windowSum = 1
window = [1]
❌ Not size 5 yet

end = 1
windowSum = 1 + 3 = 4
window = [1,3]

end = 2
windowSum = 6
window = [1,3,2]

end = 3
windowSum = 12
window = [1,3,2,6]

end = 4 ✅ (FIRST FULL WINDOW)
windowSum = 11
window = [1,3,2,6,-1]
if (end >= k - 1) → 4 >= 4 ✅
result[0] = 11 / 5 = 2.2

now important
windowSum -= arr[start]; // remove 1
start++; // start = 1

windowSum = 10
start = 1

Step 2:
Next iteration → end = 5
windowSum += arr[end]; // add arr[5] = 4
windowSum = 10 + 4 = 14
Now window is:
[3,2,6,-1,4]
Now again: if (end >= k - 1)
Store:
result[1] = 14 / 5 = 2.8

************************

Full Dry Run
Step 1:
window = [1,3,2,6,-1]
sum = 11
avg = 2.2
store at:
result[0]

Step 2:

Slide →
remove 1, add 4
window = [3,2,6,-1,4]
sum = 14
avg = 2.8
store at:
result[1]

same like continue..

 */