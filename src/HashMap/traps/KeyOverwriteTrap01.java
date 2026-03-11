package HashMap.traps;

import java.util.HashMap;

/*
 No. 1
 Problem: Key Overwrite Mistake
 Pattern: Frequency Counting Trap
 Status: ✅ Trap Covered

 Input:
 a a a

 Wrong Output:
 a → 1

 Correct Output:
 a → 3

 Logic:
 1. Using map.put(key, value) overwrites old value
 2. Use getOrDefault to increment frequency
*/

public class KeyOverwriteTrap01 {

    public static void main(String[] args) {

        HashMap<Character, Integer> map = new HashMap<>();

        char[] arr = {'a','a','a'};

        for(char ch : arr){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println(map);
    }
}