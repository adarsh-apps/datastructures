package Trie;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    // ONLY FOR LOWER ALPHABETS
    public static Integer ALPHABET_SIZE = 26;

    TrieNode[] childrens = new TrieNode[ALPHABET_SIZE];
    Boolean isEndOfWord;

    Integer wordCount; // Eg: each word occurance in a given text
    List<String> patternMatchingWords; // words list matching with given reg ex.

    Integer visitedCount;

    public TrieNode() {
        for (int i = 0; i < ALPHABET_SIZE; i += 1) {
            childrens[i] = null;
        }

        isEndOfWord = false;
        wordCount = 0;
        patternMatchingWords = new ArrayList<String>();

        visitedCount = 0;
    }

}
