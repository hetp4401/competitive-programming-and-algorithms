package recursion;

import java.util.Scanner;

public class sudoku {

    static boolean[][] box = new boolean[9][9];
    static boolean[][] row = new boolean[9][9];
    static boolean[][] col = new boolean[9][9];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String sudoku = "";
        while (sudoku.length() < 81)
            sudoku += s.nextLine();

        char[][] b = new char[9][9];
        for (int i = 0; i < 9; i++)
            b[i] = sudoku.substring(i * 9, (i + 1) * 9).toCharArray();

        for (int p = 0; p < 81; p++) {
            if (b[p / 9][p % 9] != '.') {
                char i = b[p / 9][p % 9];
                row[p / 9][i - 49] = true;
                col[p % 9][i - 49] = true;
                box[3 * ((p / 9) / 3) + ((p % 9) / 3)][i - 49] = true;
            }
        }

        solve(0, b);

        for (char[] i : b)
            System.out.println(String.valueOf(i));
    }

    public static boolean solve(int p, char[][] b) {
        for (; p < 81; p++) {
            int y = p / 9;
            int x = p % 9;
            if (b[p / 9][p % 9] != '.')
                continue;

            for (char i = '1'; i <= '9'; i++) {
                if (row[y][i - 49] || col[x][i - 49] || box[3 * ((y) / 3) + ((x) / 3)][i - 49])
                    continue;

                b[p / 9][p % 9] = i;
                row[y][i - 49] = col[x][i - 49] = box[3 * ((y) / 3) + ((x) / 3)][i - 49] = true;

                if (solve(p + 1, b))
                    return true;

                b[p / 9][p % 9] = '.';
                row[y][i - 49] = col[x][i - 49] = box[3 * ((y) / 3) + ((x) / 3)][i - 49] = false;
            }
            return false;
        }
        return true;
    }
}

/*
 * * 9.7..563. .45..12.9
 * 
 * 124576893 796328541 538419762 671893425 259164387 483752916 862937154
 * 917245638 345681279
 * 
 * 9...28.575...1
 * 
 * 
 * 
 * 916328457 574619283 832574961 687241395 295736148 341895726 469187532
 * 128953674 753462819
 */
