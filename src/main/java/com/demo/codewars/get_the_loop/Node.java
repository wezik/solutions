package com.demo.codewars.get_the_loop;

import java.util.Objects;

public class Node {
    private final Node node;

    public Node(Node node) {
        this.node = node;
    }

    public Node getNext() {
        return node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node1 = (Node) o;
        return Objects.equals(node, node1.node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node);
    }
}
