package leetcode;

import java.util.*;

public class Problem3 {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> charIndex = new HashMap<>();
        int startIndex = 0, result = 0;
        for (int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);
            int currentIndex = charIndex.get(character) == null ? 0; charIndex.get(character);
            startIndex = Math.max(startIndex, currentIndex + 1);
            result = Math.max(result, index - startIndex + 1);
            charIndex.put(character, index);
        }
        return result;
    }

    public int _lengthOfLongestSubstring(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }
        Set<Character> charSet = new HashSet<>();
        int startIndex = 0, sentinel = 0, length = string.length(), result = 0;

        while(startIndex < length && sentinel < length) {
            char character = string.charAt(sentinel);
            if(!charSet.contains(character)) {
                charSet.add(character);
                sentinel++;
                result = Math.max(result, sentinel - startIndex);
            } else {
                charSet.remove(string.charAt(startIndex++));
            }
        }
        return result;
    }
}
