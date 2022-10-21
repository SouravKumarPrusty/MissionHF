public class DeleteLastNode {
 
    // Tree Node
    static class Node {
 
        Node left, right;
        int data;
 
        Node(int data)
        {
            this.data = data;
        }
    }
 
    // Method to perform inorder traversal
    public void inorder(Node root)
    {
        if (root == null)
            return;
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 
    // To keep track of last processed
    // nodes parent and node itself.
    public static Node lastNode;
    public static Node parentOfLastNode;
 
    // Method to get the height of the tree
    public int height(Node root)
    {
 
        if (root == null)
            return 0;
 
        int lheight = height(root.left) + 1;
        int rheight = height(root.right) + 1;
 
        return Math.max(lheight, rheight);
    }
 
    // Method to delete last leaf node
    public void deleteLastNode(Node root)
    {
 
        int levelOfLastNode = height(root);
 
        // Get all nodes at last level
        getLastNodeAndItsParent(root,
                                levelOfLastNode,
                                null);
 
        if (lastNode != null
            && parentOfLastNode != null) {
 
            if (parentOfLastNode.right != null)
                parentOfLastNode.right = null;
            else
                parentOfLastNode.left = null;
        }
        else
            System.out.println("Empty Tree");
    }
 
    // Method to keep track of parents
    // of every node
    public void getLastNodeAndItsParent(Node root,
                                        int level,
                                        Node parent)
    {
 
        if (root == null)
            return;
 
        // The last processed node in
        // Level Order Traversal has to
        // be the node to be deleted.
        // This will store the last
        // processed node and its parent.
        if (level == 1) {
            lastNode = root;
            parentOfLastNode = parent;
        }
        getLastNodeAndItsParent(root.left,
                                level - 1,
                                root);
        getLastNodeAndItsParent(root.right,
                                level - 1,
                                root);
    }
 
    // Driver Code
    public static void main(String[] args)
    {
 
        Node root = new Node(6);
        root.left = new Node(5);
        root.right = new Node(4);
        root.left.left = new Node(1);
        root.left.right = new Node(2);
        root.right.right = new Node(5);
 
        DeleteLastNode deleteLastNode = new DeleteLastNode();
 
        System.out.println("Inorder traversal "
                           + "before deletion "
                           + "of last node : ");
 
        deleteLastNode.inorder(root);
 
        deleteLastNode.deleteLastNode(root);
 
        System.out.println("\nInorder traversal "
                           + "after deletion of "
                           + "last node : ");
        deleteLastNode.inorder(root);
    }
}
