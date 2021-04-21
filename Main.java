
package avltree;


public class Main 
{
    Node raiz;
    private Main tree = new Main();
 
    int altura(Node N)
    {
        if (N == null)
            return 0;
 
        return N.altura;
    }
 
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
 
    Node rightRotate(Node y) {
        Node x = y.esq;
        Node T2 = x.dir;
 
        // Perform rotation
        x.dir = y;
        y.esq = T2;
 
        // Update heights
        y.altura = max(altura(y.esq), altura(y.dir)) + 1;
        x.altura = max(altura(x.esq), altura(x.dir)) + 1;
 
        // Return new root
        return x;
    }
 
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftRotate(Node x) {
        Node y = x.dir;
        Node T2 = y.esq;
 
        // Perform rotation
        y.esq = x;
        x.dir = T2;
 
        //  Update heights
        x.altura = max(altura(x.esq), altura(x.dir)) + 1;
        y.altura = max(altura(y.esq), altura(y.dir)) + 1;
 
        // Return new root
        return y;
    }
 
    // Get Balance factor of node N
    int getBalance(Node N) {
        if (N == null)
            return 0;
 
        return altura(N.esq) - altura(N.dir);
    }
 
    Node insert(Node node, int key) {
 
        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new Node(key));
 
        if (key < node.num)
            node.esq = insert(node.esq, key);
        else if (key > node.num)
            node.dir = insert(node.dir, key);
        else // Duplicate keys not allowed
            return node;
 
        /* 2. Update height of this ancestor node */
        node.altura = 1 + max(altura(node.esq),
                              altura(node.dir));
 
        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);
 
        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.esq.num)
            return rightRotate(node);
 
        // Right Right Case
        if (balance < -1 && key > node.dir.num)
            return leftRotate(node);
 
        // Left Right Case
        if (balance > 1 && key > node.esq.num) {
            node.esq = leftRotate(node.esq);
            return rightRotate(node);
        }
 
        // Right Left Case
        if (balance < -1 && key < node.dir.num) {
            node.dir = rightRotate(node.dir);
            return leftRotate(node);
        }
 
        /* return the (unchanged) node pointer */
        return node;
    }
 
    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node
    void preOrder(Node node) {
        if (node != null) {
            //System.out.print(node.num + " ");
            setPrintFrame(node.num + " ");
            preOrder(node.esq);
            preOrder(node.dir);
        }
    }
 
//    public static void main(String[] args) {
//        Main tree = new Main();
// 
//        /* Constructing tree given in the above figure */
//        tree.raiz = tree.insert(tree.raiz, 10);
//        tree.raiz = tree.insert(tree.raiz, 20);
//        tree.raiz = tree.insert(tree.raiz, 30);
//        tree.raiz = tree.insert(tree.raiz, 40);
//        tree.raiz = tree.insert(tree.raiz, 50);
//        tree.raiz = tree.insert(tree.raiz, 25);
// 
//        /* The constructed AVL Tree would be
//             30
//            /  \
//          20   40
//         /  \     \
//        10  25    50
//        */
//        System.out.println("Preorder traversal" +
//                        " of constructed tree is : ");
//        tree.preOrder(tree.raiz);
//    }

   
}
// This code has been contributed by Mayank Jaiswal

    

