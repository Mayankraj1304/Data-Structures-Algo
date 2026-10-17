import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0 || s.length() == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;
        int sLen = s.length();

        if (sLen < totalLen) {
            return result;
        }

        // Frequency map of all words in the input array
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Iterate through each possible word length offset to cover all alignments
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> seen = new HashMap<>();
            int count = 0;

            while (right + wordLen <= sLen) {
                String subWord = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCount.containsKey(subWord)) {
                    seen.put(subWord, seen.getOrDefault(subWord, 0) + 1);
                    count++;

                    // If we have more occurrences of subWord than allowed, shrink from the left
                    while (seen.get(subWord) > wordCount.get(subWord)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // If all words match, record the starting index
                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    // Reset the window if an invalid word is encountered
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}