//Given a directed graph, design an algorithm to find out whether there is a
// route between two nodes.

//Patterns: Graph Traversal
import java.util.*;

class RouteBetweenNodes {

    class Node {
        List<Node> adjacent = new LinkedList<>();
        String name;

        Node(String name) {
            this.name = name;
        }
    }

    boolean routeBetweenNodes(Node start, Node end){
        if (start == null || end == null) return false;
        if (start == end) return true;

        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()){
            Node n = queue.poll();

            for (Node neighbor : n.adjacent){
                if (!visited.contains(neighbor)){
                    if (neighbor == end) return true;

                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        RouteBetweenNodes obj = new RouteBetweenNodes();

        // Node'lar
        Node A = obj.new Node("A");
        Node B = obj.new Node("B");
        Node C = obj.new Node("C");
        Node D = obj.new Node("D");

        // Graph oluştur
        // A → B → C
        // A → D
        A.adjacent.add(B);
        B.adjacent.add(C);
        A.adjacent.add(D);

        // Testler
        System.out.println("A → C: " + obj.routeBetweenNodes(A, C)); // true
        System.out.println("B → D: " + obj.routeBetweenNodes(B, D)); // false
    }
}