package slidingWindow.medium;

/*
 MEDIUM
 No. 10
 Problem: Window Expand / Shrink Logic
 Pattern: Sliding Window (Master Template)
 Status: ✅ Core Concept

 Use this pattern in:
 - longest substring
 - smallest subarray
 - fruits into baskets
 - many interview problems
*/

public class ExpandShrink10 {

    public static int solve(int[] arr, int k) {

        int start = 0;
        int windowValue = 0; // sum / count / map etc.
        int answer = 0;

        for (int end = 0; end < arr.length; end++) {

            // STEP 1: EXPAND
            windowValue += arr[end]; //Move right pointer

            // STEP 2: SHRINK (if invalid)
            while (windowValue > k) {
                windowValue -= arr[start];
                start++;
            }

            // STEP 3: UPDATE ANSWER
            answer = Math.max(answer, end - start + 1);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,1,1,1};
        int k = 3;

        int result = solve(arr, k);

        System.out.println("Answer: " + result);
    }
}

/*

Concept

1. EXPAND
windowValue += arr[end];
Add new element
Move right side (end++)

2. SHRINK (if invalid)
while (windowValue > k)
If condition breaks → fix it
Remove from left:

3. UPDATE ANSWER
answer = Math.max(answer, end - start + 1);
Store best window size

🚍 Easy example
Fill bucket (expand)
If overflow → remove water (shrink)
Track largest valid size

DRY RUN
arr = [1,2,1,1,1]
k = 3

🔹 start = 0, answer = 0

🔹 end = 0 → 1
window = [1]
sum = 1 ≤ 3 ✅
length = 1
answer = 1

🔹 end = 1 → 2
window = [1,2]
sum = 3 ≤ 3 ✅
length = 2
answer = 2

end = 2 → 1
window = [1,2,1]
sum = 4 > 3 ❌
🔥 SHRINK
remove 1 → sum = 3
start = 1
window = [2,1]
length = 2
answer = 2


🔹 end = 3 → 1
window = [2,1,1]
sum = 4 > 3 ❌
🔥 SHRINK
remove 2 → sum = 2
start = 2
window = [1,1]
length = 2
answer = 2

🔹 end = 4 → 1
window = [1,1,1]
sum = 3 ≤ 3 ✅
length = 3
answer = 3 ✅

Final Answer: 3
 */