package HashMap.easy;

import java.util.HashSet;

/*
 EASY
 No. 3
 Problem: Check Duplicates using HashSet
 Pattern: HashSet Lookup
 Status: ✅ Solved

 LeetCode similar:
 - 217 (Contains Duplicate)

 Input:
 arr = [1, 2, 3, 4, 2]

 Output:
 true

 Explanation:
 HashSet stores only unique values.
 If element already exists in set,
 duplicate is found.
*/

public class CheckDuplicates03 {

    public static boolean containsDuplicate(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {

            // if already exists -> duplicate
            if (set.contains(num)) {
                return true;
            }

            // otherwise add to set
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 2};

        System.out.println(containsDuplicate(arr));
    }
}

/*
HashSet → Only items //Attendance -> Same name cannot come twice.
HashSet stores only values.
No key
No index
Only unique elements allowed

HashSet<Integer> set = new HashSet<>();
set.add(1);
set.add(2);
set.add(2);
set.add(3);
Stored like:
[1, 2, 3]

HashMap → Item + information  (Deepak → 80) name and marks ; key and value
HashMap stores key + value pair.
map.put(1, 2);
map.put(2, 5);
Stored like:
1 → 2
2 → 5

 */
