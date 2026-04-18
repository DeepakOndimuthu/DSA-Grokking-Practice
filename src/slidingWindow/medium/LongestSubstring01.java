package slidingWindow.medium;

import java.util.HashSet;

/*
 MEDIUM
 No. 1
 Problem: Longest Substring Without Repeating Characters
 Pattern: Sliding Window (Variable Size + HashSet)
 Status: ✅ Solved

 LeetCode:
 - 3 (Longest Substring Without Repeating Characters)

 Input:
 s = "abcabcbb"

 Output:
 3

 Explanation:
 "abc" → length = 3 (longest without repeating)
*/

public class LongestSubstring01 {

    public static int longestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < s.length(); end++) {

            char ch = s.charAt(end);

            // if duplicate found → shrink window
            while (set.contains(ch)) {
                set.remove(s.charAt(start));
                start++;
            }

            set.add(ch);

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";

        int result = longestSubstring(s);

        System.out.println("Longest length: " + result);
    }
}

/*

"Duplicate → shrink"
"Unique → expand"

HashSet - It stores unique characters only
Example
add 'a' → set = [a]
add 'b' → set = [a,b]
add 'a' again → already exists ❌

first time while check set is empty
set.contains(ch) → false ❌ so loop not run

if contains values Remove characters from LEFT until duplicate gone

current window size - end - start + 1

*******
DRY RUN
s = "abcabcbb"

Step 1 → end = 0 ('a')
set = {}
'a' not in set → add
set = {a}

window = "a"
length = 1
maxLength = 1

Step 2 → end = 1 ('b')
set = {a}
'b' not in set → add
set = {a,b}

window = "ab"
length = 2
maxLength = 2

Step 3 → end = 2 ('c')
set = {a,b}
'c' not in set → add
set = {a,b,c}

window = "abc"
length = 3
maxLength = 3

Step 4 → end = 3 ('a') ❗ duplicate
set = {a,b,c}
'a' already exists

While loop starts:
remove 'a' (start=0)
set = {b,c}
start = 1

Add 'a':
set = {b,c,a}
window = "bca"
length = 3
maxLength = 3

Step 5 → end = 4 ('b') ❗
remove 'b'
set = {c,a}
start = 2

Add 'b':

set = {c,a,b}
window = "cab"
length = 3
maxLength = 3

Step 6 → end = 5 ('c') ❗
remove 'c'
set = {a,b}
start = 3

Add 'c':

set = {a,b,c}
window = "abc"
length = 3
maxLength = 3

Step 7 → end = 6 ('b') ❗
remove 'a'
set = {b,c}
start = 4

still duplicate → remove 'b'
set = {c}
start = 5

Add 'b':

set = {c,b}
window = "cb"
length = 2
maxLength = 3

Step 8 → end = 7 ('b') ❗
remove 'c'
set = {b}
start = 6

still duplicate → remove 'b'
set = {}
start = 7

Add 'b':

set = {b}
window = "b"
length = 1
maxLength = 3

Final Answer
maxLength = 3

 */