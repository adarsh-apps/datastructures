package Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        //top, left, bottom, right
        int [] rowMap= {-1, 0, 0, 1};
        int [] columnMap = {0, -1, 1, 0};

        int count = 0;
        boolean changed = false;

        while(true) {
            int[][] visited = new int[rows][columns];

            for (int i = 0; i < rows; i += 1) {
                for (int j = 0; j < columns; j += 1) {
                    for (int k = 0; k < rowMap.length; k += 1) {
                        if (grid[i][j] == 2 && visited[i][j] == 0) {
                            if (issafe(i + rowMap[k], j + columnMap[k], rows, columns) && grid[i + rowMap[k]][j + columnMap[k]] == 1) {
                                grid[i + rowMap[k]][j + columnMap[k]] = 2;
                                visited[i + rowMap[k]][j + columnMap[k]] = 1;
                                changed = true;
                            }
                        }
                    }

                    visited[i][j] = 1;
                }
            }

            if (!changed) {
                break;
            }

            changed = false;
            count += 1;
        }

        for (int i = 0; i < rows; i += 1) {
            for (int j = 0; j < columns; j += 1) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return count;
    }

    public static boolean issafe(int i, int j, int rows, int colummns) {
        if (i >= 0 && i < rows && j >= 0 && j < colummns)
            return true;
        return false;
    }

    static class Index {
        int x;
        int y;

        public Index() {

        }

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int orangesRottingUsingQueue(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        int count = 0;

        Queue<Index> queue = new LinkedList<Index>();

        for (int i = 0; i < rows; i += 1) {
            for (int j = 0; j < columns; j += 1) {
                if (grid[i][j] == 2) {
                    queue.add(new Index(i, j));
                }
            }
        }

        queue.add(new Index(-1, -1));
        boolean changed  = false;

        while (!queue.isEmpty()) {
            Index index = queue.remove();

            if (issafe(index.x, index.y + 1, rows, columns)) {
                if (grid[index.x][index.y + 1] == 1) {
                    grid[index.x][index.y + 1] = 2;
                    queue.add(new Index(index.x, index.y + 1));
                    changed = true;
                }
            }

            if (issafe(index.x, index.y - 1, rows, columns)) {
                if (grid[index.x][index.y - 1] == 1) {
                    grid[index.x][index.y - 1] = 2;
                    queue.add(new Index(index.x, index.y - 1));
                    changed = true;
                }
            }

            if (issafe(index.x + 1, index.y, rows, columns)) {
                if (grid[index.x + 1][index.y] == 1) {
                    grid[index.x + 1][index.y] = 2;
                    queue.add(new Index(index.x + 1, index.y));
                    changed = true;
                }
            }

            if (issafe(index.x - 1, index.y, rows, columns)) {
                if (grid[index.x - 1][index.y] == 1) {
                    grid[index.x - 1][index.y] = 2;
                    queue.add(new Index(index.x - 1, index.y));
                    changed = true;
                }
            }

            if (index.x == -1 && index.y == -1 && changed) {
                queue.add(new Index(-1, -1));
                count += 1;
                changed = false;
            }
        }

        for (int i = 0; i < rows; i += 1) {
            for (int j = 0; j < columns; j += 1) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return count;
    }

    public static void main(String[] a) {
        int grid[][] = { { 2, 1, 0, 2, 1 },
                         { 1, 0, 1, 1, 1 },
                         { 1, 1, 0, 0, 1 } };

//        time complexity O(max(R,C) * R *C).
//        space complexity is O(R *C).
//        int count = orangesRotting(grid);

//        time complexity is O(R *C).
//        space complexity is O(R *C).
        int count = orangesRottingUsingQueue(grid);

        if (count >= 0) {
            System.out.println("Required time to rot all oranges " + count);
        } else {
            System.out.println("Not possible to rot all oranges");
        }
    }

}
//    Minimum time required to fill the entire matrix with 1’s
//    Given a matrix of size N consisting of 0‘s and 1‘s, the task is to find the minimum time required
//    to fill the entire matrix with 1‘s. Every 1 at an instant in the matrix, can convert all 0‘s to 1
//    in its eight adjacent cells,i.e. a 1 present at (i,j) can convert all 0‘s to 1 at positions
//    (i, j-1), (i, j+1), (i-1, j), (i+1, j), (i-1, j-1), (i-1, j+1), (i+1, j-1), (i+1, j+1).

//    Input: N = 3, mtrx[][] = {{1,0,0},{0,0,1},{0,0,0}}
//        Output: 2
//        Explanation:
//        Initially the matrix appears to be
//        1, 0, 0
//        0, 0, 1
//        0, 0, 0
//        After the first instant of time, the new matrix is
//        1, 1, 1
//        1, 1, 1
//        0, 1, 1
//        After the 2nd instant the remaining 0 is converted to 1.


