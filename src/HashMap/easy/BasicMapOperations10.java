package HashMap.easy;

import java.util.HashMap;
import java.util.Map;

/*
 EASY
 No. 10
 Problem: Basic Map Operations
 Pattern: HashMap Basics
 Status: ✅ Solved

 Explanation:
 Demonstrates basic HashMap operations:
 put, get, containsKey, remove, iteration.
*/

public class BasicMapOperations10 {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        // put() -> add elements
        map.put("apple", 2);
        map.put("banana", 3);
        map.put("mango", 1);

        // get() -> get value
        System.out.println(map.get("apple"));

        // containsKey()
        System.out.println(map.containsKey("banana"));

        // update value
        map.put("apple", 5);

        // remove key
        map.remove("mango");

        // size
        System.out.println(map.size());

        // iterate map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
/*
Purpose of this Problem
Learn basic operations of HashMap:
1) Add element
2) Update element
3) Get value
4) Check key exists
5) Remove element
6) Iterate map

✅ Operations Covered
put()          → add / update value
get()          → get value using key
containsKey()  → check key exists
remove()       → delete key
size()         → total entries
entrySet()     → iterate key + value
 */
