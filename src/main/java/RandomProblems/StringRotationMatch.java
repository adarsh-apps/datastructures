package RandomProblems;

public class StringRotationMatch {
    private static boolean isRotatedString(String actualString, String rotatedString) {
        String temp = actualString + actualString;

        System.out.println("Rotated no of times: " + temp.indexOf(rotatedString));
        return temp.contains(rotatedString);
    }

    public static void main(String[] a) {
        String actualString = "ABCD";
        String rotatedString = "CDAB";

        System.out.println(isRotatedString(actualString, rotatedString));
    }
}
