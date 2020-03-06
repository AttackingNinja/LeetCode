package LeetCode116;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Solution {
    public Node connect(Node root) {
        Node node = root;
        while (node != null && node.left != null) {
            Node p = node;
            while (p != null) {
                p.left.next = p.right;
                if (p.next != null) {
                    p.right.next = p.next.left;
                }
                p = p.next;
            }
            node = node.left;
        }
        return root;
    }
}
