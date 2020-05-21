//String pattern matching algorithm with o(n) time complexity.
//we can achive this by using naive approach. but it takes o(n^2) time.

public class KMPPatternMatching {
    private static void computeLPSArray(String pattern, int[] lps) {
        int length = 0;
        int i = 1;

        lps[0] = 0;

//        For the pattern “AABAACAABAA”,
//        lps[] is [0, 1, 0, 1, 2, 0, 1, 2, 3, 4, 5]

        while(i < pattern.length()) {
            if (pattern.charAt(length) == pattern.charAt(i)) {
                length += 1;
                lps[i] = length;
                i += 1;
            } else if (length != 0) {
                length -= 1;
            } else {
                lps[i] = length;
                i += 1;
            }
        }
    }

    public static void KMPSearch(String string, String pattern, int[] lps) {
        int i = 0;
        int j = 0;

        while (i < string.length()) {
            if (string.charAt(i) == pattern.charAt(j)) {
                i += 1;
                j += 1;

                if (j == pattern.length()) {
                    System.out.println("Pattern match found at index : " + (i - j));
                    j = 0;
                }
            } else if (j == 0) {
                i += 1;
            } else {
                j = lps[j - 1];
            }
        }
    }

    public static void main(String[] a) {
        String string = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        int[] lps = new int[pattern.length()];
        computeLPSArray(pattern, lps);

//        for (int i = 0; i < pattern.length(); i += 1)
//            System.out.println(lps[i]);

        KMPSearch(string, pattern, lps);
    }
}
