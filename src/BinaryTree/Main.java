package BinaryTree;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        heap.insert(23);
        heap.insert(15);
        heap.insert(46);
        heap.insert(46);
        heap.insert(55);
        heap.insert(5);
        ArrayList<String> preOrderWithDepth = heap.root.preOrderWithDepth();
        preOrderWithDepth.sort(String::compareToIgnoreCase);
        for (String s: preOrderWithDepth) {
            System.out.println("at depth " + s);
        }

        System.out.println("FindMax returns: " + heap.findMax());
    }

}
