package HashMap.traps;

import java.util.HashMap;
import java.util.Map;

/*
 No. 4
 Problem: Incorrect Map Iteration
 Pattern: EntrySet Traversal
 Status: ✅ Trap Covered

 Input:
 map = {a=2, b=1}

 Output:
 a → 2
 b → 1

 Logic:
 1. Map cannot be looped directly
 2. Use entrySet() to access key and value
*/

public class IterateMapTrap04 {

    public static void main(String[] args) {

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('a',2);
        map.put('b',1);

        for(Map.Entry<Character,Integer> entry : map.entrySet()){

            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}