package HashMap.traps;

import java.util.HashSet;

/*
 No. 3
 Problem: Using HashMap when HashSet is enough
 Pattern: Correct Data Structure Choice
 Status: ✅ Trap Covered

 Input:
 [1,2,3,3]

 Output:
 Duplicate found

 Logic:
 1. If only existence check needed → use HashSet
 2. Map not required
*/

public class MapVsSetTrap03 {

    public static void main(String[] args) {

        int[] arr = {1,2,3,3};

        HashSet<Integer> set = new HashSet<>();

        for(int num : arr){

            if(set.contains(num)){
                System.out.println("Duplicate found: " + num);
                return;
            }

            set.add(num);
        }

        System.out.println("No duplicates");
    }
}