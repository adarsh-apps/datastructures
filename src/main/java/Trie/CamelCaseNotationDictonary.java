package Trie;

public class CamelCaseNotationDictonary {
    public static void insert(TrieNode root, String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i += 1) {
            if (Character.isLowerCase(word.charAt(i)))
                continue;

            int charIndex = word.charAt(i) - 'A';

            if (currentNode.childrens[charIndex] == null)
                currentNode.childrens[charIndex] = new TrieNode();

            currentNode = currentNode.childrens[charIndex];
        }

        currentNode.isEndOfWord = true;
        currentNode.patternMatchingWords.add(word);
    }

    public static boolean search(TrieNode root, String pattern) {
        TrieNode currentNode = root;

        for (int i = 0; i < pattern.length(); i += 1) {
            int charIndex = pattern.charAt(i) - 'A';

            if (currentNode.childrens[charIndex] == null)
                return false;

            currentNode = currentNode.childrens[charIndex];
        }

        printWords(currentNode);
        return true;
    }

    public static void printWords(TrieNode trieNode) {
        if (trieNode.isEndOfWord) {
            for (String word : trieNode.patternMatchingWords)
                System.out.println(word);
        }

        for (int i = 0; i < TrieNode.ALPHABET_SIZE; i += 1) {
            if (trieNode.childrens[i] != null) {
                printWords(trieNode.childrens[i]);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"Hi", "Hello",
                "HelloWorld", "HiTech", "HiGeek",
                "HiTechWorld", "HiTechCity",
                "HiTechLab"};

        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i += 1)
            insert(root, words[i]);

        String pattern = "HTL";

        if (!search(root, pattern))
            System.out.println("no matching words found");
    }
}
