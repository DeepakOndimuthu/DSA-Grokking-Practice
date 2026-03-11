package HashMap.traps;

import java.util.HashMap;

/*
 No. 2
 Problem: NullPointerException when key not present
 Pattern: Safe Map Access
 Status: ✅ Trap Covered

 Input:
 map.get('a') when 'a' not in map

 Output:
 NullPointerException

 Logic:
 1. map.get(key) returns null if key missing
 2. Adding +1 to null causes crash
 3. Use getOrDefault(key, 0)
*/

public class NullHandlingTrap02 {

    public static void main(String[] args) {

        HashMap<Character, Integer> map = new HashMap<>();

        char ch = 'a';

        int count = map.getOrDefault(ch, 0) + 1;

        map.put(ch, count);

        System.out.println(map);
    }
}

/*
wrong declare
int count = map.get(ch) + 1;  // ❌ Problem here
 */