package HashMap.medium;

import java.util.*;

/*
 MEDIUM
 Problem: Top K Frequent Elements
 Pattern: HashMap + Max Heap
 Status: ✅ Solved

 LeetCode:
 - 347 (Top K Frequent Elements)

 Input:
 nums = [1,1,1,2,2,3]
 k = 2

 Output:
 [1,2]

 Explanation:
 Return k elements with highest frequency.
*/

public class TopKFrequent04 {

    public static int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Max Heap based on frequency
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        maxHeap.addAll(map.keySet());

        // Step 3: Extract top k elements
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        int[] result = topKFrequent(nums, k);

        System.out.println(Arrays.toString(result));
    }
}

/*
Note:
concept why PQ used:
Map -  gives number → frequency (*Map is NOT sorted, It stores entries in random order.)
we need: Top k the highest frequency. So we need sorting.
Heap helps Get the highest frequency quickly

1 appears 3 times
2 appears 2 times
3 appears 1 time
Top 2 frequent = 1 and 2

PriorityQueue (Heap)
when used -> Need top / largest / smallest elements

***
PQ -> normally the smallest first but here we want Highest frequency first
this line (a, b) -> map.get(b) - map.get(a)
Compare element a and b based on frequency

map
1 → 3
2 → 2
3 → 1

now compare
a = 1
b = 2

map.get(b) - map.get(a)
= map.get(2) - map.get(1)
= 2 - 3
= -1
Negative means:  1 comes before 2 , so higher frequency comes first.

map.keySet() gives:[1, 2, 3] // Only keys Not frequencies.
insert all numbers into heap. Heap automatically arranges based on frequency
Top → 1 (freq 3)
Next → 2 (freq 2)
Next → 3 (freq 1)
maxHeap.addAll(map.keySet()); so heap now 1, 2, 3
heap does NOT sort by number. we're using the comparator that b - a

poll() means
maxHeap.poll(); Remove and return top element from heap.
k=2 means Loop runs 2 times.
Iteration 1
poll() → 1
Heap becomes:Top → 2
Next → 3
Iteration 2
poll() → 2
Heap becomes:Top → 3

Note:
HashMap - HashMap
PriorityQueue - PriorityQueue
Heap does NOT store key-value pairs It only stores numbers
ex: we use this program using comparator.
Top → 1 (freq 3)
Next → 2 (freq 2)
Next → 3 (freq 1)

poll() removes highest
returns it

add()	insert element
poll()	remove + return top
peek()	see top without removing

 */