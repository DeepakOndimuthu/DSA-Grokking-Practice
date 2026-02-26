package HashMap.medium;

import java.util.*;

/*
 MEDIUM
 Problem: Group Anagrams
 Pattern: HashMap + Sorted String Key
 Status: ✅ Solved

 LeetCode:
 - 49 (Group Anagrams)

 Input:
 ["eat","tea","tan","ate","nat","bat"]

 Output:
 [
   ["eat","tea","ate"],
   ["tan","nat"],
   ["bat"]
 ]
*/

public class GroupAnagrams07 {

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            map.putIfAbsent(sortedWord, new ArrayList<>());
            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(groupAnagrams(strs));
    }
}

/*
1️⃣ word = "eat"
chars = ['e','a','t']
sort → ['a','e','t']
sortedWord = "aet"

Map after putIfAbsent:
"aet" → []
After add:
"aet" → ["eat"]

2️⃣ word = "tea"
chars = ['t','e','a']
sort → ['a','e','t']
sortedWord = "aet"

"aet" already exists.
So only add:
"aet" → ["eat","tea"]

3️⃣ word = "tan"
chars = ['t','a','n']
sort → ['a','n','t']
sortedWord = "ant"
New key.
"ant" → ["tan"]

4️⃣ word = "ate"
Sorted → "aet"
"aet" → ["eat","tea","ate"]

5️⃣ word = "nat"
Sorted → "ant"
"ant" → ["tan","nat"]

6️⃣ word = "bat"
Sorted → "abt"
"abt" → ["bat"]

Final Map
"aet" → ["eat","tea","ate"]
"ant" → ["tan","nat"]
"abt" → ["bat"]
 */