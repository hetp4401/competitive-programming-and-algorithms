package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class floorplan {

    static int rows, columns;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int tiles = s.nextInt();

        rows = s.nextInt();
        columns = s.nextInt();
        s.nextLine();

        String[][] grid = new String[rows][columns];
        for (int r = 0; r < rows; r++) {
            String row = s.nextLine();
            for (int c = 0; c < columns; c++) {
                grid[r][c] = row.charAt(c) + "";
            }
        }

        ArrayList<Integer> li = new ArrayList<Integer>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (grid[r][c].equals(".")) {
                    li.add(delete(r, c, grid));
                }
            }
        }

        Collections.sort(li);

        int i = li.size() - 1;
        for (; i >= 0 && tiles - li.get(i) >= 0; i--) {
            tiles -= li.get(i);
        }

        String rooms = li.size() - i - 1 == 1 ? " room, " : " rooms, ";
        System.out.println((li.size() - 1 - i) + rooms + tiles + " square metre(s) left over");
    }

    public static int delete(int y, int x, String[][] grid) {
        if (y < rows && y >= 0 && x < columns && x >= 0 && grid[y][x].equals(".")) {
            grid[y][x] = "I";
            return delete(y - 1, x, grid) + delete(y + 1, x, grid) + delete(y, x + 1, grid) + delete(y, x - 1, grid)
                    + 1;
        }
        return 0;
    }
}


/*
Problem J5/S3: Floor Plan
The floor plan of a house shows rooms separated by walls. This floor plan can be transferred to a grid using the character "I" for walls and "." for room space. Doorways are not shown. Each "I" or "." character occupies one square metre.

illustration of sample input

In this diagram there are six rooms.

You have been given the floor plan of a house and a supply of hardwood flooring. You are to determine how many rooms will have the flooring installed if you start installing the floor in the largest room first and move to the next largest room, and so on. You may not skip over any room, and you must stop when you do not have enough wood for the next room. Output the number of rooms that can have hardwood installed, and how many square metres of flooring are left over.

No room will be larger than 64 square metres.

The first line of the input contains the number of square metres of flooring you have. The second line in the input contains an integer r from 1 to 25 that represents the number of rows in the grid. The third line contains an integer c from 1 to 25 that represents the number of columns in the grid. The remaining r lines contain c characters of grid data.

Sample Input 1
105
14
16
IIIIIIIIIIIIIIII
I......I.......I
I......III.....I
I........I.....I
I........IIIIIII
IIIIIIIIII.....I
I.I......I.....I
III..III.I.....I
I....I.IIIII...I
I....I.....III.I
I....I.......I.I
I....I.....III.I
I....I.....I...I
IIIIIIIIIIIIIIII

Sample Output 1
4 rooms, 1 square metre(s) left over

Sample Input 2
13
2
3
.I.
.I.

Sample Output 2
2 rooms, 9 square metre(s) left over

*/