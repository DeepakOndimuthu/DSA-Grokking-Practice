package slidingWindow.medium;

import java.util.*;

/*
 MEDIUM
 No. 8
 Problem: Find All Anagram Occurrences
 Pattern: Sliding Window (Fixed Size + HashMap)
 Status: ✅ Solved

 LeetCode:
 - 438 (Find All Anagrams in a String)

 Input:
 s = "cbaebabacd"
 p = "abc"

 Output:
 [0, 6]

 Explanation:
 "cba" → index 0
 "bac" → index 6
*/

public class AnagramOccurrences08 {

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) return result;

        HashMap<Character, Integer> map = new HashMap<>();

        // frequency of p
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        int count = map.size();

        for (int end = 0; end < s.length(); end++) {

            char ch = s.charAt(end);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0) {
                    count--;
                }
            }

            // window size = p.length()
            if (end >= p.length() - 1) {

                // if all matched → add index
                if (count == 0) {
                    result.add(start);
                }

                char leftChar = s.charAt(start);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);

                    if (map.get(leftChar) == 1) {
                        count++;
                    }
                }

                start++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> result = findAnagrams(s, p);

        System.out.println(result);
    }
}

/*

What is anagram?
p = "abc"
anagrams = "abc", "acb", "bac", "bca", "cab", "cba"

Concept
Find all starting indexes in s where substring is a permutation of p
Note: same pattern as previous (Permutation in String)
Difference → store all matches
- That’s why [0, 6] not just 6

Example
s = "cbaebabacd"
p = "abc"

Windows:
cba → YES ✅ → index 0
bae → no
aeb → no
eba → no
bab → no
aba → no
bac → YES ✅ → index 6
acd → no

Final result
[0, 6]

Flow
1. Slide window
2. If match → store start index
3. Continue searching

***********************
DRY RUN
s = "cbaebabacd"
p = "abc"

Initial
map = {a=1, b=1, c=1}
count = 3
start = 0
window size = 3

🔹 end = 0 → 'c'
map = {a=1, b=1, c=0}
count = 2

🔹 end = 1 → 'b'
map = {a=1, b=0, c=0}
count = 1

🔹 end = 2 → 'a'
map = {a=0, b=0, c=0}
count = 0 ✅

Window = "cba"
result = [0]

Slide window
remove 'c'
map = {a=0, b=0, c=1}
count = 1
start = 1

🔹 end = 3 → 'e'
not in map → ignore
count = 1
Window "bae" → not match

Slide:
remove 'b'
map = {a=0, b=1, c=1}
count = 2
start = 2

🔹 end = 4 → 'b'
map = {a=0, b=0, c=1}
count = 1

🔹 end = 5 → 'a'
map = {a=-1, b=0, c=1}
count = 1

🔹 end = 6 → 'b'
map = {a=-1, b=-1, c=1}
count = 1

🔹 end = 7 → 'a'
map = {a=-2, b=-1, c=1}
count = 1

🔹 end = 8 → 'c'
map = {a=-2, b=-1, c=0}
count = 0 ✅

Window = "bac"
result = [0, 6]

🔹 end = 9 → 'd'
not in map

✅ Final Output
[0, 6]

 */
