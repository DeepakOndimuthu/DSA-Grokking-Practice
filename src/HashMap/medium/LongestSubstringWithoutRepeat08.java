package HashMap.medium;

import java.util.*;

/*
 MEDIUM
 Problem: Longest Substring Without Repeating Characters
 Pattern: HashMap + Sliding Window
 Status: ✅ Solved

 LeetCode:
 - 3 (Longest Substring Without Repeating Characters)

 Input:
 s = "abcabcbb"

 Output:
 3

 Explanation:
 The longest substring without repeating characters is "abc".
 Its length is 3.
*/

public class LongestSubstringWithoutRepeat08 {

    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // if character already seen and inside window
            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }

            map.put(ch, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
}

/*
Substring - Continuous characters & No skipping
Indexes:
0 1 2 3 4 5 6 7
a b c a b c b b

left  → start of window
right → current character

right moves forward every time
left moves only when duplicate found

Example: "abcabcbb"
Step 1
Window = "a"
No duplicate
Length = 1

Step 2
Window = "ab"
No duplicate
Length = 2

Step 3
Window = "abc"
No duplicate
Length = 3

Step 4
Next char = "a"
Duplicate found ❗

Now we move left
Remove old "a" from window

New window = "bca"

Continue...

Full dry code
Step 1 →  right = 0 → 'a'
map.put('a', 0)
Length: 0 - 0 + 1 = 1
maxLength = 1

Step 2 → right = 1 → 'b'
map {a → 0 , b → 1 }
Length: 1 - 0 + 1 = 2
maxLength = 2

Step 3 → right = 2 → 'c'
map {a → 0 , b → 1 ,c → 2}
Length: 2 - 0 + 1 = 3
maxLength = 3

Step 4 → right = 3 → 'a'
map contains map.get('a') = 0
condition
map.get('a') >= left
0 >= 0  → TRUE
left = map.get('a') + 1
left = 0 + 1 = 1
So map becomes:
map {a → 3 , b → 1 ,c → 2} that three is index 3 so we update it that map

Step 5 → right = 4 → 'b'
Check map: map.get('b') = 1
condition
map.get('b') >= left
1 >= 1 → TRUE
Duplicate inside window.
So move left:
left = 1 + 1 = 2
Now update map:
map {a → 3 , b → 4 ,c → 2}
Length: 4 - 2 + 1 = 3
maxLength still = 3

Step 6 → right = 5 → 'c'
map.get('c') = 2
Check:
2 >= left(2) → TRUE
Move left:
left = 2 + 1 = 3
Update map:
map {a → 3 , b → 4 ,c → 5}
Length:5 - 3 + 1 = 3
maxLength still = 3

Step 7 → right = 6 → 'b'
map.get('b') = 4
Check:
4 >= left(3) → TRUE
Move left:
left = 4 + 1 = 5
Update map:
map {a → 3 , b → 6 ,c → 5}
Length:6 - 5 + 1 = 2
maxLength still = 3

Step 8 → right = 7 → 'b'
map.get('b') = 6
Check:
6 >= left(5) → TRUE
Move left:
left = 6 + 1 = 7
Update map:
map {a → 3 , b → 7 ,c → 5}
Length:7 - 7 + 1 = 1
maxLength still = 3


 */
