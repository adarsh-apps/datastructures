package Matrix;

public class NoOfWaysToReachTopLeftToBottomRight {
    //iterative
    public static int noOfWaysToReachFromTopLeftToBottomRight(int r, int c) {
        int[][] noOfWaysInEachLevel = new int[r][c];

        for (int i = 0; i < r; i += 1) {
            noOfWaysInEachLevel[i][0] = 1;
        }

        for (int i = 0; i < c; i += 1) {
            noOfWaysInEachLevel[0][i] = 1;
        }

        for (int i = 1; i < r; i += 1) {
            for (int j = 1; j < c; j += 1) {
                noOfWaysInEachLevel[i][j] = noOfWaysInEachLevel[i - 1][j] + noOfWaysInEachLevel[i][j - 1];
            }
        }

        return noOfWaysInEachLevel[r - 1][c - 1];
    }

    //recursive
    public static int noOfWaysToReachFromTopLeftToBottomRightRecursive(int r, int c) {
        if (r == 1 || c == 1)
            return 1;

        return noOfWaysToReachFromTopLeftToBottomRightRecursive(r - 1, c) + noOfWaysToReachFromTopLeftToBottomRightRecursive(r, c - 1);
    }

    public static int noOfWaysToReachFromTopLeftToBottomRightMemoryEfficient(int r, int c) {
        int[] noOfWays = new int[c];

        noOfWays[0] = 1;

        if (r == 1 || c == 1)
            return 1;

        for (int i = 0; i < r; i += 1)
            for (int j = 1; j < c; j += 1)
                noOfWays[j] = noOfWays[j] + noOfWays[j - 1];

        return noOfWays[c - 1];
    }

//    https://www.youtube.com/watch?v=ItjZdu6jEMs
    public static int minCostToReachFromTopLeftToBottomRight(int[][] matrix, int r, int c) {
        int[][] noOfWaysInEachLevel = new int[r][c];

        noOfWaysInEachLevel[0][0] = matrix[0][0];

        for (int i = 1; i < r; i += 1)
            noOfWaysInEachLevel[0][i] = matrix[0][i] + noOfWaysInEachLevel[0][i - 1];

        for (int i = 1; i < c; i += 1)
            noOfWaysInEachLevel[i][0] = matrix[i][0] + noOfWaysInEachLevel[i - 1][0];

        for (int i = 1; i < r; i += 1) {
            for (int j = 1; j < c; j += 1) {

                noOfWaysInEachLevel[i][j] += matrix[i][j] + Math.min(noOfWaysInEachLevel[i - 1][j], noOfWaysInEachLevel[i][j - 1]);
            }
        }

        return noOfWaysInEachLevel[r - 1][c - 1];
    }

    public static int minCostToReachFromTopLeftToBottomRightAllSidesAllowed(int[][] matrix, int r, int c) {
//        int[][] noOfWaysInEachLevel = new int[r][c];
//
//        noOfWaysInEachLevel[0][0] = matrix[0][0];
//
//        for (int i = 1; i < r; i += 1)
//            noOfWaysInEachLevel[0][i] = matrix[0][i] + noOfWaysInEachLevel[0][i - 1];
//
//        for (int i = 1; i < c; i += 1)
//            noOfWaysInEachLevel[i][0] = matrix[i][0] + noOfWaysInEachLevel[i - 1][0];
//
//        for (int i = 1; i < r; i += 1) {
//            for (int j = 1; j < c; j += 1) {
//
//                noOfWaysInEachLevel[i][j] += matrix[i][j] + Math.min(noOfWaysInEachLevel[i - 1][j], noOfWaysInEachLevel[i][j - 1]);
//            }
//        }
//
//        return noOfWaysInEachLevel[r - 1][c - 1];
        return 0;
    }

    public static void main(String[] a) {
        System.out.println("no of ways to reach from top left to bottom right(consider all) (iterative) : " + noOfWaysToReachFromTopLeftToBottomRight(4, 5));
        System.out.println("no of ways to reach from top left to bottom right(consider all) (recursive) : " + noOfWaysToReachFromTopLeftToBottomRightRecursive(4, 5));
        System.out.println("no of ways to reach from top left to bottom right(memory efficient) : " + noOfWaysToReachFromTopLeftToBottomRightMemoryEfficient(4, 5));

        int[][] matrix = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println("min cost to reach from top left to bottom right : " + minCostToReachFromTopLeftToBottomRight(matrix, 3, 3));

        int[][] matrix2 = {{31, 100, 65, 12, 18}, {10, 13, 47, 157, 6}, {100, 113, 174, 11, 33}, {88, 124, 41, 20, 140}, {99, 32, 111, 41, 20}};
    }
}


//    Note the count can also be calculated using the formula (m-1 + n-1)!/(m-1)!(n-1)!.(Lattice Path)