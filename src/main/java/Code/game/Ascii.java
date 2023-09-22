package Code.game;

import java.util.Scanner;

public class Ascii {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        String[] store = new String[H];
        String T = in.nextLine();
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            store[i] = ROW;
        }

        char[] chars = T.toCharArray();
        int[] tmp = new int[chars.length];
        int index = 0;
        for (char c : chars) {
            if (Character.isLetter(c)) {
                tmp[index++] = Character.toUpperCase(c) - 'A';
            } else {
                tmp[index++] = 26;
            }
        }
        for (int i = 0; i < H; i++) {
            StringBuilder res = new StringBuilder();
            for (int j = 0; j < tmp.length; j++) {
                res.append(store[i].substring(tmp[j]*L,tmp[j]*L+L));
            }
            System.out.println(res.toString());
        }
    }
}
