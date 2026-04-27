package slidingWindow.medium;

import java.util.HashMap;

/*
 MEDIUM
 No. 7
 Problem: Permutation in String
 Pattern: Sliding Window (Fixed Size + HashMap)
 Status: ✅ Solved

 LeetCode:
 - 567 (Permutation in String)

 Input:
 s1 = "ab"
 s2 = "eidbaooo"

 Output:
 true

 Explanation:
 "ba" is a permutation of "ab"
*/

public class PermutationInString07 {

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        // count frequency of s1
        for (char ch : s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        int count = map.size();

        for (int end = 0; end < s2.length(); end++) {

            char ch = s2.charAt(end);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0) {
                    count--;
                }
            }

            // window size = s1.length()
            if (end >= s1.length() - 1) {

                if (count == 0) return true;

                char leftChar = s2.charAt(start);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);

                    if (map.get(leftChar) == 1) {
                        count++;
                    }
                }

                start++;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean result = checkInclusion(s1, s2);

        System.out.println("Permutation exists: " + result);
    }
}

/*

Concept
Does s2 contain any permutation of s1?
s1 = "ab"
permutations = "ab", "ba"

If any of these exists in s2 → return true

Instead of generating permutations ❌ (slow)
We do:
1. Count characters of s1
2. Use sliding window of size s1.length()
3. Compare window with s1 frequency

Window size = 2
Windows:
ei → no
id → no
db → no
ba → YES ✅

program flow:
1. Build frequency map of s1
2. Slide window on s2
3. Decrease count when match
4. Increase count when mismatch
5. If count == 0 → found permutation

🚍 Easy example
You need items: a, b
When you get both → success
If one item leaves → not complete

******************
DRY RUN
s1 = "ab"
s2 = "eidbaooo"

Initial setup
map = {a=1, b=1}
count = 2   (two characters to match)
start = 0
window size = 2

🔹 end = 0 → 'e'
'e' not in map → ignore
map = {a=1, b=1}
count = 2

🔹 end = 1 → 'i'
'i' not in map → ignore
map = {a=1, b=1}
count = 2
✅ Window ready (size = 2)
window = "ei"
count ≠ 0 → not match

Slide:
leftChar = 'e' → not in map → nothing
start = 1

🔹 end = 2 → 'd'
'd' not in map

Window:
"id"
count = 2 → not match

Slide:
leftChar = 'i'
start = 2

end = 3 → 'b'
'b' in map → reduce
map = {a=1, b=0}
count = 1
Window:
"db"
count ≠ 0 → not match

Slide:
leftChar = 'd'
start = 3

🔹 end = 4 → 'a' 🔥
'a' in map → reduce
map = {a=0, b=0}
count = 0
✅ Window = "ba"
count == 0 → MATCH FOUND ✅
👉 return true

✅ Final Answer
true

 */
