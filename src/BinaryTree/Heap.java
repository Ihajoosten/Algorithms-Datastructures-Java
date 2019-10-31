package BinaryTree;

public class Heap<T extends Comparable<T>> {

    protected BNode<T> root;
    private int alternator = 0;

    public Heap() {
        // deliberately empty
    }

    public T findMax() {
        if(root != null) {
            return root.getUserObject();
        } else
            return null;
    }

    public void insert(T element) {
        root = insertRec(root, element);
    }

    // recursive method
    BNode<T> insertRec(BNode<T> currentNode, T element) {

        // empty node has been found, so use it
        if (currentNode == null) {
            currentNode = new BNode<T>(element);
            return currentNode;
        }

        // otherwise, recur down the tree
        if (element.compareTo(currentNode.getUserObject()) > 0) {
            // replace current node
            BNode<T> newNode = new BNode<T>(element);
            // alternator to balance tree, although this was not a requirement
            if(alternator++ % 2 == 0) newNode.setRightChild(currentNode);
            else newNode.setLeftChild(currentNode);
            return newNode;
        } else {
            // alternator to balance tree, although this was not a requirement
            if(alternator++ % 2 == 0) currentNode.setRightChild(insertRec(currentNode.getRightChild(), element));
            else currentNode.setLeftChild(insertRec(currentNode.getRightChild(), element));
            return currentNode;
        }
    }


}
