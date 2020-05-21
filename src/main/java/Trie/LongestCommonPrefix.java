package Trie;

public class LongestCommonPrefix {
    public static int index;

    public static String getLongestCommonPrefix(TrieNode root) {
        String commonPrefix = "";

        TrieNode currentNode = root;
        index = 0;

        while (getChildrensCount(currentNode) == 1 && !currentNode.isEndOfWord) {
            commonPrefix += (char) ('a' + index);
            currentNode = currentNode.childrens[index];
        }

        return commonPrefix;
    }

    public static int getChildrensCount(TrieNode node) {
        int childrensCount = 0;

        for (int i = 0; i < TrieNode.ALPHABET_SIZE; i += 1) {
            if (node.childrens[i] != null) {
                childrensCount += 1;
                index = i;
            }
        }

        return childrensCount;
    }
    public static void main(String[] args) {
        String[] words = {"geeksforgeeks", "geeks", "geek", "geezer"};

        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i += 1) {
            TrieOperations.insert(root, words[i]);
        }

        System.out.println("longest common prefix: " + getLongestCommonPrefix(root));
    }
}
