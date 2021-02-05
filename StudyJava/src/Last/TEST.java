package Last;

import java.util.ArrayList;

public class TEST {
    public static void main(String[] args) {
        Node node = new Node(10);
        Node node2 = node;
        Node node1 = new Node(10);

        System.out.println(node == node2);
//        Assemble assemble = new Assemble();
//        assemble.assemble();


    }

    static class Node {
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
