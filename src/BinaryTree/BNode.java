package BinaryTree;

import java.util.*;

public class BNode<E> {
    private BNode<E> parent, leftChild, rightChild;
    private E userObject;
    enum ChildIndex { LEFT, RIGHT };

    private static StringBuffer buffer;
    private static ArrayList<String> bufferWithDepth;
    private static Queue q;

    public BNode() {
        // deliberately empty
    }

    public BNode(E userObject) {
        parent = null;
        leftChild = null;
        rightChild = null;
        this.userObject = userObject;
    }

    public String toString() {
        return userObject.toString();
    }

    public E getUserObject() {
        return userObject;
    }

    public BNode<E> getParent() {
        return parent;
    }

    public BNode<E> getLeftChild() {
        return leftChild;
    }

    public BNode<E> getRightChild() {
        return rightChild;
    }

    // non-safe
    public void setRightChild(BNode<E> node) {
        rightChild = node;
    }

    // non-safe
    public void setLeftChild(BNode<E> node) {
        leftChild = node;
    }

    // non-safe
    public void setParent(BNode<E> node) {
        parent = node;
    }


    // safely add a new node to this, first try as left child, otherwise as right child
    public void add(BNode<E> newChild) {
        if (leftChild == null)
            insert(newChild, ChildIndex.LEFT);
        else if (rightChild == null)
            insert(newChild, ChildIndex.RIGHT);
        else
            throw new IllegalArgumentException(
                    "more than 2 children");
    }

    // safely add a new node to this as left or right child
    public void insert(BNode<E> newChild, ChildIndex childIndex) {
        if (isAncestor(newChild))
            throw new IllegalArgumentException(
                    "new child is ancestor");
        if (childIndex != ChildIndex.LEFT &&
                childIndex != ChildIndex.RIGHT)
            throw new IllegalArgumentException(
                    "index is not 0 or 1");

        if (newChild != null) {
            BNode<E> oldParent = newChild.getParent();
            if (oldParent != null)
                oldParent.remove(newChild);
        }

        newChild.parent = this;
        if (childIndex == ChildIndex.LEFT)
            leftChild = newChild;
        else
            rightChild = newChild;
    }

    public void remove(BNode<E> aChild) {
        if (aChild == null)
            throw new IllegalArgumentException(
                    "argument is null");

        if (!isChild(aChild))
            throw new IllegalArgumentException(
                    "argument is not a child");

        if (aChild == leftChild) {
            leftChild.parent = null;
            leftChild = null;
        } else {
            rightChild.parent = null;
            rightChild = null;
        }
    }

    public boolean isChild(BNode<E> aNode) {
        return aNode == null ?
                false :
                aNode.getParent() == this;
    }

    public boolean isAncestor(BNode<E> aNode) {
        BNode<E> ancestor = this;
        while (ancestor != null && ancestor != aNode)
            ancestor = ancestor.getParent();
        return ancestor != null;
    }

    public Iterator iterator() {
        return new BNodeIterator();
    }

    private class BNodeIterator implements java.util.Iterator {
        private BNode<E> pos;
        private Deque<BNode<E>> stack;

        public BNodeIterator() {
            pos = BNode.this;
            stack = new LinkedList();
            stack.push(BNode.this);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public Object next() {
            BNode<E> node = stack.pop();
            if (node.rightChild != null)
                stack.push(node.rightChild);
            if (node.leftChild != null)
                stack.push(node.leftChild);
            return node.userObject;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }  // End of BNodeIterator


    // preOrderWithDepth returns the result of a preorder traversal including depth
    public ArrayList<String> preOrderWithDepth() {
        bufferWithDepth = new ArrayList<>();
        // call recursive method
        preOrder(0);
        return bufferWithDepth;
    }

    private void preOrder(int depth) {
        bufferWithDepth.add(depth + " " + userObject.toString());
        depth++;
        if (leftChild != null)
            leftChild.preOrder(depth);
        if (rightChild != null)
            rightChild.preOrder(depth);
    }

    // levelOrderToString() returns the result of a
    // level-order traversal in a string
    public String levelOrderToString() {
        buffer = new StringBuffer();
        q = new ArrayDeque<BNode<E>>();
        q.add(this);
        levelOrder();
        return buffer.toString();
    }

    private void levelOrder() {
        int depth = 0;
        while (!q.isEmpty()) {
            BNode<E> node = (BNode<E>) q.remove();
            buffer.append("level " + depth + ": " + node.userObject.toString() + "\n");
            depth++;
            if (node.leftChild != null)
                q.add(node.leftChild);
            if (node.rightChild != null)
                q.add(node.rightChild);
        }
    }

    public ArrayList toArrayList() {
        ArrayList array = new ArrayList();
        q = new ArrayDeque();
        q.add(this);
        q.add(new Integer(-1));
        levelOrderToArrayList(array);
        return array;
    }

    private void levelOrderToArrayList(ArrayList array) {
        int index = -1;
        int childnr = 0;
        final int TEMP = -1;

        while (!q.isEmpty()) {
            BNode<E> bParent = (BNode<E>) q.remove();
            int parentIndex = ((Integer) q.remove()).intValue();
            ANode<E> aParent = new ANode<E>(parentIndex, TEMP, TEMP, bParent.getUserObject());
            array.add(aParent);
            index++;
            if (bParent.leftChild != null) {
                q.add(bParent.leftChild);
                q.add(new Integer(index));
                childnr++;
                aParent.setLeft(childnr);
            }
            if (bParent.rightChild != null) {
                q.add(bParent.rightChild);
                q.add(new Integer(index));
                childnr++;
                aParent.setRight(childnr);
            }
        }
    }

    public static <E> BNode<E> toRealTreeEx(ArrayList array) {
        q = new ArrayDeque();
        q.add(array.get(0));
        q.add(null);
        return levelOrderToRealTree(array);

    }

    public static BNode toRealTree(ArrayList array) {
        q = new ArrayDeque();
        q.add(array.get(0));
        q.add(null);
        return levelOrderToRealTree(array);
    }

    private static BNode levelOrderToRealTree(ArrayList array) {
        BNode root = null;
        while (!q.isEmpty()) {
            ANode anode = (ANode) q.remove();
            BNode parent = (BNode) q.remove();
            BNode bnode = new BNode(anode.get());
            if (parent != null)
                parent.add(bnode);
            else
                root = bnode;

            int left = anode.getLeft();
            if (left != -1) {
                ANode alChild = (ANode) array.get(left);
                q.add(alChild);
                q.add(bnode);
            }

            int right = anode.getRight();
            if (right != -1) {
                ANode arChild = (ANode) array.get(right);
                q.add(arChild);
                q.add(bnode);
            }
        }
        return root;
    }
}

class ANode<E> {
    private int parent, left, right;
    private E userObject;

    public ANode(int parent, int left,
                 int right, E userObject) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.userObject = userObject;
    }

    public int getLeft() {
        return left;
    }


    public int getRight() {
        return right;
    }

    public E get() {
        return userObject;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public String toString() {
        return "[p" + parent + "," + left +
                "," + right + ", " + userObject.toString()
                + "]";
    }
}
