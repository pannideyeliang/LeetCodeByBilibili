package Code.map;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//这是一个通用的图算法解题模板
public class Graph {
    //    一个图是由点集和边集组成的
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}


class Node {
    public int value;
    public int in;
    public int out;
    //    该node的直接邻居
    public ArrayList<Node> nexts;
    //    node所属于的边
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}

class Edge {
    //    weight 表示权值
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

}