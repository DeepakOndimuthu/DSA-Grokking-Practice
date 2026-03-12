package HashMap.traps;

import java.util.HashMap;

/*
 No. 5
 Problem: Ignoring Space Complexity
 Pattern: Memory Awareness
 Status: ✅ Trap Covered

 Input:
 large array

 Output:
 Frequency map

 Logic:
 1. HashMap stores elements
 2. Worst case all elements stored
 3. Space complexity becomes O(n)
*/

public class SpaceComplexityTrap05 {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        System.out.println(map);
    }
}