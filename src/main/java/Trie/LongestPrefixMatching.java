package Trie;

public class LongestPrefixMatching {
    public static String getLongestPrefix(TrieNode trieNode, String word) {
        int charIndex;
        int matchingIndex = 0;
        int longestPrefixLength = 0;
        TrieNode currentNode = trieNode;

        for (int i = 0; i < word.length(); i += 1) {
            charIndex = word.charAt(i) - 'a';

            if (currentNode.childrens[charIndex] != null) {
                matchingIndex += 1;

                if (currentNode.childrens[charIndex].isEndOfWord) {
                    longestPrefixLength = matchingIndex;
                }
            }

            currentNode = currentNode.childrens[charIndex];

            if (currentNode == null)
                break;
        }

        return word.substring(0, longestPrefixLength);
    }

    public static void main(String[] args) {
        String[] words = {"are", "area", "base", "cat", "cater", "children", "basement"};

        TrieNode trieNode = new TrieNode();

        for (int i = 0; i < words.length; i += 1)
            TrieOperations.insert(trieNode, words[i]);

        System.out.println("longest prefix matching string: " + getLongestPrefix(trieNode, "basemexy"));
        System.out.println("longest prefix matching string: " + getLongestPrefix(trieNode, "caterer"));
        System.out.println("longest prefix matching string: " + getLongestPrefix(trieNode, "child"));
    }
}
