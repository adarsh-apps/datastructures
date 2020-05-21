package Trie;

public class ShortestUniquePrefix {
    public static void insert(TrieNode root, String word) {
        int length = word.length();
        int charIndex;
        TrieNode currentNode = root;

        for (int level = 0; level < length; level += 1) {
            charIndex = word.charAt(level) - 'a';

            if (currentNode.childrens[charIndex] == null) {
                currentNode.childrens[charIndex] = new TrieNode();
            }

            currentNode.childrens[charIndex].visitedCount = currentNode.childrens[charIndex].visitedCount += 1;

            currentNode = currentNode.childrens[charIndex];
        }

        currentNode.isEndOfWord = true;
    }

    public static void printShortestUniquePrefix(TrieNode root, String word) {
        if (root == null)
            return;

        int length = word.length();
        TrieNode currentNode = root;
        int currentIndex = 0;
        int charIndex;

        while (currentIndex < length && !currentNode.isEndOfWord) {
            charIndex = word.charAt(currentIndex) - 'a';
            currentIndex += 1;

            currentNode = currentNode.childrens[charIndex];

            if (currentNode == null || currentNode.visitedCount == 1)
                break;
        }

        System.out.println("unique prefix of " + word + " : " + word.substring(0, currentIndex));
    }

    public static void main(String[] args) {
        String[] words = {"zebra", "dog", "duck", "dove"};
        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i += 1)
            insert(root, words[i]);

        printShortestUniquePrefix(root, "zebra");
        printShortestUniquePrefix(root, "dog");
        printShortestUniquePrefix(root, "duck");
        printShortestUniquePrefix(root, "dove");
    }
}
