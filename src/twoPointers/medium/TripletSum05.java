package twoPointers.medium;

import java.util.*;

/*
 MEDIUM
 No. 5
 Problem: Triplet Sum (3Sum)
 Pattern: Sorting + Two Pointers
 Status: ✅ Solved

 LeetCode:
 - 15 (3Sum)

 Input:
 nums = [-1,0,1,2,-1,-4]

 Output:
 [[-1,-1,2], [-1,0,1]]

 Explanation:
 Find all unique triplets that sum = 0
*/

public class TripletSum05 {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // VERY IMPORTANT

        for (int i = 0; i < nums.length - 2; i++) {

            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};

        System.out.println(threeSum(nums));
    }
}

/*
Step 1:
Sort array
[-4,-1,-1,0,1,2]

Step 2:
Fix one number:
ex: i = -1; this sum is -4

Step 3:
Use two pointers:
left → next
right → end

Step 4:
sum = a + b + c
sum == 0 → store
sum < 0 → increase left
sum > 0 → decrease right

*********
Why nums.length - 2 ?
We need 3 numbers
nums[i], nums[left], nums[right]

So at least:
i + 2 elements must exist


Example
[1,2,3,4,5]  (length = 5)

Valid i:
i = 0 → (0,1,2) ✅
i = 1 → (1,2,3) ✅
i = 2 → (2,3,4) ✅
i = 3 → ❌ only 2 elements left

So:
i < length - 2

**********
if (i > 0 && nums[i] == nums[i - 1]) continue;
Skip duplicate starting element

✅ Compare with previous
nums[i] == nums[i-1]

Example
[-4,-1,-1,0,1,2]

Loop:
i = 1 → -1
i = 2 → -1 (duplicate)

So skip:
second -1

*********
concept:
1️⃣ sum == 0  → add result + skip duplicates + move both
2️⃣ sum < 0   → left++
3️⃣ sum > 0   → right--

Index:      0   1   2   3   4   5
after sort: -4  -1  -1  0   1   2

// Skip duplicate i values
if (i > 0 && nums[i] == nums[i - 1]) {
i = 2 → -1
nums[2] = -1
nums[1] = -1
Same value.
If we continue, we will again get so skip it

i = 0 → -4
Need total = 0

left = 1 (-1)
right = 5 (2)

Sum:
-4 + (-1) + 2 = -3

Is sum == 0? ❌
Is sum < 0? ✅ YES

So we do:
left++

Now:
left = 2 (-1)
right = 5 (2)
-4 + (-1) + 2 = -3
Still < 0 → left++

Now:
left = 3 (0)
-4 + 0 + 2 = -2
Still < 0 → left++

Now:
left = 4 (1)
-4 + 1 + 2 = -1
Still < 0 → left++

Now left = 5
left == right → stop
No answer for i = 0.

********
i = 1 → -1

left = 2 (-1)
right = 5 (2)

Sum:
-1 + (-1) + 2 = 0

YES 🎉 Found valid triplet:
[-1, -1, 2]

Now duplicate skipping part
Check left side:
nums[2] == nums[3] ?
-1 == 0 ? NO
So left does NOT move here.

Check right side:
nums[5] == nums[4] ?
2 == 1 ? NO
So right does NOT move here.

Now we move both normally:
left++
right--

So:
left = 3
right = 4


Now check again:
-1 + 0 + 1 = 0
Again sum == 0 🎉
Add:
[-1, 0, 1]

Now skip duplicates again:
Left check:
nums[3] == nums[4] ?
0 == 1 ? NO
Right check:
nums[4] == nums[3] ?
1 == 0 ? NO

Then move:
left = 4
right = 3

Stop (left >= right)

***************
i = 2 → -1

Now this line important:
if (nums[i] == nums[i-1])

At i = 2:

nums[2] = -1
nums[1] = -1

Same value.
If we continue, we will again get:

[-1, -1, 2]
[-1, 0, 1]

Duplicate results.
So we skip.

****************
i = 3 → 0

left = 4
right = 5

0 + 1 + 2 = 3

Sum > 0
So:
right--
right = 4 → stop
Final Answer
[[-1,-1,2], [-1,0,1]]

*************
 */