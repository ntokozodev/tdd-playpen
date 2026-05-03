package dev.ntokozo.kata.trees;

public class TreeCalculator {
    public int sumOfEvenNodes(Node node) {
        if (node == null)
            return 0;

        if (node.value % 2 == 0)
            return node.value + sumOfEvenNodes(node.left) + sumOfEvenNodes(node.right);

        return sumOfEvenNodes(node.left) + sumOfEvenNodes(node.right);
    }
}
