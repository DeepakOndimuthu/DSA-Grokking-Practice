package slidingWindow.easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximumExtra004 {
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();
        int start = 0;

        for (int end = 0; end < n; end++) {

            // 1. remove smaller elements from back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[end]) {
                dq.pollLast();
            }

            // 2. add current index
            dq.offerLast(end);

            // 3. remove elements outside window
            if (dq.peekFirst() < end - k + 1) {
                dq.pollFirst();
            }

            // 4. when window is ready
            if (end >= k - 1) {
                result[start] = nums[dq.peekFirst()];
                start++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}

/*

concept:
1. Remove smaller (while)
2. Add current
3. Remove out-of-window
4. Front = max

Goal: For every window → find maximum
[1  3  -1] -3  5  3  6  7  in this widow
3 is max so we take that is

we use Deque because (Double-ended queue)
we can,
add/remove from front
add/remove from back

Deque stores indexes, not values
Deque store Values are in decreasing order
(front = biggest)
ex:
nums = [1,3,-1]
dq = [0,1,2] (indexes)

1. dq.peekLast()
Get last index (back)
Do NOT remove

2. dq.pollLast()
 Remove last index

3. dq.offerLast(end)
Add index to back

4. dq.peekFirst()
Get first index (front)

5. dq.pollFirst()
Remove first index

Rule 1:
Remove smaller elements from back
Rule 2:
Add current index
Rule 3:
Remove elements outside window (from front)
Rule 4:
Front always gives max

eg:
[1,3,-1] → max = 3
[3,-1,-3] → max = 3
[-1,-3,5] → max = 5
[-3,5,3] → max = 5
[5,3,6] → max = 6
[3,6,7] → max = 7

Example:
if 5 comes → remove all smaller (3, -1, etc)

while concept
Remove all smaller elements from back
If new number is bigger → old smaller numbers useless ❌

Example:
nums = [1, 3]
dq = [0] → value = 1

Now new element = 3
Check:
nums[0] < 3 → YES
Remove 1

Now:
dq = []

Then add 3:
dq = [1]
✔ Only biggest stays

Remove outside window
If index is outside window → remove
Example:
k = 3
end = 3
window = [1,2,3]
valid indexes = 1,2,3
If deque has index 0 → remove

****
DRY RUN
nums = [1,3,-1,-3,5,3,6,7]
k = 3

Step 1:
end = 0 (1)
dq = []
add → dq = [0]
(no window yet)

Step 2:
end = 1 (3)
1 < 3 → remove → dq = []
add → dq = [1]
(no window yet)

Step 3:
end = 2 (-1)
3 < -1 ❌
add → dq = [1,2]
window ready:
max = nums[1] = 3

Step 4:
end = 3 (-3)
-1 < -3 ❌
add → dq = [1,2,3]
remove out:
start = 3-3+1 = 1
1 < 1 ❌ (keep)
max:
nums[1] = 3

end = 4 (5)
while -> so why that array all values remove or compare it repeat
-3 < 5 → remove → dq = [1,2]
-1 < 5 → remove → dq = [1]
3 < 5 → remove → dq = []

add:
dq = [4]
remove out:
start = 4-3+1 = 2
4 < 2 ❌
max:
nums[4] = 5


Step 5:
end = 5 (3)
5 < 3 ❌
add → dq = [4,5]
remove out:
start = 5-3+1 = 3
4 < 3 ❌
max:
nums[4] = 5


Step 6:
end = 6 (6)
3 < 6 → remove → dq = [4]
5 < 6 → remove → dq = []
add:
dq = [6]
max:
nums[6] = 6

Step 7:
end = 7 (7)
6 < 7 → remove → dq = []
add:
dq = [7]
max:
nums[7] = 7

***********

Example 2

remove out all condition false above example so one how works

nums = [9,8,7,6,5]
k = 3

Dry idea
end = 0
dq = [0] → 9

end = 1
dq = [0,1] → 9,8

end = 2
dq = [0,1,2] → 9,8,7
max = 9

end = 3
Now window should be:
[8,7,6]

BUT dq still has:
[0,1,2,3]

index 0 (value 9) is OUTSIDE window ❌

Now condition works:
start = 3-3+1 = 1
dq.peekFirst() = 0

0 < 1 ✅ → remove

✔ Now correct max = 8

*************
 */
