package HashMap.medium;

import java.util.HashMap;

/*
 MEDIUM
 Problem: First Unique Character in a String
 Pattern: HashMap Frequency Counting
 Status: ✅ Solved

 LeetCode:
 - 387 (First Unique Character in a String)

 Input:
 s = "leetcode"

 Output:
 0

 Explanation:
 Return index of first character
 whose frequency is 1.
*/

public class FirstUniqueCharacter03 {

    public static int firstUniqChar(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Find first unique
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i; //return index
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String s = "leetcode";

        System.out.println(firstUniqChar(s));
    }
}

/*
Note:
s = "leetcode"
that map:
l → 1
e → 3
t → 1
c → 1
o → 1
d → 1

Map stores:
{l=1, e=3, t=1, c=1, o=1, d=1}

if condition check left to right
index value of map.get() -> s.charAt(i)
Index 0 → 'l'
map.get('l') = 1
L value is 1 so return that index

 */