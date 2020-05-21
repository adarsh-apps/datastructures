package Matrix;

public class NoOfIslands {
    static int findNoOfIslands(int[][] matrix, int rows, int columns) {
        int [][] visited = new int[rows][columns];
        return findNoOfIslands(matrix, visited, rows, columns);
    }

    static void changeToVisited(int[][] matrix, int[][] visited, int row, int column, int totalRows, int totalColumns) {
        if (row < 0 || column < 0 || row > totalRows - 1 || column > totalColumns - 1 || visited[row][column] == 1 || matrix[row][column] != 1)
            return;

        visited[row][column] = 1;

        // diagonal
//        int [] rowMap= {-1, -1, -1, 0, 0, 1, 1, 1};
//        int [] columnMap = {-1, 0, 1, -1, 1, -1, 0, 1};

        //top, left, bottom, right
        int [] rowMap= {-1, 0, 0, 1};
        int [] columnMap = {0, -1, 1, 0};

        for (int i = 0; i < rowMap.length; i += 1) {
            changeToVisited(matrix, visited, row + rowMap[i], column + columnMap[i], totalRows, totalColumns);
        }
    }

    static int findNoOfIslands(int[][] matrix, int[][] visited, int rows, int columns) {
        int count = 0;

        for (int i = 0; i < rows; i += 1) {
            for (int j = 0; j < columns; j += 1) {
                if (matrix[i][j] == 1 && visited[i][j] != 1) {
                    changeToVisited(matrix, visited, i, j, rows, columns);
                    count += 1;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0, 0, 0},
                          {0, 1, 0, 0, 0},
                          {1, 0, 0, 0, 1},
                          {0, 0, 0, 0, 0},
                          {1,  1, 0,0, 1}};

        int noOfIslands = findNoOfIslands(matrix, 5, 5);

        System.out.println("No of islands: " + noOfIslands);
    }
}