package Trie;
// ONLY FOR LOWER ALPHABETS
public class TrieOperations {
    public static void insert(TrieNode root, String word) {
        int level, length;
        length = word.length();
        TrieNode currentNode = root;

        int charIndex;

        for (level = 0; level < length; level += 1) {
            charIndex = word.charAt(level) - 'a';

            if (currentNode.childrens[charIndex] == null) {
                currentNode.childrens[charIndex] = new TrieNode();
            }

            currentNode = currentNode.childrens[charIndex];
        }

        currentNode.isEndOfWord = true;
    }

    public static void delete(TrieNode root, String word) {

    }

    public static boolean isExist(TrieNode root, String word) {
        int length = word.length();
        int level;
        int charIndex;
        TrieNode currentNode = root;

        for (level = 0; level < length; level += 1) {
            charIndex = word.charAt(level) - 'a';

            if (currentNode.childrens[charIndex] == null)
                return false;

            currentNode = currentNode.childrens[charIndex];
        }

        return currentNode.isEndOfWord;
    }

    public static boolean isEmptyNode(TrieNode trieNode) {
        for (int i = 0; i < TrieNode.ALPHABET_SIZE; i += 1) {
            if (trieNode.childrens[i] != null)
                return false;
        }

        return false;
    }

    public static TrieNode delete(TrieNode root, String word, int depth) {
        if (root == null)
            return null;

        if (depth == word.length()) {
            if (root.isEndOfWord)
                root.isEndOfWord = false;

            if (isEmptyNode(root))
                root = null;

            return root;
        }

        int charIndex = word.charAt(depth) - 'a';

        root.childrens[charIndex] = delete(root.childrens[charIndex], word, depth + 1);

        if (isEmptyNode(root) && !root.isEndOfWord) {
            root = null;
        }

        return root;
    }

    public static void main(String[] args) {
        String[] names = {"adarsh", "anusha", "namsani", "varma", "arjun", "anunidhi", "namsani"};
        TrieNode root = new TrieNode();

        for (int i = 0; i < names.length; i += 1) {
            insert(root, names[i]);
        }

        System.out.println("adarsh: " + isExist(root, "adarsh"));
        System.out.println("adarshn: " + isExist(root, "adarshn"));
        System.out.println("anusha: " + isExist(root, "anusha"));
        root = delete(root, "adarsh", 0);
        System.out.println("adarsh: " + isExist(root, "adarsh"));
    }
}

//    Trie is an efficient information reTrieval data structure. Using Trie, search complexities can be brought to
//    optimal limit (key length). If we store keys in binary search tree, a well balanced BST will need time
//    proportional to M * log N, where M is maximum string length and N is number of keys in tree. Using Trie,
//    we can search the key in O(M) time. However the penalty is on Trie storage requirements
