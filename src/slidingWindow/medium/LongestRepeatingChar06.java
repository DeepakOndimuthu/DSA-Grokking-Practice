package slidingWindow.medium;

import java.util.HashMap;

/*
 MEDIUM
 No. 6
 Problem: Longest Repeating Character Replacement
 Pattern: Sliding Window (Variable Size + HashMap)
 Status: ✅ Solved

 LeetCode:
 - 424 (Longest Repeating Character Replacement)

 Input:
 s = "AABABBA"
 k = 1

 Output:
 4

 Explanation:
 Replace 1 character → longest repeating substring = "AABA" or "ABBA"
 length = 4
*/

public class LongestRepeatingChar06 {

    public static int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0;
        int maxCount = 0;   // count of most frequent char in window
        int maxLength = 0;

        for (int end = 0; end < s.length(); end++) {

            char ch = s.charAt(end);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // track max frequency
            maxCount = Math.max(maxCount, map.get(ch));

            // window size - maxCount = changes needed
            while ((end - start + 1) - maxCount > k) {

                char leftChar = s.charAt(start);
                map.put(leftChar, map.get(leftChar) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        int result = characterReplacement(s, k);

        System.out.println("Longest length: " + result);
    }
}

/*

concept
1. You can replace at most k characters
2. Make all characters same in a window
3. Find longest such window

If changes ≤ k → valid
If changes > k → shrink

1. Add character → update map
2. Track maxCount
3. If (window - maxCount > k) → shrink
4. Update maxLength

while ex:
changes needed > k → NOT allowed ❌
window size = 5
maxCount = 3
changes needed = 5 - 3 = 2

Dry Run:
s = "AABABBA", k = 1
A → valid → len=1
AA → valid → len=2
AAB → valid → len=3
AABA → valid → len=4 ✅
AABAB → invalid → shrink
Answer: 4

full dry run step-by-step
s = "AABABBA"
k = 1

start = 0
maxCount = 0
maxLength = 0
map = {}

🔹end = 0 → 'A'
map = {A=1}
maxCount = 1

window size = 1
changes = 1 - 1 = 0 ≤ k ✅
maxLength = 1

🔹end = 1 → 'A'
map = {A=2}
maxCount = 2

window size = 2
changes = 2 - 2 = 0 ≤ k ✅
maxLength = 2

🔹end = 2 → 'B'
map = {A=2, B=1}
maxCount = 2

window size = 3
changes = 3 - 2 = 1 ≤ k ✅
maxLength = 3

🔹end = 3 → 'A'
map = {A=3, B=1}
maxCount = 3

window size = 4
changes = 4 - 3 = 1 ≤ k ✅
maxLength = 4 ✅
window = "AABA"

🔹 end = 4 → 'B'
map = {A=3, B=2}
maxCount = 3

window size = 5
changes = 5 - 3 = 2 > k ❌
Enter while loop
Shrink window
remove s[0] = 'A'
map = {A=2, B=2}
start = 1

Now,
window size = 4
changes = 4 - 3 = 1 ≤ k ✅
maxLength = 4

🔹end = 5 → 'B'
map = {A=2, B=3}
maxCount = 3

window size = 5
changes = 5 - 3 = 2 > k ❌
Shrink
remove s[1] = 'A'
map = {A=1, B=3}
start = 2

Now:
window size = 4
changes = 4 - 3 = 1 ≤ k ✅
maxLength = 4

🔹 end = 6 → 'A'
map = {A=2, B=3}
maxCount = 3

window size = 5
changes = 5 - 3 = 2 > k ❌
Shrink
remove s[2] = 'B'
map = {A=2, B=2}
start = 3

Now:
window size = 4
changes = 4 - 3 = 1 ≤ k ✅
maxLength = 4

Final Answer
maxLength = 4

 */