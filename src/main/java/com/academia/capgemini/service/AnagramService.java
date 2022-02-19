package com.academia.capgemini.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;

@Service
public class AnagramService {
    public int countAnagramPairs(String word) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                char[] wordSubstring = word.substring(i, j + 1).toCharArray();
                Arrays.sort(wordSubstring);
                String substringSorted = new String(wordSubstring);
                if (map.containsKey(substringSorted)) {
                    map.put(substringSorted, map.get(substringSorted) + 1);
                } else {
                    map.put(substringSorted, 1);
                }
            }
        }
        int anagramPairCount = 0;
        for (String key : map.keySet()) {
            int n = map.get(key);
            anagramPairCount += (n * (n - 1)) / 2;
        }
        return anagramPairCount;
    }
}
