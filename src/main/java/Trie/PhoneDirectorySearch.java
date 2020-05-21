package Trie;

// contacts search in char level
public class PhoneDirectorySearch {
    public static void printContacts(TrieNode node, String prefix) {
        if (node.isEndOfWord)
            System.out.println(prefix);

        for (int i = 0; i < TrieNode.ALPHABET_SIZE; i += 1) {
            if (node.childrens[i] != null) {
                char ch = (char)(i + 'a');
                printContacts(node.childrens[i], prefix + ch);
            }
        }
    }

    public static void printCharWiseContacts(TrieNode trieNode, String prefix) {
        if (trieNode == null)
            System.out.println("No contacts found with given prefix");

        TrieNode prevNode = trieNode;
        int i;

        for (i = 1; i <= prefix.length(); i += 1) {
            int charIndex = prefix.charAt(i - 1) - 'a';

            TrieNode currentNode = prevNode.childrens[charIndex];

            if (currentNode == null) {
                System.out.println("No contcats found with prefix : " + prefix.substring(0, i));
                break;
            } else {
                System.out.println("Contcats with prefix : " + prefix.substring(0, i));
                printContacts(currentNode, prefix.substring(0, i));
            }

            prevNode = currentNode;
        }

        i += 1;

        for (; i <= prefix.length(); i += 1) {
            System.out.println("No contcats found with prefix : " + prefix.substring(0, i));
        }
    }

    public static void main(String[] args) {
        String[] contacts = {"gforgeeks", "geeksquiz"};
        String prefix = "gekk";

        TrieNode root = new TrieNode();

        for (int i = 0; i < contacts.length; i += 1) {
            TrieOperations.insert(root, contacts[i]);
        }

        printCharWiseContacts(root, prefix);
    }
}
