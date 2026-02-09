package Strings.medium;

/*
 MEDIUM
 No. 7
 Problem: Longest Common Prefix
 Pattern: String Comparison
 Status: ✅ Solved

 LeetCode similar:
 - 14 (Longest Common Prefix)

 Input:
 strs = ["flower", "flow", "flight"]

 Output:
 "fl"

 Explanation:
 The longest prefix shared by all strings is "fl".
 After that characters are different.
*/

public class LongestCommonPrefix07 {

    public static String longestCommonPrefix(String[] strs) {

        // edge case
        if (strs == null || strs.length == 0) {
            return "";
        }

        // take first string as reference
        String prefix = strs[0];

        // compare with remaining strings
        for (int i = 1; i < strs.length; i++) {

            // reduce prefix until match found
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1); //This removes last character. flower → flowe → flow → flo → fl

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(strs));
    }
}

/*
Idea:
Take first word as prefix
"flower"
Compare with next word
"flow"
Common part → "flow"
Compare with next word
"flight"
Reduce prefix step by step:
flow → flo → fl ✅

note:
"flow".indexOf("flower") → -1  // Not equal to 0 → enter while loop.
so reduce prefix
prefix = "flowe"
"flow".indexOf("flowe") → -1
so reduce again
prefix = "flow"
"flow".indexOf("flow") → 0 ✅

now current prefix is "flow"
"flight".indexOf("flow") → -1
Reduce
"flight".indexOf("flo") → -1
Reduce:
"flight".indexOf("fl") → 0 ✅

 */
