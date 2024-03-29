package com.demo.codewars.get_the_loop;

/*
You are given a node that is the beginning of a linked list. This list always contains a tail and a loop. Your objective is to determine the length of the loop.

For example in the following picture the tail's size is 3 and the loop size is 12:


// Use the `getNext()` method to get the following node.
node.getNext()
Note: do NOT mutate the nodes!

Thanks to shadchnev, I broke all of the methods from the Hash class.

Don't miss dmitry's article in the discussion after you pass the Kata !!
 */

import java.util.HashMap;
import java.util.Map;

public class LoopInspector {

    public int loopSize(Node node) {
        Node currNode = node;
        Map<Node,Integer> nodes = new HashMap<>();
        int i=0;
        for (; !nodes.containsKey(currNode); i++) {
            nodes.put(currNode, i);
            currNode = currNode.getNext();
        }
        return i - nodes.get(currNode);
    }

}
