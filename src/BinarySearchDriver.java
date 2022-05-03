/*
Trent Blair
5/3/22
This program is used to test the binary search tree
 */

public class BinarySearchDriver {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println("should be true " + tree.isEmpty());

        System.out.println("should return 0 " + tree.size());

        System.out.println("should return false " + tree.contains("hello"));
        System.out.println("should return null " + tree.get("hello"));

        tree.put(1, "Robot");
        tree.put(2, "Dinosaur");

        System.out.println("should return false " + tree.isEmpty());

        System.out.println("should return 2 " + tree.size());

        System.out.println("should be Robot " + tree.get(1));
        System.out.println("should be Dinosaur " + tree.get(2));
        System.out.println("should return true " + tree.contains(2));
        System.out.println("should return 1 " + tree.min());
        System.out.println("should return 2 " + tree.max());

        tree.remove(2);

        System.out.println("should be one " + tree.size());
    }

}
