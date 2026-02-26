package HashMap.medium;

import java.util.HashMap;

/*
 MEDIUM
 Problem: Check Anagram Using Map
 Pattern: Frequency Map
 Status: ✅ Solved

 LeetCode:
 - 242 (Valid Anagram)

 Input:
 s = "anagram"
 t = "nagaram"

 Output:
 true

 Explanation:
 Both strings contain same characters
 with same frequency.
*/

public class CheckAnagram06 {

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Count characters of s
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Decrease count using t
        for (char ch : t.toCharArray()) {

            //if character NOT in map → return false
            /*
            !true  → false
            !false → true
             */
            if (!map.containsKey(ch)) {
                return false;
            }

            map.put(ch, map.get(ch) - 1);

            if (map.get(ch) < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}

/*
s = "rat"
t = "car"
if (!map.containsKey(ch)) { this part
map.containsKey('c') → false
So return false.

map.containsKey('c') Is 'c' in map? No
!false → true
So condition becomes: true inside the block and return false

String s = "anagram";
{a=3, n=1, g=1, r=1, m=1}

Iteration 1
map.put(ch, map.get(ch) - 1);
n → 1 - 1 = 0

map.put(n, map.get(n) -1)
map.put(n, 1-1)
so n-0

map is a=3, n=0, g=1, r=1, m=1

map.get('n') < 0 ? NO

Iteration 2
Decrease
a → 3 - 1 = 2
a=2, n=0, g=1, r=1, m=1

Iteration 3
g → 1 - 1 = 0

Iteration 4
a → 2 - 1 = 1

Iteration 5
r → 1 - 1 = 0

Iteration 6
a → 1 - 1 = 0

Iteration 7
m → 1 - 1 = 0

final map
a=0
n=0
g=0
r=0
m=0
 */