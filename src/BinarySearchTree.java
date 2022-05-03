/*
Trent Blair
5/3/22
This program is the binary search tree
 */

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    public Node<Key, Value> root;

    public BinarySearchTree() {//default constructor
    }

    public int size() {// gets the size
        return size(root);
    }

    private int size(Node x) {

        if(x == null){
            return 0;
        }else{

            return x.getSize() + size(x.getLeft()) + size(x.getRight());
        }
    }

    public boolean isEmpty() {//tests if it is empty
        return this.size() == 0;
    }


    public void put(Key key, Value value) {// puts a key value pair in
        root = put(root, key, value);
    }

    private Node<Key, Value> put(Node<Key, Value> n, Key key, Value val) {

        if(n == null){
            n = new Node(key, val, 1);
        }

        int check = key.compareTo(n.getKey());

        if(check > 0){
            n.setRight(put(n.getRight(), key, val));

        }else if(check < 0){
            n.setLeft(put(n.getLeft(), key, val));

        }

        return n;
    }


    public Value get(Key key) {//gets the value for the get
        return get(root, key);
    }


    private Value get(Node<Key, Value> n, Key key) {// another get method

        if(n == null){
            return null;
        }

        int sizeOfTree = this.size();
        int count = 0;


        int check = key.compareTo(n.getKey());


        if(count == sizeOfTree){
            return null;
        } else if(check > 0){
            count ++;
            return get(n.getRight(), key);
        }else if(check < 0){
            count++;
            return get(n.getLeft(), key);
        }else{
            return n.getValue();
        }
    }

    public boolean contains(Key key) {//checks is a key is contained in it

        boolean b = get(key) == null;
        return !b;
    }

    public Value remove(Key key) { // removes
        Value v = get(key);
        root = remove(root, key);
        return v;
    }

    private Node remove(Node<Key, Value> n, Key key) {
        if (n == null) return null;
        int i = key.compareTo(n.getKey());
        if (i < 0) {
            n.setLeft(remove(n.getLeft(), key));
        } else if (i > 0) {
            n.setRight(remove(n.getRight(), key));
        } else {
            if (n.getRight() == null) return n.getLeft();
            if (n.getLeft() == null) return n.getRight();
            Node min = min(n.getRight());
            min.setLeft(n.getLeft());
            n = n.getRight();
        }
        n.setSize(size(n.getRight()) + size(n.getLeft()) + 1);
        return n;
    }

    public Key min() {//gets the smallest key
        return min(root).getKey();
    }


    private Node<Key, Value> min(Node<Key, Value> n) {

        if(n.getLeft() == null){
            return n;
        }else{
            return min(n.getLeft());
        }
    }

    public Key max() {// gets the biggest key
        return max(root).getKey();
    }


    private Node<Key, Value> max(Node<Key, Value> n) {//another max mehtid

        if(n.getRight() == null){
            return n;
        }else{
            return max(n.getRight());
        }
    }

    public String toString() {// public toString
        String temp = toString(root);
        temp = temp.substring(0, temp.length() - 2);
        return "{" + temp + "}";
    }

    private String toString(Node<Key, Value> n) { // privet toString method
        if (n == null) return "";
        return toString(n.getLeft()) +
                n.getKey() + "=" + n.getValue() + ", " +
                toString(n.getRight());

    }
}