package Code.game;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

//    Shadows of the Knight - Episode 1
public class Player1 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();


        int minW = 0, maxW = W - 1;
        int minH = 0, maxH = H - 1;
        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)


            switch (bombDir) {
                case "U":
                    maxH = Y0 - 1;
                    Y0 = (maxH + minH) / 2;
                    break;
                case "D":
                    minH = Y0 + 1;
                    Y0 = (maxH + minH) / 2;
                    break;
                // 一维的二分查找，如何实现呢
                case "R":
                    minW = X0 + 1;
                    X0 = (minW + maxW) / 2;
                    break;
                case "L":
                    maxW = X0 - 1;
                    X0 = (minW + maxW) / 2;
                    break;
                case "UR":
                    maxH = Y0 - 1;
                    Y0 = (maxH + minH) / 2;
                    minW = X0 + 1;
                    X0 = (minW + maxW) / 2;
                    break;
                case "DR":
                    minH = Y0 + 1;
                    Y0 = (maxH + minH) / 2;
                    minW = X0 + 1;
                    X0 = (minW + maxW) / 2;
                    break;
                case "DL":
                    minH = Y0 + 1;
                    Y0 = (maxH + minH) / 2;
                    maxW = X0 - 1;
                    X0 = (minW + maxW) / 2;
                    break;
                case "UL":
                    maxH = Y0 - 1;
                    Y0 = (maxH + minH) / 2;
                    maxW = X0 - 1;
                    X0 = (minW + maxW) / 2;
                    break;

            }
            System.out.println(X0 + " " + Y0);
        }
    }


}
