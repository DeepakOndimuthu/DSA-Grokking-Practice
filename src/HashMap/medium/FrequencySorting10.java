package HashMap.medium;

import java.util.*;

/*
 MEDIUM
 Problem: Frequency Sorting
 Pattern: HashMap + Max Heap
 Status: ✅ Solved

 LeetCode:
 - 451 (Sort Characters By Frequency)

 Input:
 "tree"

 Output:
 "eert"
*/

public class FrequencySorting10 {

    public static String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Max heap based on frequency
        PriorityQueue<Character> maxHeap =
                new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        maxHeap.addAll(map.keySet());

        // Step 3: Build result
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {

            char ch = maxHeap.poll();
            int freq = map.get(ch);

            for (int i = 0; i < freq; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "tree";

        System.out.println(frequencySort(s));
    }
}

/*
PriorityQueue This creates a Min Heap (smallest element comes first).
ex: 1 2 3 4
here we want highest frequency first. So we create Max Heap using a comparator.
(a, b) -> map.get(b) - map.get(a)
Example map:
t → 1
r → 1
e → 2

Now compare:
a = t
b = e

map.get(e) - map.get(t)
2 - 1 = 1
So e comes before t.

so heap order it
e
t
r

map.keySet() gives all characters.
map
t → 1
r → 1
e → 2
map.keySet() returns: [t, r, e]
maxHeap.addAll(...) puts all characters into the heap.


Step 1 (frequency map)
t → 1
r → 1
e → 2
Step 2 (heap)
[e, t, r]
Step 3 (build string)

poll → e
ee

poll → t
eet

poll → r
eetr

Final output:
eert

HashMap → count frequency
PriorityQueue → highest frequency first
poll() → remove top element
StringBuilder → build final string
 */