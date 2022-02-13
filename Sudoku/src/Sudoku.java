import java.util.Scanner;

public class Sudoku {

  public static void main(String[] args) {

    int[][] grid = readSolution();

    System.out.println(isValid(grid) ? "Valid solution" : "Invalid solution");
  }

  public static int[][] readSolution() {

    Scanner input = new Scanner(System.in);

    System.out.println("Enter a Sudoku puzzle solution:");
    int[][] grid = new int[16][16];
    for (int i = 0; i < 16; i++)
      for (int j = 0; j < 16; j++)
        grid[i][j] = input.nextInt();

    return grid;
  }

  public static boolean isValid(int[][] grid) {

    for (int i = 0; i < 16; i++)
      if (!is1To16(grid[i]))
        return false;

    for (int j = 0; j < 16; j++) {

      int[] column = new int[16];
      for (int i = 0; i < 16; i++) {
        column[i] = grid[i][j];
      }

      if (!is1To16(column))
        return false;
    }

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {

        int k = 0;
        int[] list = new int[16];
        for (int row = i * 4; row < i * 4 + 4; row++)
          for (int column = j * 4; column < j * 4 + 4; column++)
            list[k++] = grid[row][column];

        if (!is1To16(list))
          return false;
      }
    }

    return true;
  }

  public static boolean is1To16(int[] list) {
    int[] temp = new int[list.length];
    System.arraycopy(list, 0, temp, 0, list.length);

    java.util.Arrays.sort(temp);

    for (int i = 0; i < 16; i++)
      if (temp[i] != i + 1)
        return false;

    return true;

  }

}
