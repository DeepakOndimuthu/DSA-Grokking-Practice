package slidingWindow.traps;

import java.util.HashMap;

/*
 No. 3
 Problem: HashMap + Window Confusion
 Pattern: Sliding Window + HashMap Trap
 Status: ✅ Trap Covered

 Input:
 s = "aab"

 Wrong:
 map not updated when shrinking

 Correct:
 decrease count and remove if zero

 Logic:
 1. When shrinking → update map
 2. Remove key if count becomes 0
*/

public class HashMapWindowTrap03 {

    public static void main(String[] args) {

        String s = "aab";

        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0;

        for (int end = 0; end < s.length(); end++) {

            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // simulate shrink
            char left = s.charAt(start);

            map.put(left, map.get(left) - 1);

            if (map.get(left) == 0) {
                map.remove(left); // ✅ important
            }

            start++;
        }

        System.out.println(map);
    }
}

/*

Correct rule
Expand → add to map
Shrink → remove/update from map

Problem:
Expand:
map.put(ch, map.getOrDefault(ch, 0) + 1);

Shrink:
char left = s.charAt(start);
map.put(left, map.get(left) - 1);

Remove character completely
if (map.get(left) == 0) {
    map.remove(left);
}

Easy example
Think:
Window = people inside bus
When someone leaves → remove from list

Don’t keep old people in list ❌

this sum:
Shrink → decrease count → remove if zero

*******
Dry idea
s = "aab"
🔹 end = 0 → 'a'
map = {a=1}
Shrink:
remove 'a' → map = {a=0} → remove → {}

🔹 end = 1 → 'a'
map = {a=1}
Shrink → same → {}

🔹 end = 2 → 'b'
map = {b=1}
Shrink → {}

✅ Final Output
{}

 */