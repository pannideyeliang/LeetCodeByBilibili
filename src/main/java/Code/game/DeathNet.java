package Code.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class DeathNet {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> side = new HashMap<>();
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
//            存储所有的边是否被访问过
            map.put(N1 + Integer.toString(N2), 0);
            map.put(N2 + Integer.toString(N1), 0);
//            存储以某个边作为出发点的相邻点
            if (side.get(N1) != null) {
                side.get(N1).add(N2);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(N2);
                side.put(N1, list);
            }
            if (side.get(N2) != null) {
                side.get(N2).add(N1);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(N1);
                side.put(N2, list);
            }
        }
        int[] tar = new int[E];
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
//            存储要解决目标网关
            tar[i] = EI;
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Bobnet agent is positioned this turn
            for (int i = 0; i < side.get(SI).size(); i++) {
                if (map.get(Integer.toString(SI) + side.get(SI).get(i)) == 0) {
                    System.out.println(SI + " " + side.get(SI).get(i));
                    map.put(Integer.toString(SI) + side.get(SI).get(i), 1);
                    map.put(side.get(SI).get(i) + Integer.toString(SI), 1);
                }
            }
        }
    }
}
