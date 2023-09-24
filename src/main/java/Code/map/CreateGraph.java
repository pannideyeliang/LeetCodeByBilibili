package Code.map;

import java.util.*;

// 转为图模板的接口函数（创建图的函数）
public class CreateGraph {

    //    整一个main函数测试一下
    public static void main(String[] args) {
        Integer[][] map = {{1, 2, 1}, {1, 4, 1}, {1, 3, 1}, {2, 4, 1}, {4, 5, 1}, {4, 3, 1}};
        Graph graph = CreateMap(map);
        Node node = graph.nodes.get(1) ;
        System.out.println("++++++++++bfs++++++++++");
        bfs(node);
        System.out.println("++++++++++dfs++++++++++");
        dfs(node);
    }

    public static Graph CreateMap(Integer[][] matrix) {
//        matrix[0][0]  头 matrix[0][1]  尾  matrix[0][2]权重
        Graph graph = new Graph();
        for (Integer[] integers : matrix) {
            Integer from = integers[0];
            Integer to = integers[1];
            Integer Weight = integers[2];

            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }

            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
//            创建边
            Edge edge = new Edge(Weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;
    }

    //    下面进行宽度优先（广度优先）遍历
    public static void bfs(Node node) {
//        广度优先遍历是截取队列实现的
        if (node == null) {
            return;
        }
//        保证宽度优先
        Queue<Node> queue = new LinkedList<>();
//        保证已经访问过的不会再访问
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node n : cur.nexts) {
//                确保之前访问过的点不会重新进入队列当中
                if (!set.contains(n)) {
                    set.add(n);
                    queue.add(n);
                }
            }
        }
    }

    //    下面进行深度优先遍历
//    深度优先遍历是借助一个栈
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
//        先把出发点加进去
        stack.push(node);
        set.add(node);
//            对当前遍历的节点进行处理
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node n : cur.nexts) {
                if (!set.contains(n)) {
//                    这个把根弹进去非常重要，当路走不通的时候可以去走另外一 条路
                    stack.push(cur);
                    stack.push(n);
                    set.add(n);
//                    对下一个进行处理，但是后面的不看了
                    System.out.println(n.value);
//                    记住，这样写的好处就是，使用的栈从底部到顶部所保存的就是深度优先遍历的路径
                    break;
                }
            }
        }
    }

}





























