package slidingWindow.medium;

/*
 MEDIUM
 No. 3
 Problem: Max Consecutive Ones (with K flips)
 Pattern: Sliding Window (Variable Size)
 Status: ✅ Solved

 LeetCode:
 - 1004 (Max Consecutive Ones III)

 Input:
 nums = [1,1,1,0,0,0,1,1,1,1,0]
 k = 2

 Output:
 6

 Explanation:
 Flip at most 2 zeros → longest subarray of 1s = 6
*/

public class MaxConsecutiveOnes03 {

    public static int longestOnes(int[] nums, int k) {

        int start = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int end = 0; end < nums.length; end++) {

            // count zeros
            if (nums[end] == 0) {
                zeroCount++;
            }

            // if more than k zeros → shrink window
            while (zeroCount > k) {

                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        int result = longestOnes(nums, k);

        System.out.println("Max consecutive ones: " + result);
    }
}

/*

Rules
1. Expand window → move end
2. Count zeros
3. If zeros > k → shrink window (move start)
4. Track max length

DRY RUN
nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2

start = 0
🔹 end = 0 → 1
zeroCount = 0
window = [1]
length = 1
max = 1

end = 1 → 1
window = [1,1]
length = 2
max = 2

end = 2 → 1
window = [1,1,1]
length = 3
max = 3

end = 3 → 0
zeroCount = 1
window = [1,1,1,0]
length = 4
max = 4

end = 4 → 0
zeroCount = 2
window = [1,1,1,0,0]
length = 5
max = 5

end = 5 → 0 ❗
zeroCount = 3 (> k)
Now shrink:
start moves:
remove nums[0]=1 → no change
remove nums[1]=1 → no change
remove nums[2]=1 → no change
remove nums[3]=0 → zeroCount = 2

Now valid again
window = [0,0,0]
start = 4

end = 6 → 1
window = [0,0,1]
length = 3
max = 5

end = 7 → 1
window = [0,0,1,1]
length = 4

end = 8 → 1
window = [0,0,1,1,1]
length = 5

end = 9 → 1
window = [0,0,1,1,1,1]
length = 6
max = 6 ✅

end = 10 → 0 ❗
zeroCount = 3 (> k)

shrink:
remove nums[4]=0 → zeroCount = 2
start = 5

maxLength = 6

*************
that fifth part
end = 5 → 0 ❗ how you imagine
zeroCount = 2 (valid)
start = 4
end = 5

Final window
nums[4...5] = [0,0]
means
window always = nums[start ... end]

*************

Length:
Higher Index - Lower Index + 1
Example:
[1, 1, 0, 1]
start = 0
end = 3
whole window array is : [1, 1, 0, 1].
length is 3 - 0 + 1 = 4.

 */